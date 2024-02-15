package com.asioso.stefan.productservice.service;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.dto.ProductRequest;
import com.asioso.stefan.productservice.dto.ProductResponse;

public interface ProductService {

    ProductResponse createProduct(ProductRequest product);

    ProductPageResponse getAllProducts(long start, long limit, String sortField, String sortOrder);


    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest updatedProduct);

    ProductResponse deleteProduct(Long id);
}
