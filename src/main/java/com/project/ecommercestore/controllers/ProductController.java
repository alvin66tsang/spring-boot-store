package com.project.ecommercestore.controllers;

import com.project.ecommercestore.dtos.ProductDto;
import com.project.ecommercestore.entities.Product;
import com.project.ecommercestore.mappers.ProductMapper;
import com.project.ecommercestore.repositories.CategoryRepository;
import com.project.ecommercestore.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @GetMapping("")
    public List<ProductDto> getProducts(
            @RequestParam(required = false, name = "categoryId") Byte categoryId

    ) {
        List<Product> products;
        if(categoryId != null) {
            products = productRepository.findAllByCategoryId(categoryId);
        } else {
            products = productRepository.findAllWithCategory();
        }

        return products.stream().map(productMapper::productDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productMapper.productDto(product));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto rq
    ) {

        var category = categoryRepository.findById(rq.getCategoryId()).orElse(null);
        if(category == null) {
            return ResponseEntity.badRequest().build();
        }

        var product = productMapper.toEntity(rq);
        product.setCategory(category);
        productRepository.save(product);

        var productDto = productMapper.productDto(product);
        productDto.setId(product.getId());

        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto rq
    ) {
        var category = categoryRepository.findById(rq.getCategoryId()).orElse(null);
        if(category == null) {
            return ResponseEntity.badRequest().build();
        }

        // TODO: find product by id
        var product = productRepository.findById(id).orElse(null);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }

        product.setCategory(category);
        rq.setId(product.getId());

        // TODO: update product
        productMapper.update(product, rq);
        productRepository.save(product);

        return ResponseEntity.ok(rq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // TODO: find product by id
        var product = productRepository.findById(id).orElse(null);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }

        // TODO: delete product
        productRepository.delete(product);

        return ResponseEntity.noContent().build();
    }
}
