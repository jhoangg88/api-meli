package com.mercadolibre.api_meli.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Entity that represents the price of a product. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private String currency;
    private double amount;
    private int decimals;
}