package org.sangtran.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sangtran.enity.Product;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    private Integer productId;

    private String productName;
    private Double productPrice;

    private String productDescription;
    private Integer quantity;
}
