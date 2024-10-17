package com.github.marcinciapa.tutorials.springkafkatestcontainers;

import java.math.BigDecimal;

record ProductPriceChangedEvent(String productCode, BigDecimal price) {
}
