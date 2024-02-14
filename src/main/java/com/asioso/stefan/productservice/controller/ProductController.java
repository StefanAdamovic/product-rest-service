package com.asioso.stefan.productservice.controller;

import com.asioso.stefan.productservice.model.ProductRequest;
import com.asioso.stefan.productservice.model.ProductResponse;
import com.asioso.stefan.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create product")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all products")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @Operation(summary = "Get product by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update product by ID")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequest updatedProduct) {
        return new ResponseEntity<>(productService.updateProduct(id, updatedProduct), HttpStatus.OK);
    }

    @Operation(summary = "Delete product by ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
