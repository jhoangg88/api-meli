package com.mercadolibre.api_meli.infrastructure.repository;

import com.mercadolibre.api_meli.domain.model.Product;
import com.mercadolibre.api_meli.domain.repository.ProductRepository;
import com.mercadolibre.api_meli.infrastructure.repository.loader.ProductDataLoader;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JsonProductRepository implements ProductRepository {
    private final List<Product> products;

    public JsonProductRepository(ProductDataLoader loader) {
        this.products = loader.loadProducts();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}

