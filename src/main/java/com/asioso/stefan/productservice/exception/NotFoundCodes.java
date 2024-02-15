package com.asioso.stefan.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotFoundCodes {
    PRODUCT_NOT_FOUND(100);

    private final int value;

}
