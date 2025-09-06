package com.mercadolibre.api_meli.infrastructure.controller;

import com.mercadolibre.api_meli.application.port.in.ProductUseCase;
import com.mercadolibre.api_meli.domain.model.Product;
import com.mercadolibre.api_meli.infrastructure.controller.dto.ProductResponseDto;
import com.mercadolibre.api_meli.infrastructure.controller.mapper.ProductMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/** Exposes REST API endpoints and delegates business logic to (ProductUseCase) */
@Slf4j
@Tag(name = "Product API", description = "API for product management")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ProductMapper productMapper;

    @Operation(summary = "List products")
    @ApiResponse(responseCode = "200", description = "List products",
            content = @Content(schema = @Schema(implementation = ProductResponseDto.class)))
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        log.info("*** Request received: GET /api/v1/products");
        List<Product> products = productUseCase.getAllProducts();
        return ResponseEntity.ok(productMapper.toDtoList(products));
    }

    @Operation(summary = "Get a product by ID")
    @ApiResponse(responseCode = "200", description = "Product found",
            content = @Content(schema = @Schema(implementation = ProductResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Product not found")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable String id) {
        log.info("*** Request received: GET /api/v1/products/{}", id);
        Product product = productUseCase.getProductById(id);
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}

