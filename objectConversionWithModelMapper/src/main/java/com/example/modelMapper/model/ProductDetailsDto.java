package com.example.modelMapper.model;


import lombok.Data;

@Data
public class ProductDetailsDto {
    private Integer ID;
    private String Name;
    private float Price;
    private int Quantity;
}