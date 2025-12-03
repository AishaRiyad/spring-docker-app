package com.example.spring_docker_app.controller;


import com.example.spring_docker_app.model.Product;
import com.example.spring_docker_app.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET all products
    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    // GET one product by id
    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return service.getById(id);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = service.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        return service.update(id, product);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    // Search by name
    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam("q") String query) {
        return service.searchByName(query);
    }

    // Filter by category
    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return service.findByCategory(category);
    }
}
