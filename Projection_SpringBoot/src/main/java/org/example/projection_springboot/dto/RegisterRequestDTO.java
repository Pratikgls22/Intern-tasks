package org.example.projection_springboot.dto;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String name;
    private Double price;
    private int quanlity;
    private String date;
    private Integer rating;
}
