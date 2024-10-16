package com.github.marcinciapa.tutorials.springkafkatestcontainers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@TestPropertySource(
        properties = {
                "spring.kafka.consumer.auto-offset-reset=earliest",
                "spring.datasource.url=jdbc:tc:mysql:8.0.32:///db"
        }
)
@Testcontainers
class ProductPriceChangedEventHandlerTest {

    @Container
    static final KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.6.1"));

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        Product product = new Product(null, "P100", "Product One", BigDecimal.TEN);
        productRepository.save(product);
    }

    @Test
    void shouldHandleProductPriceChangeEvent() {
        ProductPriceChangedEvent event = new ProductPriceChangedEvent("P100", BigDecimal.ONE);

        kafkaTemplate.send("product-price-changes", event.productCode(), event);

        await()
                .pollInterval(Duration.ofSeconds(3))
                .atMost(Duration.ofSeconds(10))
                .untilAsserted(() -> {
                    Optional<Product> product = productRepository.findByCode("P100");
                    assertThat(product).isPresent();
                    assertThat(product.get().getCode()).isEqualTo("P100");
                    assertThat(product.get().getPrice()).isEqualTo(BigDecimal.ONE);
                });
    }
}
