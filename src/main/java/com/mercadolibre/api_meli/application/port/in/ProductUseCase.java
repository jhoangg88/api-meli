package com.mercadolibre.api_meli.application.port.in;

import com.mercadolibre.api_meli.domain.model.Product;
import java.util.List;

public interface ProductUseCase {
    Product getProductById(String id);
    List<Product> getAllProducts();
}