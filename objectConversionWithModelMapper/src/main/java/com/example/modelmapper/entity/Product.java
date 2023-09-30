package com.example.modelmapper.entity;

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

    @Column(name = "name",nullable = false)
    private String productName;

    @Column(name = "price",nullable = false)
    private float productPrice;

    @Column(name = "quantity",nullable = false)
    private int productQuantity;

    @Column(name = "brand")
    private String productBrand;

    @Column(name = "weight")
    private float productWeight;

    @Column(name = "color")
    private String productColor;
}
