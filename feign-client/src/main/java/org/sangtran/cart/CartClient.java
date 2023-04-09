package org.sangtran.cart;


//import org.sangtran.entity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "cart",
        url = "http://localhost:8084"
)
public interface CartClient {
    @GetMapping(path = "/api/v1/cart/{customerId}")
    Object getCartByCustomerId(@PathVariable("customerId") Integer customerId);
}
