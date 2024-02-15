package com.asioso.stefan.productservice.repository;

import com.asioso.stefan.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value =
            "SELECT * FROM product LIMIT :lim OFFSET :off"
            , nativeQuery = true)
    List<Product> findByLimitAndOffset(
            @Param("lim") long limit,
            @Param("off") long offset);

}
