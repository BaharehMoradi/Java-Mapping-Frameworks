package com.example.modelmapper.model;


import lombok.Data;

@Data
public class ProductDetailsDto {
    private Integer id;
    private String name;
    private float price;
    private int quantity;
}