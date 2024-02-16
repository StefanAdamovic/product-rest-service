package com.asioso.stefan.productservice.controller;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc/shop/v2/products")
public class ProductMvcController {

    private final ProductService productService;

    @Autowired
    public ProductMvcController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listProducts(@RequestParam(value = "start", defaultValue = "1") int start,
                               @RequestParam(value = "limit", defaultValue = "10") int limit,
                               @RequestParam(value = "sortField", defaultValue = "id") String sortField,
                               @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder,
                               Model model) {

        ProductPageResponse products = productService.getAllProducts(start, limit, sortField, sortOrder);
        model.addAttribute("products", products.getProducts());
        return "products";
    }
}

