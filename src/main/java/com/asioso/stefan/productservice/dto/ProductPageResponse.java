package com.asioso.stefan.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductPageResponse {

    private ProductsMetaInfo meta;
    private List<ProductResponse> products;

}
