package com.example.modelMapper.model;

import com.example.modelMapper.entity.Product;
import lombok.Data;

@Data
public class SaveResponse {
     private String message;
        private ProductDto product;
}
