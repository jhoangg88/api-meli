package com.mercadolibre.api_meli.domain.exceptions;

import com.mercadolibre.api_meli.infrastructure.controller.dto.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
    }

    @Nested
    @DisplayName("Pruebas para NotFoundException")
    class NotFoundExceptionTests {

        @Test
        void testHandleNotFound() {
            // Arrange
            NotFoundException exception = new NotFoundException("Producto no encontrado");
            WebRequest request = mock(WebRequest.class);
            when(request.getDescription(false)).thenReturn("uri=/api/products/123");

            // Act
            ResponseEntity<ErrorResponse> result = handler.handleNotFound(exception, request);

            // Assert
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
            assertThat(result.getStatusCodeValue()).isEqualTo(404);

            ErrorResponse body = result.getBody();
            assertThat(body).isNotNull();
            assertThat(body.message()).isEqualTo("Producto no encontrado");
            assertThat(body.status()).isEqualTo(404);
            assertThat(body.error()).isEqualTo("Not Found");
            assertThat(body.path()).isEqualTo("/api/products/123");
            assertThat(body.timestamp()).isBeforeOrEqualTo(LocalDateTime.now());
        }
    }

    @Nested
    @DisplayName("Pruebas para Exception genérica")
    class GenericExceptionTests {

        @Test
        void testHandleGeneric() {
            // Arrange
            Exception exception = new RuntimeException("Error interno inesperado");
            WebRequest request = mock(WebRequest.class);
            when(request.getDescription(false)).thenReturn("uri=/api/products/999");

            // Act
            ResponseEntity<ErrorResponse> result = handler.handleGeneric(exception, request);

            // Assert
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
            assertThat(result.getStatusCodeValue()).isEqualTo(500);

            ErrorResponse body = result.getBody();
            assertThat(body).isNotNull();
            assertThat(body.message()).isEqualTo("Error interno inesperado");
            assertThat(body.status()).isEqualTo(500);
            assertThat(body.error()).isEqualTo("Internal Server Error");
            assertThat(body.path()).isEqualTo("/api/products/999");
            assertThat(body.timestamp()).isBeforeOrEqualTo(LocalDateTime.now());
        }
    }
}
