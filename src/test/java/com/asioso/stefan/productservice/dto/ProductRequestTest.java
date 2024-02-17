package com.asioso.stefan.productservice.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductRequestTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void validProductRequest() {
        ProductRequest productRequest = new ProductRequest("ValidName");
        Set<ConstraintViolation<ProductRequest>> violations = validator.validate(productRequest);
        assertTrue(violations.isEmpty(), "Expected no violations for a valid product name");
    }

    @Test
    void nameTooShort() {
        ProductRequest productRequest = new ProductRequest("A");
        Set<ConstraintViolation<ProductRequest>> violations = validator.validate(productRequest);
        assertFalse(violations.isEmpty(), "Expected a violation for a too short name");
        assertEquals(1, violations.size());
        assertEquals("Product name must be between 2 and 50 characters", violations.iterator().next().getMessage());
    }

    @Test
    void nameTooLong() {
        String longName = "A".repeat(51);
        ProductRequest productRequest = new ProductRequest(longName);
        Set<ConstraintViolation<ProductRequest>> violations = validator.validate(productRequest);
        assertFalse(violations.isEmpty(), "Expected a violation for a too long name");
        assertEquals(1, violations.size());
        assertEquals("Product name must be between 2 and 50 characters", violations.iterator().next().getMessage());
    }

    @Test
    void nameBlank() {
        ProductRequest productRequest = new ProductRequest(" ");
        Set<ConstraintViolation<ProductRequest>> violations = validator.validate(productRequest);
        assertFalse(violations.isEmpty(), "Expected a violation for a blank name or size");
        assertEquals(2, violations.size());
        assertEquals("Product name must be between 2 and 50 characters", violations.iterator().next().getMessage());
    }
}