package com.asioso.stefan.productservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductPageLinkGeneratorTests {

    @Test
    void generateNextLink_WhenMoreItemsExist() {
        String nextLink = ProductPageLinkGenerator.generateNextLink(0, 10, 100, "name", "asc");
        assertNotNull(nextLink);
        assertEquals("/shop/v2/products?start=10&limit=10&sort=name&order=asc", nextLink);
    }

    @Test
    void generateNextLink_ReturnsNull_WhenNoMoreItems() {
        String nextLink = ProductPageLinkGenerator.generateNextLink(90, 10, 100, "name", "asc");
        assertNull(nextLink);
    }

    @Test
    void generateNextLink_ChecksDifferentSortAndOrder() {
        String nextLink = ProductPageLinkGenerator.generateNextLink(20, 20, 100, "price", "desc");
        assertNotNull(nextLink);
        assertEquals("/shop/v2/products?start=40&limit=20&sort=price&order=desc", nextLink);
    }

    @Test
    void generateNextLink_HandlesEdgeCaseAtBoundary() {
        String nextLink = ProductPageLinkGenerator.generateNextLink(90, 10, 101, "name", "asc");
        assertNotNull(nextLink);
        assertEquals("/shop/v2/products?start=100&limit=10&sort=name&order=asc", nextLink);
    }
}
