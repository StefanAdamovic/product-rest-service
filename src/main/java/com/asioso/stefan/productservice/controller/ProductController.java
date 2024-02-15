package com.asioso.stefan.productservice.controller;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.dto.ProductRequest;
import com.asioso.stefan.productservice.dto.ProductResponse;
import com.asioso.stefan.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop/v2/products")
@Validated
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create product")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@Valid @RequestBody ProductRequest product) {
        return productService.createProduct(product);
    }


    @Operation(summary = "Get all products")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductPageResponse getAllProducts(
            @RequestParam(value = "start", defaultValue = "1", required = false) long start,
            @RequestParam(value = "limit", defaultValue = "10", required = false) long limit,
            @RequestParam(value = "sort", defaultValue = "id", required = false) String sortField,
            @RequestParam(value = "order", defaultValue = "asc", required = false) String sortOrder) {

        return productService.getAllProducts(start, limit, sortField, sortOrder);
    }


    @Operation(summary = "Get product by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Operation(summary = "Update product by ID")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @Operation(summary = "Delete product by ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
