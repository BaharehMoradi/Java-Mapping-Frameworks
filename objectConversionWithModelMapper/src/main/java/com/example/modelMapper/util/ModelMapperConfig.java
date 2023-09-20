package com.example.modelMapper.util;

import com.example.modelMapper.entity.Product;
import com.example.modelMapper.model.ProductDetailsDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//      Mapping rule for Product to ProductDetailsDto when fields have different names:
        modelMapper.addMappings(new PropertyMap<Product, ProductDetailsDto>() {
            @Override
            protected void configure() {
                map().setID(source.getProductID());
                map().setName(source.getProductName());
                map().setPrice(source.getProductPrice());
                map().setQuantity(source.getProductQuantity());
            }
        });
        modelMapper.validate(); // Perform validation on mapping configurations
        return modelMapper;
    }
}
