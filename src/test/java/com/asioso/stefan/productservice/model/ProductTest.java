package com.asioso.stefan.productservice.model;

import com.asioso.stefan.productservice.dto.ProductRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ProductTest {

    private Validator validator;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testProductNameLengthMinimum() {
        Product product = new Product(1L, "A");
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testProductNameLengthMaximum() {
        ProductRequest request = new ProductRequest("This is a very long product name exceeding fifty characters to test the maximum length constraint");
        Product product = new Product(request);
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testProductNameNotBlank() {
        ProductRequest request = new ProductRequest("");
        Product product = new Product(request);
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertFalse(violations.isEmpty());
    }
}
