package com.mercadolibre.api_meli.infrastructure.controller.mapper;

import com.mercadolibre.api_meli.domain.model.Product;
import com.mercadolibre.api_meli.infrastructure.controller.dto.ProductResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

/** Defines the conversion between the domain entity and the output DTO */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDto toDto(Product product);
    List<ProductResponseDto> toDtoList(List<Product> products);
}