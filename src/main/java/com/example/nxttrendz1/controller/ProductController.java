/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz1.service.*;
import com.example.nxttrendz1.model.*;

@RestController
public class ProductController {
    @Autowired
    private ProductJpaService service;

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return service.getProductById(productId);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return service.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        service.deleteProduct(productId);
    }
}
