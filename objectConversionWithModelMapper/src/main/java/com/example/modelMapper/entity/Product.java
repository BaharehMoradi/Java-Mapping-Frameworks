package com.example.modelMapper.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 16)
    private Integer productID;

    @Column(name = "Name",nullable = false)
    private String productName;

    @Column(name = "Price",nullable = false)
    private float productPrice;

    @Column(name = "Quantity",nullable = false)
    private int productQuantity;

    @Column(name = "Brand")
    private String productBrand;

    @Column(name = "Weight")
    private float productWeight;

    @Column(name = "Color")
    private String productColor;
}
