package org.example.projection_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private int id;
    private String name;
    private Double price;
    private int quanlity;
    private String date;
}
