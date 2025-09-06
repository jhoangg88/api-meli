package com.mercadolibre.api_meli.infrastructure.controller.dto;

import java.time.LocalDateTime;

/** generalized error structure */
public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {}