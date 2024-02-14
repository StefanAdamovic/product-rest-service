package com.asioso.stefan.productservice.service.impl;

import com.asioso.stefan.productservice.model.Product;
import com.asioso.stefan.productservice.model.ProductRequest;
import com.asioso.stefan.productservice.model.ProductResponse;
import com.asioso.stefan.productservice.repository.ProductRepository;
import com.asioso.stefan.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//TODO Implement service
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest product) {
        Product createdProduct = productRepository.save(new Product(product));
        return new ProductResponse(createdProduct.getId(), createdProduct.getName(), "t");
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
