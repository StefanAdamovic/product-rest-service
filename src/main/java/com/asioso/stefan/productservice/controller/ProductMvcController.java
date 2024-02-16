package com.asioso.stefan.productservice.controller;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.dto.ProductResponse;
import com.asioso.stefan.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listProducts(@RequestParam(value = "start", defaultValue = "1") long start,
                               @RequestParam(value = "limit", defaultValue = "10") long limit,
                               @RequestParam(value = "sort", defaultValue = "id") String sortField,
                               @RequestParam(value = "order", defaultValue = "asc") String sortOrder,
                               Model model) {

        ProductPageResponse productPageResponse = productService.getAllProducts(start, limit, sortField, sortOrder);

        model.addAttribute("productPageResponse", productPageResponse);
        return "products";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        ProductResponse product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "productDetail";
    }
}

