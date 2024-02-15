package com.asioso.stefan.productservice.util;

public abstract class ProductLinkGenerator {

    private static final String BASE_URL = "/shop/v2/products";

    public static String generateSelfLinkForProduct(Long id) {
        return BASE_URL + "/" + id;
    }
}
