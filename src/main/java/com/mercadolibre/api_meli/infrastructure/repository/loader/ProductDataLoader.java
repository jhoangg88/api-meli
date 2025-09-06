package com.mercadolibre.api_meli.infrastructure.repository.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.api_meli.domain.model.Product;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** load products from a JSON file.  */
@Component
public class ProductDataLoader {
    private final ResourceLoader resourceLoader;
    private final ObjectMapper om;


    public ProductDataLoader(ResourceLoader resourceLoader, ObjectMapper om) {
        this.resourceLoader = resourceLoader;
        this.om = om;
    }

    public List<Product> loadProducts() {
        try {
            Resource resource = resourceLoader.getResource("classpath:products.json");
            try (InputStream is = resource.getInputStream()) {
                return om.readValue(is, new TypeReference<>() {});
            }
        } catch (IOException e) {
            throw new IllegalStateException("Error loading products.json", e);
        }
    }
}
