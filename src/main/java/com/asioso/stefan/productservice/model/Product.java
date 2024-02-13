package com.asioso.stefan.productservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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

    @Size(min = 2, max = 50, message = "Product description must be between 10 and 50 characters")
    @Column(name = "description")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @Column(name = "price")
    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.0")
    @DecimalMax(value = "999999.99", inclusive = false, message = "Price must be less than 999999.99")
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}
