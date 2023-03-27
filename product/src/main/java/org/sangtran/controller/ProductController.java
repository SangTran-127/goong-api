package org.sangtran.controller;


import org.sangtran.dto.AddProductDto;
import org.sangtran.enity.Product;
import org.sangtran.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")

public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(this.productService.getAllProduct());
    }

    @GetMapping("{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(this.productService.getProductById(productId));
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody AddProductDto productDto) {
        return ResponseEntity.ok(this.productService.addProduct(productDto));
    }
}
