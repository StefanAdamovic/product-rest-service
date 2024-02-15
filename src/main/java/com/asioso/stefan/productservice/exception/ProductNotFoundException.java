package com.asioso.stefan.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException {

    private String message;

}
