package org.sangtran.service;


import lombok.extern.slf4j.Slf4j;
import org.sangtran.dto.AddProductDto;
import org.sangtran.enity.Product;
import org.sangtran.repository.ProductRepository;
import org.sangtran.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RedisRepository redisRepository;

    public List<Product> getAllProduct() {

        return this.redisRepository.findAll().isEmpty() ? this.productRepository.findAll() : this.redisRepository.findAll();
    }

    public Product getProductById(Integer productId) {

        return this.redisRepository.findProductById(productId) != null ?  this.redisRepository.findProductById(productId) :this.productRepository.findById(productId).orElseThrow();
    }
    public Product addProduct(AddProductDto productDto) {

        Product product = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
//
        var productFlush = this.productRepository.saveAndFlush(product);

        this.redisRepository.save(productFlush);
        return productFlush;
    }
}
