package org.example.projection_springboot.service;

import org.example.projection_springboot.dto.ProductProjectionDTO;
import org.example.projection_springboot.dto.ProductResponseDTO;
import org.example.projection_springboot.dto.RegisterRequestDTO;

import java.util.List;

public interface ProductService {


    void create(RegisterRequestDTO requestDTO);

    List<ProductResponseDTO> search();

    ProductResponseDTO searchId(int id);

    void update(int id, RegisterRequestDTO requestDTO);

    void delete(int id);

    List<ProductProjectionDTO> projection();
}
