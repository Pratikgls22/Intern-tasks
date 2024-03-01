package org.example.projection_springboot.controller;

import lombok.RequiredArgsConstructor;
import org.example.projection_springboot.dto.ApiResponse;
import org.example.projection_springboot.dto.RegisterRequestDTO;
import org.example.projection_springboot.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> create(@RequestBody RegisterRequestDTO requestDTO){
       this.productService.create(requestDTO);
       return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,"Product Added!",new HashMap<>()),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> search(){
        var response =  productService.search();
       return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,"Product received SuccessFully", response), HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ApiResponse> searchId(@PathVariable("id") int id) {
        var response = this.productService.searchId(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product received SuccessFully", response), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") int id, @RequestBody RegisterRequestDTO requestDTO) {
        this.productService.update(id, requestDTO);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product Update Successfully", new HashMap<>()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("id") int id) {
        this.productService.delete(id);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Product Delete Successfully", new HashMap<>()), HttpStatus.OK);
    }

    @GetMapping("/projection")
    public ResponseEntity<ApiResponse> projection(){
        var projection = this.productService.projection();
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,"Projection Match",projection),HttpStatus.OK);
    }
}
