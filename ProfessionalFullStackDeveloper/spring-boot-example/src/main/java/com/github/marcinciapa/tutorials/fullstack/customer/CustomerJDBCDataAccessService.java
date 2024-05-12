package com.github.marcinciapa.tutorials.fullstack.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerJDBCDataAccessService implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerJDBCDataAccessService(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public boolean existsPersonWithId(Long id) {
        return false;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return false;
    }

    @Override
    public void insertCustomer(Customer customer) {
        var sql = """
                INSERT INTO customer (name, email, age)
                VALUES (?, ?, ?)
                """;

        int result = jdbcTemplate.update(
                sql,
                customer.getName(),
                customer.getEmail(),
                customer.getAge()
        );

        System.out.println("jdbcTEmplate.update = " + result);
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        var sql = """
                SELECT id, name, email, age
                FROM customer
                WHERE id=?
                """;

        return jdbcTemplate.query(sql, customerRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Customer> selectAllCustomers() {
        var sql = """
                SELECT id, name, email, age
                FROM customer
                """;

        return jdbcTemplate.query(sql, customerRowMapper);
    }
}
