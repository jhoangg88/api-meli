package com.mercadolibre.api_meli.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTest {

    @Test
    void testNoArgsConstructorAndSetters() {
        Price price = new Price();
        price.setCurrency("USD");
        price.setAmount(199.99);
        price.setDecimals(2);

        assertThat(price.getCurrency()).isEqualTo("USD");
        assertThat(price.getAmount()).isEqualTo(199.99);
        assertThat(price.getDecimals()).isEqualTo(2);
    }

    @Test
    void testAllArgsConstructor() {
        Price price = new Price("COP", 5000.50, 0);

        assertThat(price.getCurrency()).isEqualTo("COP");
        assertThat(price.getAmount()).isEqualTo(5000.50);
        assertThat(price.getDecimals()).isZero();

    }

    @Test
    void testEqualsAndHashCode() {
        Price p1 = new Price("EUR", 99.99, 2);
        Price p2 = new Price("EUR", 99.99, 2);
        Price p3 = new Price("EUR", 100.00, 2);

        assertThat(p1).isEqualTo(p2);
        assertThat(p1).hasSameHashCodeAs(p2);

        assertThat(p1).isNotEqualTo(p3);
        assertThat(p1.hashCode()).isNotEqualTo(p3.hashCode());
    }

    @Test
    void testToString() {
        Price price = new Price("JPY", 1200.0, 0);

        String toString = price.toString();

        assertThat(toString)
                .isNotNull()
                .contains("JPY")
                .contains("Price")
                .doesNotContain("USD");
    }
}
