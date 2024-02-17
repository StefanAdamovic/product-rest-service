package com.asioso.stefan.productservice.exception;

import com.asioso.stefan.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest // You may need to specify the controller class if there are multiple controllers
public class CustomControllerAdviceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    @Test
    public void whenProductNotFoundExceptionIsThrown_thenRespondWith404() throws Exception {
        // Given
        given(productService.getProductById(anyLong())).willThrow(new ProductNotFoundException("Product not found"));

        // When & Then
        mockMvc.perform(get("/shop/v2/products/{id}", 1L))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"httpCode\":404, \"errorCode\":100, \"message\":\"Product not found\"}"));
    }

}
