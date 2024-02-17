package com.asioso.stefan.productservice.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductPageResponseTest {

    @Test
    public void testNoArgsConstructor() {
        ProductPageResponse response = new ProductPageResponse();
        assertNull(response.getMeta());
        assertNull(response.getProducts());
    }

    @Test
    public void testAllArgsConstructor() {
        ProductsMetaInfo meta = new ProductsMetaInfo();
        ProductResponse product1 = new ProductResponse();
        ProductResponse product2 = new ProductResponse();
        List<ProductResponse> products = Arrays.asList(product1, product2);

        ProductPageResponse response = new ProductPageResponse(meta, products);

        assertEquals(meta, response.getMeta());
        assertEquals(products, response.getProducts());
        assertEquals(2, response.getProducts().size());
    }

    @Test
    public void testSettersAndGetters() {
        ProductPageResponse response = new ProductPageResponse();

        ProductsMetaInfo meta = new ProductsMetaInfo(); // Adjust constructor or parameters as needed
        response.setMeta(meta);
        assertEquals(meta, response.getMeta());

        ProductResponse product1 = new ProductResponse(); // Adjust constructor or parameters as needed
        ProductResponse product2 = new ProductResponse(); // Adjust constructor or parameters as needed
        List<ProductResponse> products = Arrays.asList(product1, product2);
        response.setProducts(products);

        assertEquals(products, response.getProducts());
        assertEquals(2, response.getProducts().size());
    }

}