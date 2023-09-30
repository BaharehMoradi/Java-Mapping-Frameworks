package com.example.modelmapper.model;

import lombok.Data;

@Data
public class ProductDisplayDto {


    private String productName;

    private float productPrice;

    private int productQuantity;

    private String productBrand;

    private int requestNumber;
}
