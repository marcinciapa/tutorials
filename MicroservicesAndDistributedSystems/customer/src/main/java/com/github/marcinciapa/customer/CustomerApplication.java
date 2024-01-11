package com.github.marcinciapa.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.github.marcinciapa.customer",
                "com.github.marcinciapa.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.github.marcinciapa.clients"}
)
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
