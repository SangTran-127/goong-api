package org.sangtran.service;


import org.sangtran.dto.AddProductDto;
import org.sangtran.enity.Product;
import org.sangtran.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return this.productRepository.findById(productId).orElseThrow();
    }
    public Product addProduct(AddProductDto productDto) {
        Product product = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
        return this.productRepository.save(product);
    }
}
