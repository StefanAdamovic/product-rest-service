package com.asioso.stefan.productservice.service.impl;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.dto.ProductRequest;
import com.asioso.stefan.productservice.dto.ProductResponse;
import com.asioso.stefan.productservice.exception.ProductNotFoundException;
import com.asioso.stefan.productservice.model.Product;
import com.asioso.stefan.productservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Use MockitoExtension to enable Mockito annotations
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private ProductRequest productRequest;
    private Product product;

    @BeforeEach
    void setUp() {
        // Initialize your test data here
        productRequest = new ProductRequest("Test Product");
        product = new Product(productRequest);
        product.setId(1L);
    }

    @Test
    void createProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        var response = productService.createProduct(productRequest);

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        assertEquals(product.getName(), response.getName());

        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void getProductById() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        var response = productService.getProductById(1L);

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        assertEquals(product.getName(), response.getName());

        verify(productRepository, times(1)).findById(anyLong());
    }

    @Test
    void getProductById_NotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(1L));

        verify(productRepository, times(1)).findById(anyLong());
    }

    @Test
    void getAllProducts_paginationAndSorting() {
        long start = 1;
        long limit = 5;
        String sortField = "name";
        String sortOrder = "ASC";
        long totalItemsCount = 10L;

        List<Product> mockProducts = IntStream.range(0, 5)
                .mapToObj(i -> new Product(new ProductRequest("Product " + i)))
                .collect(Collectors.toList());

        when(productRepository.findAll(anyString(), anyString(), anyLong(), anyLong())).thenReturn(mockProducts);
        when(productRepository.count()).thenReturn(totalItemsCount);

        ProductPageResponse response = productService.getAllProducts(start, limit, sortField, sortOrder);

        assertNotNull(response);
        assertEquals(limit, response.getMeta().getLimit());
        assertEquals(start, response.getMeta().getStart());
        assertEquals(totalItemsCount, response.getMeta().getCount());
        assertEquals(sortField, response.getMeta().getSortField());
        assertEquals(sortOrder, response.getMeta().getOrder());
        assertEquals(5, response.getProducts().size());

        verify(productRepository, times(1))
                .findAll(anyString(),
                        anyString(),
                        eq(limit),
                        eq(start - 1));
        verify(productRepository, times(1)).count();
    }

    @Test
    void updateProduct_successfulUpdate() {
        Long productId = 1L;
        ProductRequest updateRequest = new ProductRequest("Updated Product");
        Product existingProduct = new Product(new ProductRequest("Original Product"));
        existingProduct.setId(productId);

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ProductResponse updatedProductResponse = productService.updateProduct(productId, updateRequest);

        assertNotNull(updatedProductResponse);
        assertEquals("Updated Product", updatedProductResponse.getName());

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void deleteProduct_successfulDeletion() {
        Long productId = 1L;
        Product existingProduct = new Product(new ProductRequest("Product to Delete"));
        existingProduct.setId(productId);

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        doNothing().when(productRepository).deleteById(productId);

        ProductResponse deletedProductResponse = productService.deleteProduct(productId);

        assertNotNull(deletedProductResponse);
        assertEquals(productId, deletedProductResponse.getId());

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void deleteProduct_productNotFound() {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> productService.deleteProduct(productId));

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, never()).deleteById(anyLong());
    }






}
