package com.example.modelMapper.util;

import com.example.modelMapper.entity.Product;
import com.example.modelMapper.model.ProductDetailsDto;
import com.example.modelMapper.model.ProductDto;
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
    public ProductDto mapProduct_To_ProductDto(Product product){
        ProductDto productDto= modelMapper.map(product, ProductDto.class);
        return productDto;
    }
    /**
     * Mapping method for Product to ProductDto:
     * @param listProducts
     * @return ListProductDto
     */
    public List<ProductDto> mapListOfProduct_To_ListOfProductDto(List<Product> listProducts) {
        return listProducts.stream().map(entity -> mapProduct_To_ProductDto(entity))
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
