package org.sangtran.service;

import com.netflix.discovery.converters.Auto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;
import org.sangtran.cart.CartClient;
import org.sangtran.dto.AddToCartDto;
import org.sangtran.entity.Cart;
import org.sangtran.entity.ProductCart;
import org.sangtran.product.ProductClient;
import org.sangtran.repository.CartRepository;
import org.sangtran.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private ProductCartRepository productCartRepository;
    public Cart getCartByUserId(Integer userId) {
        return this.cartRepository.findByCustomerId(userId).orElseThrow();
    }

    public Cart addToCart(AddToCartDto addToCartDto) {
        Optional<Cart> customerCartExisted = this.cartRepository.findByCustomerId(addToCartDto.customerId());
        if (customerCartExisted.isEmpty()) {
            var cartList = new ArrayList<ProductCart>();
            var product = productClient.getProductById(addToCartDto.productId());

            var productCart = this.productCartRepository.save(ProductCart.builder()
                            .quantity(1)
                            .productId(addToCartDto.productId())
                            .productName(product.getTitle())
                            .productPrice(product.getPrice())
                            .productDescription(product.getDescription())
                    .build());

            cartList.add(productCart);
            Cart cartCreated = Cart.builder()
                    .customerId(addToCartDto.customerId())
                    .productCartList(cartList).
                    build();
            this.cartRepository.save(cartCreated);
            return cartCreated;
        }
        List<ProductCart> cartList = customerCartExisted.get().getProductCartList();
        cartList.stream()
                .filter(productCart -> productCart.getProductId().equals(addToCartDto.productId()))
                .findAny()
                .ifPresentOrElse(
                        itemAlreadyExisted -> itemAlreadyExisted.setQuantity(itemAlreadyExisted.getQuantity() + 1),
                        () -> {
                            var product = productClient.getProductById(addToCartDto.productId());
                            var productCart = this.productCartRepository.save(ProductCart.builder()
                                    .quantity(1)
                                    .productId(addToCartDto.productId())
                                    .productName(product.getTitle())
                                    .productPrice(product.getPrice())
                                    .productDescription(product.getDescription())
                                    .build());
                            cartList.add(productCart);
                        }
                );

        //        List<Integer> cart = customerCartExisted.get().getProductId();
//        cart.add(addToCartDto.productId());
//        customerCartExisted.get().setProductId(cart);
        return this.cartRepository.save(customerCartExisted.get());
    }



}
