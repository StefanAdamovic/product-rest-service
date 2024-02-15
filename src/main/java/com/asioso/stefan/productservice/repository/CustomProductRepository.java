package com.asioso.stefan.productservice.repository;

import com.asioso.stefan.productservice.model.Product;

import java.util.List;

public interface CustomProductRepository {
    List<Product> findAll(String sortField, String sortDirection, long limit, long offset);
}
