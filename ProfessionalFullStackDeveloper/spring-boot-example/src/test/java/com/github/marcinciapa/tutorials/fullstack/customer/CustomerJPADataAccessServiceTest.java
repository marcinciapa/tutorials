package com.github.marcinciapa.tutorials.fullstack.customer;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class CustomerJPADataAccessServiceTest {

    private CustomerJPADataAccessService underTest;
    private AutoCloseable autoCloseable;
    @Mock
    private CustomerRepository customerRepository;

    protected static Faker FAKER = new Faker();

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJPADataAccessService(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void selectCustomerById() {
        // given
        long id = 1;

        // when
        underTest.selectCustomerById(id);

        // then
        verify(customerRepository).findById(id);
    }

    @Test
    void selectAllCustomers() {
        // when
        underTest.selectAllCustomers();

        // then
        verify(customerRepository).findAll();
    }

    @Test
    void insertCustomer() {
        // given
        Customer customer = new Customer(
                1L,
                FAKER.name().fullName(),
                FAKER.internet().safeEmailAddress(),
                21
        );

        // when
        underTest.insertCustomer(customer);

        // then
        verify(customerRepository).save(customer);
    }

    @Test
    void existsPersonWithEmail() {
        // given
        String email = FAKER.internet().safeEmailAddress();

        // when
        underTest.existsPersonWithEmail(email);

        // then
        verify(customerRepository).existsCustomerByEmail(email);
    }

    @Test
    void deleteCustomer() {
        // given
        long id = 1;

        // when
        underTest.deleteCustomer(id);

        // then
        verify(customerRepository).deleteById(id);
    }

    @Test
    void existsPersonWithId() {
        // given
        long id = 1;

        // when
        underTest.existsPersonWithId(id);

        // then
        verify(customerRepository).existsCustomerById(id);
    }

    @Test
    void updateCustomer() {
        // given
        Customer customer = new Customer(
                1L,
                FAKER.name().fullName(),
                FAKER.internet().safeEmailAddress(),
                21
        );

        // when
        underTest.updateCustomer(customer);

        // then
        verify(customerRepository).save(customer);
    }
}