package org.sangtran.product;


import org.sangtran.enity.Product;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Service
@FeignClient(
        name = "product",
        url = "http://localhost:8082"
)
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/product/{productId}", consumes = "application/json")
    Product getProductById(@PathVariable("productId") Integer productId);
}
