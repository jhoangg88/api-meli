package com.mercadolibre.api_meli.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Entity that represents the image of a product. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
    private String url;
}