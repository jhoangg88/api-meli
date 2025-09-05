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

@Slf4j
@Tag(name = "Product API", description = "API para la gestión de productos")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ProductMapper productMapper;

    @Operation(summary = "Listar productos")
    @ApiResponse(responseCode = "200", description = "Lista de productos",
            content = @Content(schema = @Schema(implementation = ProductResponseDto.class)))
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        log.info("*** Request received: GET /api/v1/products");
        List<Product> products = productUseCase.getAllProducts();
        return ResponseEntity.ok(productMapper.toDtoList(products));
    }

    @Operation(summary = "Obtener un producto por ID")
    @ApiResponse(responseCode = "200", description = "Producto encontrado",
            content = @Content(schema = @Schema(implementation = ProductResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable String id) {
        log.info("*** Request received: GET /api/v1/products/{}", id);
        Product product = productUseCase.getProductById(id);
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}

