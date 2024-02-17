package com.asioso.stefan.productservice.controller;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.dto.ProductResponse;
import com.asioso.stefan.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductMvcController.class)
public class ProductMvcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private ProductResponse product;
    private ProductPageResponse productPageResponse;

    @BeforeEach
    public void setup() {
        // Initialize your mock product response and product page response here
        product = new ProductResponse(); // Assume ProductResponse has appropriate fields and setters
        product.setId(1L);
        product.setName("Test Product");

        // Mock the service layer responses
        given(productService.getProductById(1L)).willReturn(product);

        productPageResponse = new ProductPageResponse(); // Initialize with default or mock values
        given(productService.getAllProducts(1, 10, "id", "asc")).willReturn(productPageResponse);
    }

    @Test
    public void listProducts_ShouldAddProductPageResponseToModelAndRenderProductsView() throws Exception {
        mockMvc.perform(get("/mvc/shop/v2/products")
                        .param("start", "1")
                        .param("limit", "10")
                        .param("sort", "id")
                        .param("order", "asc"))
                .andExpect(model().attributeExists("productPageResponse"))
                .andExpect(view().name("products"));
    }

    @Test
    public void showProduct_ShouldAddProductToModelAndRenderProductDetailView() throws Exception {
        mockMvc.perform(get("/mvc/shop/v2/products/{id}", 1))
                .andExpect(model().attributeExists("product"))
                .andExpect(model().attribute("product", product))
                .andExpect(view().name("productDetail"));
    }
}
