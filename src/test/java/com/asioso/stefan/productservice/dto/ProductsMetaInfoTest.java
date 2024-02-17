package com.asioso.stefan.productservice.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsMetaInfoTest {

    @Test
    void testValidProductsMetaInfo() {
        long start = 1;
        long limit = 10;
        long totalItemsCount = 100;
        String sortField = "name";
        String order = "asc";

        ProductsMetaInfo metaInfo = new ProductsMetaInfo(start, limit, totalItemsCount, sortField, order);

        assertEquals(start, metaInfo.getStart());
        assertEquals(limit, metaInfo.getLimit());
        assertEquals(totalItemsCount, metaInfo.getCount());
        assertNotNull(metaInfo.getNextLink(), "NextLink should not be null");
        assertEquals("/shop/v2/products?start=11&limit=10&sort=name&order=asc", metaInfo.getNextLink());
    }

}