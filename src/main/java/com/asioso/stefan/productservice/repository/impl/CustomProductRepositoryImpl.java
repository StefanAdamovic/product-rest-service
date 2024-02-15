package com.asioso.stefan.productservice.repository.impl;

import com.asioso.stefan.productservice.model.Product;
import com.asioso.stefan.productservice.repository.CustomProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomProductRepositoryImpl implements CustomProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll(String sortField, String sortDirection, long limit, long offset) {

        String sql = String.format("SELECT * FROM Product p ORDER BY %s %s LIMIT %d OFFSET %d",
                sortField, sortDirection, limit, offset);

        Query query = entityManager.createNativeQuery(sql, Product.class);
        List<?> result = query.getResultList();
        List<Product> products = new ArrayList<>();
        for (Object object : result) {
            if (object instanceof Product) {
                products.add((Product) object);
            }
        }
        return products;


    }
}
