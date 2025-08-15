package com.entitymanager.service;

import com.entitymanager.model.Product;
import com.entitymanager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    public Product save(Product product) {
       return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product update(Long id, Product updated) {
        return repository.save(updated);
    }

    public void delete(Long id) {
        final var product = repository.findById(id);
        product.ifPresent(value -> repository.delete(value));
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
