package com.example.spring_docker_app.service;

import com.example.spring_docker_app.model.Product;
import com.example.spring_docker_app.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    public Product create(Product product) {
        repo.findByCode(product.getCode()).ifPresent(p -> {
            throw new RuntimeException("Product code already exists: " + p.getCode());
        });
        return repo.save(product);
    }

    public Product update(String id, Product updated) {
        Product existing = getById(id);
        existing.setCode(updated.getCode());
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());
        existing.setCategory(updated.getCategory());
        existing.setDiscountPercent(updated.getDiscountPercent());
        return repo.save(existing);
    }


    public void delete(String id) {
        repo.deleteById(id);
    }


    public List<Product> searchByName(String namePart) {
        return repo.findByNameContainingIgnoreCase(namePart);
    }

    public List<Product> findByCategory(String category) {
        return repo.findByCategoryIgnoreCase(category);
    }
}
