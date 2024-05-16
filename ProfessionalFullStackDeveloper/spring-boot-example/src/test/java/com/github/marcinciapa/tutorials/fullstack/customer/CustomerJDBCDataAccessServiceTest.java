package com.github.marcinciapa.tutorials.fullstack.customer;

import com.github.marcinciapa.tutorials.fullstack.AbstractTestcontainers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerJDBCDataAccessServiceTest extends AbstractTestcontainers {

    private CustomerJDBCDataAccessService underTest;
    private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();

    @BeforeEach
    void setUp() {
        underTest = new CustomerJDBCDataAccessService(
                getJdbcTemplate(),
                customerRowMapper
        );
    }

    @Test
    void updateCustomerName() {
    }

    @Test
    void updateCustomerEmail() {

    }

    @Test
    void updateCustomerAge() {

    }

    @Test
    void willUpdateAllPropertiesCustomer() {

    }

    @Test
    void willNotUpdateWhenNothingToUpdate() {

    }

    @Test
    void existsPersonWithId() {
    }

    @Test
    void existsPersonWithIdWillReturnFalseWhenIdNotPresent() {

    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void willThrowWhenDeleteCustomer() {
    }

    @Test
    void existsPersonWithEmail() {
    }

    @Test
    void existsPersonWithEmailReturnsFalseWhenDoesNotExists() {

    }

    @Test
    void insertCustomer() {
    }

    @Test
    void selectCustomerById() {
        // given
        String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer = new Customer(
                FAKER.name().fullName(),
                email,
                20
        );
        underTest.insertCustomer(customer);
        Long id = underTest.selectAllCustomers()
                .stream()
                .filter(c -> c.getEmail().equals(email))
                .map(Customer::getId)
                .findFirst()
                .orElseThrow();

        // when
        Optional<Customer> actual = underTest.selectCustomerById(id);

        // then
        assertThat(actual).isPresent().hasValueSatisfying(c -> {
            assertThat(c.getId()).isEqualTo(id);
            assertThat(c.getName()).isEqualTo(customer.getName());
            assertThat(c.getEmail()).isEqualTo(customer.getEmail());
            assertThat(c.getAge()).isEqualTo(customer.getAge());
        });
    }

    @Test
    void willReturnEmptyWhenSelectCustomerById() {
        // given
        long id = -1;

        // when
        Optional<Customer> actual = underTest.selectCustomerById(id);

        // then
        assertThat(actual).isEmpty();
    }

    @Test
    void selectAllCustomers() {
        // given
        Customer customer = new Customer(
                FAKER.name().fullName(),
                FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID(),
                20
        );
        underTest.insertCustomer(customer);

        // when
        List<Customer> actual = underTest.selectAllCustomers();

        // then
        assertThat(actual).isNotEmpty();
    }
}