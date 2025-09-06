package com.mercadolibre.api_meli.domain.repository;

import com.mercadolibre.api_meli.domain.model.Product;

import java.util.List;
import java.util.Optional;

/** defines the contract for access to product data */
public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(String id);
}
