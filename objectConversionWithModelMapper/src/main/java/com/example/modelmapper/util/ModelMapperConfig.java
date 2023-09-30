package com.example.modelmapper.util;

import com.example.modelmapper.entity.Product;
import com.example.modelmapper.model.ProductDetailsDto;
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
                map().setId(source.getProductID());
                map().setName(source.getProductName());
                map().setPrice(source.getProductPrice());
                map().setQuantity(source.getProductQuantity());
            }
        });
        modelMapper.validate(); // Perform validation on mapping configurations
        return modelMapper;
    }
}
