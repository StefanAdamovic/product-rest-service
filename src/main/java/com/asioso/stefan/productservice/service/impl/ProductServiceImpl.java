package com.asioso.stefan.productservice.service.impl;

import com.asioso.stefan.productservice.model.ProductRequest;
import com.asioso.stefan.productservice.model.ProductResponse;
import com.asioso.stefan.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;


//TODO Implement service
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductResponse createProduct(ProductRequest product) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return null;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest updatedProduct) {
        return null;
    }

    @Override
    public ProductResponse deleteProduct(Long id) {
        return null;
    }
}
