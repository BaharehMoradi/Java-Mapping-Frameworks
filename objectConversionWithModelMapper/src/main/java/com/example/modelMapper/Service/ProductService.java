package com.example.modelMapper.Service;

import com.example.modelMapper.exception.ProductNotFoundException;
import com.example.modelMapper.entity.Product;
import com.example.modelMapper.repository.ProductRepository;
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
