package com.mercadolibre.api_meli.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Main entity that represents a product.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private Price price;
    @JsonProperty("sold_quantity")
    private int soldQuantity;
    private int stock;
    private String condition;
    private List<Picture> pictures;
    private String description;
    private List<String> categories;
}
