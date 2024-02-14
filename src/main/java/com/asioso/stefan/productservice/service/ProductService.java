package com.asioso.stefan.productservice.service;

import com.asioso.stefan.productservice.model.ProductRequest;
import com.asioso.stefan.productservice.model.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest product);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest updatedProduct);

    ProductResponse deleteProduct(Long id);
}
