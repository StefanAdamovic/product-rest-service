package com.asioso.stefan.productservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(@NotBlank(message = "Product name cannot be blank")
                             @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
                             String name) {
}
