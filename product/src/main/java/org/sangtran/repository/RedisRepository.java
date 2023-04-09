package org.sangtran.repository;

import org.sangtran.enity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RedisRepository {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;

    public void save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY, product.getId().toString(), product);
    }

    public List<Product> findAll(){
        List<Object> objects = redisTemplate.opsForHash().values(HASH_KEY);
        List<Product> products = new ArrayList<>();
        for (Object obj : objects) {
            products.add((Product) obj);
        }
        return products;
    }

    public Product findProductById(int id){
        System.out.println("called findProductById() from DB");
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, Integer.toString(id));
    }

    public String deleteProduct(int id){
        redisTemplate.opsForHash().delete(HASH_KEY, Integer.toString(id));
        return "product removed !!";
    }
}
