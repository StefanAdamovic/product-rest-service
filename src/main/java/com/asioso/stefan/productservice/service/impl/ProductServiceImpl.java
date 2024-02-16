package com.asioso.stefan.productservice.service.impl;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.dto.ProductRequest;
import com.asioso.stefan.productservice.dto.ProductResponse;
import com.asioso.stefan.productservice.dto.ProductsMetaInfo;
import com.asioso.stefan.productservice.exception.ProductNotFoundException;
import com.asioso.stefan.productservice.model.Product;
import com.asioso.stefan.productservice.repository.ProductRepository;
import com.asioso.stefan.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        return new ProductResponse(createdProduct);
    }


    @Override
    public ProductPageResponse getAllProducts(long start, long limit, String sortField, String sortOrder) {

        if (start == 0)
            start = 1;

        List<Product> products = productRepository.findAll(sortField, sortOrder.toUpperCase(), limit, start - 1);


        List<ProductResponse> productResponses = products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());


        long totalItemsCount = productRepository.count();

        ProductsMetaInfo metaInfo = new ProductsMetaInfo(
                start,
                limit,
                totalItemsCount,
                sortField,
                sortOrder
        );

        return new ProductPageResponse(metaInfo, productResponses);
    }


    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Specified product does not exist!"));

        return new ProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Specified product does not exist!"));

        product.setName(productRequest.name());

        productRepository.save(product);

        return new ProductResponse(product);
    }

    @Override
    public ProductResponse deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Specified product does not exist!"));


        productRepository.deleteById(id);
        return new ProductResponse(product);

    }
}
