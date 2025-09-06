package com.mercadolibre.api_meli.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void testNoArgsConstructorAndSetters() {
        Product product = new Product();
        product.setId("P001");
        product.setName("Laptop");
        product.setPrice(new Price("USD", 1000, 1200));
        product.setSoldQuantity(50);
        product.setStock(10);
        product.setCondition("new");
        product.setPictures(List.of(new Picture("url1")));
        product.setDescription("High performance laptop");
        product.setCategories(List.of("Electronics", "Computers"));

        assertThat(product.getId()).isEqualTo("P001");
        assertThat(product.getName()).isEqualTo("Laptop");
        assertThat(product.getPrice().getCurrency()).isEqualTo("USD");
        assertThat(product.getSoldQuantity()).isEqualTo(50);
        assertThat(product.getStock()).isEqualTo(10);
        assertThat(product.getCondition()).isEqualTo("new");
        assertThat(product.getPictures()).hasSize(1);
        assertThat(product.getDescription()).isEqualTo("High performance laptop");
        assertThat(product.getCategories()).containsExactly("Electronics", "Computers");
    }

    @Test
    void testAllArgsConstructor() {
        Price price = new Price("COP", 3000, 3500);
        Product product = new Product(
                "P002",
                "Phone",
                price,
                20,
                5,
                "used",
                List.of(new Picture("url2")),
                "Second-hand phone",
                List.of("Electronics", "Phones")
        );

        assertThat(product.getId()).isEqualTo("P002");
        assertThat(product.getName()).isEqualTo("Phone");
        assertThat(product.getPrice()).isSameAs(price);
        assertThat(product.getSoldQuantity()).isEqualTo(20);
        assertThat(product.getStock()).isEqualTo(5);
        assertThat(product.getCondition()).isEqualTo("used");
        assertThat(product.getPictures()).hasSize(1);
        assertThat(product.getDescription()).isEqualTo("Second-hand phone");
        assertThat(product.getCategories()).contains("Phones");
    }

    @Test
    void testEqualsAndHashCode() {
        Price price = new Price("USD", 100, 120);
        Product p1 = new Product("P003", "Tablet", price, 5, 2, "new",
                List.of(new Picture("url")), "Nice tablet", List.of("Electronics"));
        Product p2 = new Product("P003", "Tablet", price, 5, 2, "new",
                List.of(new Picture("url")), "Nice tablet", List.of("Electronics"));
        Product p3 = new Product("P004", "Tablet Pro", price, 7, 3, "new",
                List.of(new Picture("url")), "Pro version", List.of("Electronics"));

        assertThat(p1).isEqualTo(p2);
        assertThat(p1).hasSameHashCodeAs(p2);

        assertThat(p1).isNotEqualTo(p3);
        assertThat(p1.hashCode()).isNotEqualTo(p3.hashCode());
    }

    @Test
    void testToString() {
        Product product = new Product();
        product.setId("P005");
        product.setName("Smartwatch");

        String toString = product.toString();

        assertThat(toString)
                .contains("P005")
                .contains("Smartwatch");
    }
}
