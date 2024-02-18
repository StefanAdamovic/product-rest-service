package com.asioso.stefan.productservice.dto;

import com.asioso.stefan.productservice.model.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductResponseTest {


    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void validProductResponse() {
        Product product = new Product(1L, "ValidName");
        ProductResponse response = new ProductResponse(product);
        Set<ConstraintViolation<ProductResponse>> violations = validator.validate(response);

        assertTrue(violations.isEmpty(), "Expected no violations for a valid product response");
    }

    @Test
    void productResponseWithNullName() {
        Product product = new Product(1L, null);
        ProductResponse response = new ProductResponse(product);
        Set<ConstraintViolation<ProductResponse>> violations = validator.validate(response);

        assertFalse(violations.isEmpty(), "Expected violations for a null product name");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("Product name cannot be null")));
    }

    @Test
    void productResponseWithShortName() {
        Product product = new Product(1L, "A");
        ProductResponse response = new ProductResponse(product);
        Set<ConstraintViolation<ProductResponse>> violations = validator.validate(response);

        assertFalse(violations.isEmpty(), "Expected violations for a too short product name");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("Product name must be between 2 and 50 characters")));
    }

    @Test
    void productResponseWithNullId() {
        Product product = new Product(null, "ValidName");
        ProductResponse response = new ProductResponse(product);
        Set<ConstraintViolation<ProductResponse>> violations = validator.validate(response);

        assertFalse(violations.isEmpty(), "Expected violations for a null product ID");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("Product ID cannot be null")));
    }

}