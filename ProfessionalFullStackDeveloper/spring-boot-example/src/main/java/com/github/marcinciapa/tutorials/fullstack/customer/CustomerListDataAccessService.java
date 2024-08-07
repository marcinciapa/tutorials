package com.github.marcinciapa.tutorials.fullstack.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDao {

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(1L, "Alex", "alex@gmail.com", 21);
        Customer jamila = new Customer(2L, "Jamila", "jamila@gmail.com", 19);
        customers.add(alex);
        customers.add(jamila);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        return customers
                .stream()
                .filter(c -> id.equals(c.getId()))
                .findAny();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public void deleteCustomer(Long id) {
        customers.stream()
                .filter(c -> !id.equals(c.getId()))
                .findFirst()
                .ifPresent(customers::remove);
    }

    @Override
    public boolean existsPersonWithId(Long id) {
        return customers
                .stream()
                .anyMatch(c -> id.equals(c.getId()));
    }

    @Override
    public void updateCustomer(Customer customer) {
        deleteCustomer(customer.getId());
        insertCustomer(customer);
    }
}
