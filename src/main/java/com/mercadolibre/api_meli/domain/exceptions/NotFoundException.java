package com.mercadolibre.api_meli.domain.exceptions;

/** Custom exception for resources not found (404) */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
