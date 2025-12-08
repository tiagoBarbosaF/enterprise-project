package com.tiago.productservice.product;

import com.tiago.coredomain.domain.product.Product;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        BigDecimal price
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.id(),
                product.name(),
                product.price().amount()
        );
    }
}
