package com.mercadolibre.api_meli.domain.exceptions;

/**
 * Excepción personalizada para recursos no encontrados (404).
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
