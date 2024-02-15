package com.asioso.stefan.productservice.dto;

import com.asioso.stefan.productservice.util.ProductPageLinkGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductsMetaInfo {

    private long count;
    private long start;
    private long limit;
    private String nextLink;
    @JsonIgnore
    private String sortField;
    @JsonIgnore
    private String order;

    public ProductsMetaInfo(long start, long limit, long totalItemsCount, String sortField, String order) {

        this.start = start;
        this.limit = limit;
        this.count = totalItemsCount;
        this.sortField = sortField;
        this.order = order;
        this.nextLink = ProductPageLinkGenerator.generateNextLink(start, limit, totalItemsCount, sortField, order);
    }
}
