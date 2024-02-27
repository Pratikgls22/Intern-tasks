package org.example.projection_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductProjectionDTO {
    private int id;
    private String name;
    private Double price;
    private int quanlity;
}
