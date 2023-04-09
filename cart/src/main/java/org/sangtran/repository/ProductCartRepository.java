package org.sangtran.repository;

import org.sangtran.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {
}
