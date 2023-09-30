package com.example.modelmapper.model;

import lombok.Data;

@Data
public class SaveResponse {
     private String message;
        private ProductDto product;
}
