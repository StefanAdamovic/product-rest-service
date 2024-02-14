package com.asioso.stefan.productservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductResponse(
        @NotNull(message = "Product ID cannot be null")
        Long id,

        @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
        @NotNull(message = "Product name cannot be null")
        String name,

        @NotNull(message = "Product name cannot be null")
        String self_link
) {
}
