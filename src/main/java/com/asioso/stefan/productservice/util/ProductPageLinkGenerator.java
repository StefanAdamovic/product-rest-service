package com.asioso.stefan.productservice.util;

public abstract class ProductPageLinkGenerator {

    private static final String BASE_URL = "/shop/v2/products";

    public static String generateNextLink(long start, long limit, long totalItemsCount, String sort, String order) {
        long nextStart = start + limit;

        if (nextStart >= totalItemsCount) {
            return null;
        }
        return String.format("%s?start=%d&limit=%d&sort=%s&order=%s", BASE_URL, nextStart, limit, sort, order);
    }
}
