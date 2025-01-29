package com.example.retornosAPI.controllers;


import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(service.createProduct(productEntity));
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductEntity>> getProductById(@RequestBody ProductEntity productEntity, @PathVariable Long id) {
        return ResponseEntity.ok(Collections.singletonList(service.getProductById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity productEntity, @PathVariable Long id) throws Throwable {
        return ResponseEntity.ok(service.updateProduct(productEntity, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}