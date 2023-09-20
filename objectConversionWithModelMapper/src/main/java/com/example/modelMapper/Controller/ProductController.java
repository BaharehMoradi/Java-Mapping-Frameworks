package com.example.modelMapper.Controller;

import com.example.modelMapper.Service.ProductService;
import com.example.modelMapper.exception.ProductNotFoundException;
import com.example.modelMapper.entity.Product;
import com.example.modelMapper.model.ProductDetailsDto;
import com.example.modelMapper.model.ProductDto;
import com.example.modelMapper.model.SaveResponse;
import com.example.modelMapper.util.MapperMethods;
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
    /**
     * save new product:
     * @param product
     * @return ProductDetailsDto
     */
    @PostMapping("/addProduct")
    public ResponseEntity<?> add(@RequestBody @Valid Product product) {
        Product persistedProduct = productService.saveProduct(product);
        ProductDto persistedProductDto = mapperMethods.mapProduct_To_ProductDto(persistedProduct);
        SaveResponse response = new SaveResponse();
        response.setMessage("The product was saved with below information:");
        response.setProduct(persistedProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);//status code: 201
    }

    @GetMapping("/getProduct")
    public ResponseEntity<?> get(@RequestBody Integer id) {
        try {
            Product fetchedProduct = productService.getProduct(id);
            ProductDto fetchedProductDto = mapperMethods.mapProduct_To_ProductDto(fetchedProduct);
            return ResponseEntity.ok(fetchedProductDto);//status code: 200

        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no product with the entered id="+id+" to display!"); //status code: 404
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
                    .body("There is no product with the entered id=" + id + " to display!");
        }
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<?> list() {
        List<Product> listProducts = productService.listAllProduct();
        List<ProductDto> listProductsDto= mapperMethods.mapListOfProduct_To_ListOfProductDto(listProducts);
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
                    .body("There is no product with the entered id="+id+" to remove!");
        }
    }
}
