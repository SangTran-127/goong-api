package org.sangtran.controller;


import org.sangtran.dto.AddToCartDto;
import org.sangtran.entity.Cart;
import org.sangtran.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("{customerId}")
    ResponseEntity<Cart> getCartByCustomerId(@PathVariable("customerId") Integer customerId) {
        return ResponseEntity.ok(this.cartService.getCartByUserId(customerId));
    }

    @PostMapping()
    ResponseEntity<Cart> addToCart(@RequestBody AddToCartDto addToCartDto) {
        return ResponseEntity.ok(this.cartService.addToCart(addToCartDto));
    }

}
