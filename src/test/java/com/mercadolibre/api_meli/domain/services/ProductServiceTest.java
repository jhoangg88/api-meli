package com.mercadolibre.api_meli.domain.services;

import com.mercadolibre.api_meli.domain.exceptions.NotFoundException;
import com.mercadolibre.api_meli.domain.model.Picture;
import com.mercadolibre.api_meli.domain.model.Price;
import com.mercadolibre.api_meli.domain.model.Product;
import com.mercadolibre.api_meli.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleProduct = new Product(
                "P001",
                "Auriculares Bluetooth XYZ",
                new Price("COP", 30000, 0),
                150,
                90,
                "new",
                List.of(new Picture("https://.../1.jpg")),
                "Auriculares con cancelación de ruido.",
                List.of("Electrónica", "Audio")
        );
    }

    @Test
    @DisplayName("Debe retornar un producto cuando existe en el repositorio")
    void testGetProductById_Found() {
        when(productRepository.findById("P001")).thenReturn(Optional.of(sampleProduct));

        Product result = productService.getProductById("P001");

        assertNotNull(result);
        assertEquals("P001", result.getId());
        assertEquals("Auriculares Bluetooth XYZ", result.getName());
        assertEquals(30000, result.getPrice().getAmount());
        verify(productRepository).findById("P001");
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    @DisplayName("Debe lanzar NotFoundException cuando el producto no existe")
    void testGetProductById_NotFound() {
        when(productRepository.findById("NO_EXISTE")).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class,
                () -> productService.getProductById("NO_EXISTE"));

        assertTrue(ex.getMessage().contains("NO_EXISTE"));
        verify(productRepository).findById("NO_EXISTE");
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    @DisplayName("Debe retornar todos los productos cuando el repositorio tiene datos")
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(sampleProduct));

        List<Product> results = productService.getAllProducts();

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("P001", results.get(0).getId());
        verify(productRepository).findAll();
        verifyNoMoreInteractions(productRepository);
    }

    @Test
    @DisplayName("Debe retornar lista vacía cuando el repositorio no tiene productos")
    void testGetAllProducts_Empty() {
        when(productRepository.findAll()).thenReturn(List.of());

        List<Product> results = productService.getAllProducts();

        assertNotNull(results);
        assertTrue(results.isEmpty());
        verify(productRepository).findAll();
        verifyNoMoreInteractions(productRepository);
    }
}
