package com.github.marcinciapa.tutorials.fullstack.customer;

import com.github.marcinciapa.tutorials.fullstack.exception.DuplicateResourceException;
import com.github.marcinciapa.tutorials.fullstack.exception.RequestValidationException;
import com.github.marcinciapa.tutorials.fullstack.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jdbc") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Long id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id [%s] not found".formatted(id)));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        String email = customerRegistrationRequest.email();
        if (customerDao.existsPersonWithEmail(email)) {
            throw new DuplicateResourceException("email already taken");
        }
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                email,
                customerRegistrationRequest.age()
        );
        customerDao.insertCustomer(customer);
    }

    public void deleteCustomer(Long id) {
        if (!customerDao.existsPersonWithId(id)) {
            throw new ResourceNotFoundException("Customer with id [%s] not found".formatted(id));
        }
        customerDao.deleteCustomer(id);
    }

    public void updateCustomer(Long customerId, CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = getCustomer(customerId);

        boolean customerChanged = false;

        if (customerUpdateRequest.name() != null && !customerUpdateRequest.name().equals(customer.getName())) {
            customer.setName(customerUpdateRequest.name());
            customerChanged = true;
        }
        if (customerUpdateRequest.age() != null && !customerUpdateRequest.age().equals(customer.getAge())) {
            customer.setAge(customerUpdateRequest.age());
            customerChanged = true;
        }
        if (customerUpdateRequest.email() != null && !customerUpdateRequest.email().equals(customer.getEmail())) {
            if (customerDao.existsPersonWithEmail(customerUpdateRequest.email())) {
                throw new DuplicateResourceException("email already taken");
            }
            customer.setEmail(customerUpdateRequest.email());
            customerChanged = true;
        }

        if (!customerChanged) {
            throw new RequestValidationException("no data changes found");
        }

        customerDao.updateCustomer(customer);
    }
}
