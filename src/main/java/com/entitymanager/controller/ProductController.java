package com.entitymanager.controller;

import com.entitymanager.model.Product;
import com.entitymanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Products")
public class ProductController {
    
        private ProductService service;
        
        @PostMapping
        public ResponseEntity<Product> create(@RequestBody Product product) {
            return ResponseEntity.ok(service.save(product));
        }

        @GetMapping
        public List<Product> getAll() {
            return service.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Product> getById(@PathVariable Long id) {
            return ResponseEntity.ok(service.findById(id).get());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product updated) {
            return ResponseEntity.ok(service.update(id, updated));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
}
