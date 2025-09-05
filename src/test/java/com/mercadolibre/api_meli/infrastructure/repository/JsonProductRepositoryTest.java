package com.mercadolibre.api_meli.infrastructure.repository;

import com.mercadolibre.api_meli.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JsonProductRepositoryTest {

    @Autowired
    private JsonProductRepository jsonProductRepository;

    @Test
    void shouldLoadProductsFromJson() {
        List<Product> products = jsonProductRepository.findAll();
        assertThat(products).isNotEmpty();
    }

    @Test
    void shouldFindProductById() {
        Optional<Product> product = jsonProductRepository.findById("P001");
        assertThat(product).isPresent();
        assertThat(product.get().getName()).isNotBlank();
    }
}
