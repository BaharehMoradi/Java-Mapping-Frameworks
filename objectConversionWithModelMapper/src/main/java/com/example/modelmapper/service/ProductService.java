package com.example.modelmapper.service;

import com.example.modelmapper.exception.ProductNotFoundException;
import com.example.modelmapper.entity.Product;
import com.example.modelmapper.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repo;

    public Product saveProduct(Product product) {
       return repo.save(product);
    }

    public Product getProduct(Integer id) throws ProductNotFoundException {
        Optional<Product> resultProduct = repo.findById(id);
        if (resultProduct.isPresent()) {
            return resultProduct.get();
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public List<Product> listAllProduct() {
        return repo.findAll();
    }


    public void deleteProduct(Integer id) throws ProductNotFoundException {

      if (repo.existsById(id)) {
        repo.deleteById(id);
    }
        else {
        throw new ProductNotFoundException();
    }
}

    public Product updateUser(Product product) throws ProductNotFoundException {
        if (!repo.existsById(product.getProductID())) {
            throw new ProductNotFoundException();
        }
        return repo.save(product);
    }


}
