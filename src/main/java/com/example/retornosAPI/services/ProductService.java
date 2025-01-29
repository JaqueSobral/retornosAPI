package com.example.retornosAPI.services;

import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductEntity createProduct(ProductEntity product) {
        return (ProductEntity) repository.save(product);
    }

    public ProductEntity getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }
    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    public ProductEntity updateProduct(ProductEntity updatedProduct, Long id) throws Throwable {
        if (id == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo.");
        }
        ProductEntity existingEntity = (ProductEntity) repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
        existingEntity.setName(updatedProduct.getName());
        existingEntity.setDescription(updatedProduct.getDescription());
        existingEntity.setPrice(updatedProduct.getPrice());
        existingEntity.setStockQuantity(updatedProduct.getStockQuantity());
        existingEntity.setCategory(updatedProduct.getCategory());
        return (ProductEntity) repository.save(existingEntity);
    }
    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID:" + id);
        }
        repository.deleteById(id);
    }
}