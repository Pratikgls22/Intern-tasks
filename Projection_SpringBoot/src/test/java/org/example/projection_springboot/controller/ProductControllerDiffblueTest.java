package org.example.projection_springboot.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.example.projection_springboot.dto.ProductResponseDTO;
import org.example.projection_springboot.dto.RegisterRequestDTO;
import org.example.projection_springboot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ProductControllerDiffblueTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link ProductController#create(RegisterRequestDTO)}
     */
    @Test
    void testCreate() throws Exception {
        // Arrange
        doNothing().when(productService).create(Mockito.<RegisterRequestDTO>any());

        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setDate("2020-03-01");
        registerRequestDTO.setName("Name");
        registerRequestDTO.setPrice(10.0d);
        registerRequestDTO.setQuanlity(1);
        registerRequestDTO.setRating(1);
        String content = (new ObjectMapper()).writeValueAsString(registerRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/product/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"status\":200,\"message\":\"Product Added!\",\"data\":{}}"));
    }

    /**
     * Method under test: {@link ProductController#search()}
     */
    @Test
    void testSearch() throws Exception {
        // Arrange
        when(productService.search()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/search");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":200,\"message\":\"Product received SuccessFully\",\"data\":[]}"));
    }

    /**
     * Method under test: {@link ProductController#searchId(int)}
     */
    @Test
    void testSearchId() throws Exception {
        // Arrange
        when(productService.searchId(anyInt())).thenReturn(new ProductResponseDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/search/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":200,\"message\":\"Product received SuccessFully\",\"data\":{\"id\":0,\"name\":null,\"price\":null,"
                                        + "\"quanlity\":0,\"date\":null}}"));
    }

    /**
     * Method under test: {@link ProductController#searchId(int)}
     */
    @Test
    void testSearchId2() throws Exception {
        // Arrange
        when(productService.search()).thenReturn(new ArrayList<>());
        when(productService.searchId(anyInt())).thenReturn(new ProductResponseDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/search/{id}", "",
                "Uri Variables");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":200,\"message\":\"Product received SuccessFully\",\"data\":[]}"));
    }

    /**
     * Method under test: {@link ProductController#update(int, RegisterRequestDTO)}
     */
    @Test
    void testUpdate() throws Exception {
        // Arrange
        doNothing().when(productService).update(anyInt(), Mockito.<RegisterRequestDTO>any());

        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setDate("2020-03-01");
        registerRequestDTO.setName("Name");
        registerRequestDTO.setPrice(10.0d);
        registerRequestDTO.setQuanlity(1);
        registerRequestDTO.setRating(1);
        String content = (new ObjectMapper()).writeValueAsString(registerRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/product/update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":200,\"message\":\"Product Update Successfully\",\"data\":{}}"));
    }

    /**
     * Method under test: {@link ProductController#delete(int)}
     */
    @Test
    void testDelete() throws Exception {
        // Arrange
        doNothing().when(productService).delete(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/product/delete/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":200,\"message\":\"Product Delete Successfully\",\"data\":{}}"));
    }

    /**
     * Method under test: {@link ProductController#delete(int)}
     */
    @Test
    void testDelete2() throws Exception {
        // Arrange
        doNothing().when(productService).delete(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/product/delete/{id}", 1);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":200,\"message\":\"Product Delete Successfully\",\"data\":{}}"));
    }

    /**
     * Method under test: {@link ProductController#projection()}
     */
    @Test
    void testProjection() throws Exception {
        // Arrange
        when(productService.projection()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/projection");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"status\":200,\"message\":\"Projection Match\",\"data\":[]}"));
    }
}
