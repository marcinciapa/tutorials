package com.github.marcinciapa.tutorials.fullstack.customer;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerRowMapperTest {

    @Test
    void shouldExtractCustomer() throws SQLException {
        // given
        CustomerRowMapper underTest = new CustomerRowMapper();

        long id = 1;
        String name = "name";
        String email = "e@mai.l";
        int age = 20;

        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getLong("id")).thenReturn(id);
        when(resultSet.getString("name")).thenReturn(name);
        when(resultSet.getString("email")).thenReturn(email);
        when(resultSet.getInt("age")).thenReturn(age);

        // when
        Customer actual = underTest.mapRow(resultSet, 0);

        // then
        Customer expected = new Customer(id, name, email, age);
        assertThat(actual).isEqualTo(expected);
    }
}