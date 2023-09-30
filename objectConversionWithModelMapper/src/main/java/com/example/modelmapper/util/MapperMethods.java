package com.example.modelmapper.util;

import com.example.modelmapper.entity.Product;
import com.example.modelmapper.model.ProductDetailsDto;
import com.example.modelmapper.model.ProductDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MapperMethods {
    private final ModelMapper modelMapper;
 /**
  * Mapping method for Product to ProductDto:
  * @param product
  * @return productDto
  */
    public ProductDto mapProductToProductDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }
    /**
     * Mapping method for Product to ProductDto:
     * @param listProducts
     * @return ListProductDto
     */
    public List<ProductDto> mapListOfProductToListOfProductDto(List<Product> listProducts) {
        return listProducts.stream().map(entity -> mapProductToProductDto(entity))
                .collect(Collectors.toList());
    }
    /**
     * Mapping method for Product to ProductDto:
     * @param product
     * @return ProductDetailsDto
     */
    public ProductDetailsDto mapProductToProductDetailsDto(Product product) {
        return modelMapper.map(product, ProductDetailsDto.class);
    }


}
