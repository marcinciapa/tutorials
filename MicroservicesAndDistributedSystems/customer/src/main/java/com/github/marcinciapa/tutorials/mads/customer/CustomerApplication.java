package com.github.marcinciapa.tutorials.mads.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.github.marcinciapa.tutorials.mads.customer",
                "com.github.marcinciapa.tutorials.mads.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.github.marcinciapa.tutorials.mads.clients"}
)
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
