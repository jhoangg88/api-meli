package com.mercadolibre.api_meli.infrastructure.controller.mapper;

import com.mercadolibre.api_meli.domain.model.Product;
import com.mercadolibre.api_meli.infrastructure.controller.dto.ProductResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDto toDto(Product product);
    List<ProductResponseDto> toDtoList(List<Product> products);
}