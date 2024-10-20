package com.github.marcinciapa.tutorials.fullstack.customer;

import com.github.marcinciapa.tutorials.fullstack.AbstractTestcontainers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest extends AbstractTestcontainers {

    @Autowired
    private CustomerRepository underTest;

    @Test
    void existsCustomerById() {
        // given
        String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer = new Customer(
                FAKER.name().fullName(),
                email,
                20
        );
        underTest.save(customer);
        Long id = customerIdForEmail(email);

        // when
        boolean actual = underTest.existsCustomerById(id);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    void existsCustomerByIdFailsWhenIdNotPresent() {
        // given
        Long id = -1L;

        // when
        boolean actual = underTest.existsCustomerById(id);

        // then
        assertThat(actual).isFalse();
    }

    @Test
    void existsCustomerByEmail() {
        // given
        String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();
        Customer customer = new Customer(
                FAKER.name().fullName(),
                email,
                20
        );
        underTest.save(customer);

        // when
        boolean actual = underTest.existsCustomerByEmail(email);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    void existsCustomerByEmailFailsWhenEmailNotPresent() {
        // given
        String email = FAKER.internet().safeEmailAddress() + "-" + UUID.randomUUID();

        // when
        boolean actual = underTest.existsCustomerByEmail(email);

        // then
        assertThat(actual).isFalse();
    }

    private Long customerIdForEmail(String email) {
        return underTest.findAll()
                .stream()
                .filter(c -> c.getEmail().equals(email))
                .map(Customer::getId)
                .findFirst()
                .orElseThrow();
    }

}