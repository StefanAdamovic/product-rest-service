package com.asioso.stefan.productservice.dto;

import com.asioso.stefan.productservice.model.Product;
import com.asioso.stefan.productservice.util.ProductLinkGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductResponse {
    @NotNull(message = "Product ID cannot be null")
    private Long id;

    @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
    @NotNull(message = "Product name cannot be null")
    private String name;

    @NotNull(message = "Product link cannot be null")
    private String selfLink;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.selfLink = ProductLinkGenerator.generateSelfLinkForProduct(product.getId());
    }

}
