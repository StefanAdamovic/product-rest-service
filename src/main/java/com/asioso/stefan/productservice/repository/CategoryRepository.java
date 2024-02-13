package com.asioso.stefan.productservice.repository;

import com.asioso.stefan.productservice.model.Category;
import com.asioso.stefan.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
