package com.example.modelmapper;

import com.example.modelmapper.entity.Product;
import com.example.modelmapper.model.ProductDto;
import com.example.modelmapper.util.MapperMethods;
import com.example.modelmapper.util.ModelMapperConfig;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = ModelMapperConfig.class)
class ModelMapperTests {

    @Autowired
    MapperMethods mapperMethods;

//    @Autowired
//    private ModelMapper modelMapper;

    @Test
    void Test_mapProduct_To_ProductDto() {
        Product givenProduct=new Product();
        givenProduct.setProductID(1);
        givenProduct.setProductName("example1");
        givenProduct.setProductPrice(1500);
        givenProduct.setProductColor("Black");
        givenProduct.setProductBrand("Brand");
        givenProduct.setProductQuantity(10);
        givenProduct.setProductWeight((float) 0.95);
        ProductDto expectedProduct = mapperMethods.mapProductToProductDto(givenProduct);
        assertEquals(expectedProduct.getProductID(),givenProduct.getProductID());
        assertEquals(expectedProduct.getProductName(),givenProduct.getProductName());
    }
}
