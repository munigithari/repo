/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz1.repository.*;
import com.example.nxttrendz1.model.*;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    private ProductJpaRepository repository;

    @Override
    public ArrayList<Product> getProducts() {
        List<Product> list = repository.findAll();
        ArrayList<Product> products = new ArrayList<>(list);
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        try {
            Product products = repository.findById(productId).get();
            return products;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        repository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        try {
            Product products = repository.findById(productId).get();

            if (product.getProductName() != null) {
                products.setProductName(product.getProductName());
            }
            if (product.getPrice() != 0) {
                products.setPrice(product.getPrice());
            }

            repository.save(products);
            return products;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(int productId) {
        repository.deleteById(productId);
    }

}
