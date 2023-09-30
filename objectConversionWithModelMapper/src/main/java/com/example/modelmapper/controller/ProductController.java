package com.example.modelmapper.controller;

import com.example.modelmapper.service.ProductService;
import com.example.modelmapper.exception.ProductNotFoundException;
import com.example.modelmapper.entity.Product;
import com.example.modelmapper.model.ProductDetailsDto;
import com.example.modelmapper.model.ProductDto;
import com.example.modelmapper.model.SaveResponse;
import com.example.modelmapper.util.MapperMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class ProductController {
    private final ProductService productService;

    private final MapperMethods mapperMethods;

    private static final String CONSTANTOUTSTRING = "There is no product with the entered id=";
    /**
     * save new product:
     * @param product
     * @return ProductDetailsDto
     */
    @PostMapping("/addProduct")
    public ResponseEntity<?> add(@RequestBody @Valid Product product) {
        Product persistedProduct = productService.saveProduct(product);
        ProductDto persistedProductDto = mapperMethods.mapProductToProductDto(persistedProduct);
        SaveResponse response = new SaveResponse();
        response.setMessage("The product was saved with below information:");
        response.setProduct(persistedProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);//status code: 201
    }

    @GetMapping("/getProduct")
    public ResponseEntity<?> get(@RequestBody Integer id) {
        try {
            Product fetchedProduct = productService.getProduct(id);
            ProductDto fetchedProductDto = mapperMethods.mapProductToProductDto(fetchedProduct);
            return ResponseEntity.ok(fetchedProductDto);//status code: 200

        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CONSTANTOUTSTRING +id+" to display!"); //status code: 404
        }
    }

    @GetMapping("/getProductDetails")
    public ResponseEntity<?> getProductDetails(@RequestBody Integer id) {
        try {
            Product fetchedProduct = productService.getProduct(id);
            ProductDetailsDto fetchedProductDetailsDto = mapperMethods.mapProductToProductDetailsDto(fetchedProduct);
            return ResponseEntity.ok(fetchedProductDetailsDto);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CONSTANTOUTSTRING + id + " to display!");
        }
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<?> list() {
        List<Product> listProducts = productService.listAllProduct();
        List<ProductDto> listProductsDto= mapperMethods.mapListOfProductToListOfProductDto(listProducts);
        if (listProducts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no product to display!");//status code: 404
        }
        return ResponseEntity.ok(listProductsDto);
    }


    @DeleteMapping("/deleteProduct")
    public ResponseEntity<?> delete(@RequestBody Integer id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok ("The product with id="+id+" was removed!");
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CONSTANTOUTSTRING +id+" to remove!");
        }
    }
}
