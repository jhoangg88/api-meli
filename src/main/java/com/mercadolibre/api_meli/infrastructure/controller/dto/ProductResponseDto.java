package com.mercadolibre.api_meli.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/** (DTO) represents products */
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