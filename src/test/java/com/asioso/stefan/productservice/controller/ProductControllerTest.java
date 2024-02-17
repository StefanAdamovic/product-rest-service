package com.asioso.stefan.productservice.controller;

import com.asioso.stefan.productservice.dto.ProductPageResponse;
import com.asioso.stefan.productservice.dto.ProductRequest;
import com.asioso.stefan.productservice.dto.ProductResponse;
import com.asioso.stefan.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    // Example product data
    private ProductResponse productResponse;
    private ProductPageResponse productPageResponse;

    @BeforeEach
    public void setup() {
        // Initialize with default values
        productResponse = new ProductResponse();
        productResponse.setId(1L);
        productResponse.setName("Test Product");

        // Mock the service layer for different scenarios
        given(productService.createProduct(any(ProductRequest.class))).willReturn(productResponse);
        given(productService.getProductById(anyLong())).willReturn(productResponse);
        // Ensure this mock behavior reflects the update operation correctly
        given(productService.updateProduct(eq(1L), any(ProductRequest.class)))
                .willAnswer(invocation -> {
                    ProductRequest request = invocation.getArgument(1);
                    productResponse.setName(request.name());
                    return productResponse;
                });
        given(productService.deleteProduct(anyLong())).willReturn(productResponse);
    }

    @Test
    public void createProductTest() throws Exception {
        mockMvc.perform(post("/shop/v2/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Product\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Test Product"));
    }

    @Test
    public void getAllProductsTest() throws Exception {
        // Assuming productPageResponse is properly initialized in setup()
        given(productService.getAllProducts(anyLong(), anyLong(), anyString(), anyString())).willReturn(productPageResponse);

        mockMvc.perform(get("/shop/v2/products")
                        .param("start", "1")
                        .param("limit", "10"))
                .andExpect(status().isOk());
        // Further assertions can be made based on the structure of ProductPageResponse
    }

    @Test
    public void getProductByIdTest() throws Exception {
        mockMvc.perform(get("/shop/v2/products/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }


    @Test
    public void updateProductTest() throws Exception {
        String updatedProductName = "Updated Product";
        mockMvc.perform(put("/shop/v2/products/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"" + updatedProductName + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(updatedProductName));
    }

    @Test
    public void deleteProductTest() throws Exception {
        mockMvc.perform(delete("/shop/v2/products/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }
}
