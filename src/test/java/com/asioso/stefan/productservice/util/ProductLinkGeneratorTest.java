package com.asioso.stefan.productservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductLinkGeneratorTest {

    @Test
    void testGenerateSelfLinkForProduct() {
        Long productId = 123L;
        String expectedLink = "/shop/v2/products/123";

        String actualLink = ProductLinkGenerator.generateSelfLinkForProduct(productId);

        assertEquals(expectedLink, actualLink, "The generated link does not match the expected output.");
    }
}
