package com.mercadolibre.api_meli.application.port.in;

import com.mercadolibre.api_meli.domain.model.Product;
import java.util.List;

/**Define the main use cases for product management*/
public interface ProductUseCase {
    Product getProductById(String id);
    List<Product> getAllProducts();
}