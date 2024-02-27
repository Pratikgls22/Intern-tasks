package org.example.projection_springboot.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.projection_springboot.dto.ProductProjectionDTO;
import org.example.projection_springboot.dto.ProductResponseDTO;
import org.example.projection_springboot.dto.RegisterRequestDTO;
import org.example.projection_springboot.entity.Product;
import org.example.projection_springboot.exception.CustomException;
import org.example.projection_springboot.projection.ProductProjection;
import org.example.projection_springboot.repository.ProductRepo;
import org.example.projection_springboot.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    public ProductResponseDTO mapToProductResponseDto(Product product) {
        return modelMapper.map(product, ProductResponseDTO.class);
    }
    @Override
    public void create(RegisterRequestDTO requestDTO) {
        try{
            Product product = new Product();
            product.setName(requestDTO.getName());
            product.setPrice(requestDTO.getPrice());
            product.setQuanlity(requestDTO.getQuanlity());
            product.setDate(requestDTO.getDate());
            product.setRating(requestDTO.getRating());

            productRepo.save(product);
        }
        catch(CustomException e){
            throw new CustomException(e.getMessage(), e.getHttpStatus());
        }
    }

    @Override
    public List<ProductResponseDTO> search() {
        try {
            return this.productRepo.findAll().stream().
            map(this::mapToProductResponseDto).collect(Collectors.toList());
        }
        catch (CustomException e) {
            throw new CustomException(e.getMessage(), e.getHttpStatus());
        }
    }

    @Override
    public ProductResponseDTO searchId(int id) {
        try {
            var product = this.productRepo.findById(id);
            if (product.isEmpty()) {
                throw new CustomException("Product Not Found", HttpStatus.NOT_FOUND);

            }
            return this.modelMapper.map(product.get(), ProductResponseDTO.class);
        } catch (CustomException e) {
            throw new CustomException(e.getMessage(), e.getHttpStatus());
        }
    }

    @Override
    public void update(int id, RegisterRequestDTO requestDTO) {
        try {
            var product = productRepo.findById(id);
            if (product.isEmpty()) {
                throw new CustomException("Product Not Found", HttpStatus.NOT_FOUND);
            }
            Product productEntity = product.get();
            productEntity.setName(requestDTO.getName());
            productEntity.setPrice(requestDTO.getPrice());
            productEntity.setQuanlity(requestDTO.getQuanlity());
            productEntity.setDate(requestDTO.getDate());
            productEntity.setRating(requestDTO.getRating());
            this.productRepo.save(productEntity);

        } catch (CustomException e) {
            throw new CustomException(e.getMessage(), e.getHttpStatus());
        }
    }

    @Override
    public void delete(int id) {
        try {
            var product = productRepo.findById(id);
            if (product.isEmpty()) {
                throw new CustomException("Product Not Found", HttpStatus.NOT_FOUND);
            }
            this.productRepo.deleteById(id);
        } catch (CustomException e) {
            throw new CustomException(e.getMessage(), e.getHttpStatus());
        }
    }

    @Override
    public List<ProductProjectionDTO> projection() {
        List<ProductProjection> productProjections = this.productRepo.getProductsWithRequeriedAttributes();
        List<ProductProjectionDTO> productDTOS = new ArrayList<ProductProjectionDTO>();
        for (ProductProjection projection : productProjections ){
            productDTOS.add(new ProductProjectionDTO(
                    projection.getId(),
                    projection.getName(),
                    projection.getPrice(),
                    projection.getQuanlity()));
        }
        return productDTOS;
    }

}
