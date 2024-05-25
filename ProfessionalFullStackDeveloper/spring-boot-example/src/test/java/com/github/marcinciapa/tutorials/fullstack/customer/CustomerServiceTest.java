package com.github.marcinciapa.tutorials.fullstack.customer;

import com.github.marcinciapa.tutorials.fullstack.exception.DuplicateResourceException;
import com.github.marcinciapa.tutorials.fullstack.exception.RequestValidationException;
import com.github.marcinciapa.tutorials.fullstack.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerDao);
    }

    @Test
    void getAllCustomers() {
        // when
        underTest.getAllCustomers();

        // then
        verify(customerDao).selectAllCustomers();
    }

    @Test
    void canGetCustomer() {
        // given
        long id = 10;
        Customer customer = new Customer(id, "Alex", "alex@gmail.com", 19);
        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(customer));

        // when
        Customer actual = underTest.getCustomer(id);

        // then
        assertThat(actual).isEqualTo(customer);
    }

    @Test
    void willThrowWhenGetCustomerReturnsEmptyOptional() {
        // given
        long id = 10;
        when(customerDao.selectCustomerById(id)).thenReturn(Optional.empty());

        // when
        // then
        assertThatThrownBy(() -> underTest.getCustomer(id))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Customer with id [%s] not found".formatted(id));
    }

    @Test
    void addCustomer() {
        // given
        String email = "alex@gmail.com";
        when(customerDao.existsPersonWithEmail(email)).thenReturn(false);
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("Alex", email, 19);

        // when
        underTest.addCustomer(request);

        // then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

        verify(customerDao).insertCustomer(customerArgumentCaptor.capture());

        Customer capturedCustomer = customerArgumentCaptor.getValue();
        assertThat(capturedCustomer.getId()).isNull();
        assertThat(capturedCustomer.getName()).isEqualTo(request.name());
        assertThat(capturedCustomer.getEmail()).isEqualTo(request.email());
        assertThat(capturedCustomer.getAge()).isEqualTo(request.age());
    }

    @Test
    void willThrowWhenEmailExistsWhileAddingCustomer() {
        // given
        String email = "alex@gmail.com";
        when(customerDao.existsPersonWithEmail(email)).thenReturn(true);
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("Alex", email, 19);

        // when
        assertThatThrownBy(() -> underTest.addCustomer(request))
                .isInstanceOf(DuplicateResourceException.class)
                .hasMessage("email already taken");

        // then
        verify(customerDao, never()).insertCustomer(any());
    }

    @Test
    void deleteCustomer() {
        // given
        long id = 10;
        when(customerDao.existsPersonWithId(id)).thenReturn(true);

        // when
        underTest.deleteCustomer(id);

        // then
        verify(customerDao).deleteCustomer(id);
    }

    @Test
    void willThrowWhenPersonNotExistsWhileDeletingCustomer() {
        // given
        long id = 10;
        when(customerDao.existsPersonWithId(id)).thenReturn(false);

        // when
        assertThatThrownBy(() -> underTest.deleteCustomer(id))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Customer with id [%s] not found".formatted(id));

        // then
        verify(customerDao, never()).deleteCustomer(any());
    }

    @Test
    void willThrowWhenUpdatedCustomerDoesNotExist() {
        // given
        long id = 10;
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(null, null, null);
        when(customerDao.selectCustomerById(id)).thenReturn(Optional.empty());

        // when
        assertThatThrownBy(() -> underTest.updateCustomer(id, updateRequest))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Customer with id [%s] not found".formatted(id));

        // then
        verify(customerDao, never()).updateCustomer(any());
    }

    @Test
    void updateCustomer() {
        // given
        long id = 10;

        String oldName = "old name";
        String oldEmail = "old@ema.il";
        int oldAge = 20;

        String newName = "new name";
        String newEmail = "new@ema.il";
        int newAge = 21;

        Customer existingCustomer = new Customer(id, oldName, oldEmail, oldAge);
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(newName, newEmail, newAge);

        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(existingCustomer));
        when(customerDao.existsPersonWithEmail(newEmail)).thenReturn(false);

        // when
        underTest.updateCustomer(id, updateRequest);

        // then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();

        assertThat(capturedCustomer.getName()).isEqualTo(newName);
        assertThat(capturedCustomer.getEmail()).isEqualTo(newEmail);
        assertThat(capturedCustomer.getAge()).isEqualTo(newAge);
    }

    @Test
    void updateCustomerName() {
        // given
        long id = 10;

        String oldName = "old name";
        String oldEmail = "old@ema.il";
        int oldAge = 20;

        String newName = "new name";

        Customer existingCustomer = new Customer(id, oldName, oldEmail, oldAge);
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(newName, null, null);

        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(existingCustomer));

        // when
        underTest.updateCustomer(id, updateRequest);

        // then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();

        assertThat(capturedCustomer.getName()).isEqualTo(newName);
        assertThat(capturedCustomer.getEmail()).isEqualTo(oldEmail);
        assertThat(capturedCustomer.getAge()).isEqualTo(oldAge);
    }

    @Test
    void updateCustomerAge() {
        // given
        long id = 10;

        String oldName = "old name";
        String oldEmail = "old@ema.il";
        int oldAge = 20;

        int newAge = 21;

        Customer existingCustomer = new Customer(id, oldName, oldEmail, oldAge);
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(null, null, newAge);

        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(existingCustomer));

        // when
        underTest.updateCustomer(id, updateRequest);

        // then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();

        assertThat(capturedCustomer.getName()).isEqualTo(oldName);
        assertThat(capturedCustomer.getEmail()).isEqualTo(oldEmail);
        assertThat(capturedCustomer.getAge()).isEqualTo(newAge);
    }

    @Test
    void willThrowWhenUpdateCustomerEmailAlreadyExists() {
        // given
        long id = 10;

        String oldName = "old name";
        String oldEmail = "old@ema.il";
        int oldAge = 20;

        String newEmail = "new@ema.il";

        Customer existingCustomer = new Customer(id, oldName, oldEmail, oldAge);
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(null, newEmail, null);

        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(existingCustomer));
        when(customerDao.existsPersonWithEmail(newEmail)).thenReturn(true);

        // when
        assertThatThrownBy(() -> underTest.updateCustomer(id, updateRequest))
                .isInstanceOf(DuplicateResourceException.class)
                .hasMessage("email already taken");

        // then
        verify(customerDao, never()).updateCustomer(any());
    }

    @Test
    void updateCustomerEmail() {
        // given
        long id = 10;

        String oldName = "old name";
        String oldEmail = "old@ema.il";
        int oldAge = 20;

        String newEmail = "new@ema.il";

        Customer existingCustomer = new Customer(id, oldName, oldEmail, oldAge);
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(null, newEmail, null);

        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(existingCustomer));
        when(customerDao.existsPersonWithEmail(newEmail)).thenReturn(false);

        // when
        underTest.updateCustomer(id, updateRequest);

        // then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerDao).updateCustomer(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();

        assertThat(capturedCustomer.getName()).isEqualTo(oldName);
        assertThat(capturedCustomer.getEmail()).isEqualTo(newEmail);
        assertThat(capturedCustomer.getAge()).isEqualTo(oldAge);
    }

    @Test
    void willThrowWhenUpdateCustomerNoChange() {
        // given
        long id = 10;

        String oldName = "old name";
        String oldEmail = "old@ema.il";
        int oldAge = 20;

        Customer existingCustomer = new Customer(id, oldName, oldEmail, oldAge);
        CustomerUpdateRequest updateRequest = new CustomerUpdateRequest(oldName, oldEmail, oldAge);

        when(customerDao.selectCustomerById(id)).thenReturn(Optional.of(existingCustomer));

        // when
        assertThatThrownBy(() -> underTest.updateCustomer(id, updateRequest))
                .isInstanceOf(RequestValidationException.class)
                .hasMessage("no data changes found");

        // then
        verify(customerDao, never()).updateCustomer(any());
    }
}