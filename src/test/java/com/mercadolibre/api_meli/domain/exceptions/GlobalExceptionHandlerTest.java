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
    @DisplayName("Test for NotFoundException")
    class NotFoundExceptionTests {

        @Test
        void testHandleNotFound() {
            // Arrange
            NotFoundException exception = new NotFoundException("Product not found");
            WebRequest request = mock(WebRequest.class);
            when(request.getDescription(false)).thenReturn("uri=/api/products/123");

            // Act
            ResponseEntity<ErrorResponse> result = handler.handleNotFound(exception, request);

            // Assert
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
            assertThat(result.getStatusCode().value()).isEqualTo(404);

            ErrorResponse body = result.getBody();
            assertThat(body).isNotNull();
            assertThat(body.message()).isEqualTo("Product not found");
            assertThat(body.status()).isEqualTo(404);
            assertThat(body.error()).isEqualTo("Not Found");
            assertThat(body.path()).isEqualTo("/api/products/123");
            assertThat(body.timestamp()).isBeforeOrEqualTo(LocalDateTime.now());
        }
    }

    @Nested
    @DisplayName("Test for generic exception")
    class GenericExceptionTests {

        @Test
        void testHandleGeneric() {
            // Arrange
            Exception exception = new RuntimeException("Unexpected internal error");
            WebRequest request = mock(WebRequest.class);
            when(request.getDescription(false)).thenReturn("uri=/api/products/999");

            // Act
            ResponseEntity<ErrorResponse> result = handler.handleGeneric(exception, request);

            // Assert
            assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
            assertThat(result.getStatusCode().value()).isEqualTo(500);

            ErrorResponse body = result.getBody();
            assertThat(body).isNotNull();
            assertThat(body.message()).isEqualTo("Unexpected internal error");
            assertThat(body.status()).isEqualTo(500);
            assertThat(body.error()).isEqualTo("Internal Server Error");
            assertThat(body.path()).isEqualTo("/api/products/999");
            assertThat(body.timestamp()).isBeforeOrEqualTo(LocalDateTime.now());
        }
    }
}
