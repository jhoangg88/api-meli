package com.mercadolibre.api_meli.domain.services;


import com.mercadolibre.api_meli.application.port.in.ProductUseCase;
import com.mercadolibre.api_meli.domain.exceptions.NotFoundException;
import com.mercadolibre.api_meli.domain.model.Product;
import com.mercadolibre.api_meli.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product getProductById(String id) {
        log.info("Fetching product {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Fetching all products");
        return productRepository.findAll();
    }
}