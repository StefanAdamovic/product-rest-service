package com.asioso.stefan.productservice.model;


import com.asioso.stefan.productservice.dto.ProductRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
    @Column(name = "name")
    @NotBlank(message = "Product name cannot be blank")
    private String name;

    public Product(ProductRequest request) {
        this.name = request.name();
    }
}
