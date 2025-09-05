package com.mercadolibre.api_meli.infrastructure.controller.dto;

import com.mercadolibre.api_meli.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private String id;
    private String name;
    private PriceDto price;
    private int stock;
    private List<PictureDto> pictures;
}