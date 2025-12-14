package com.tiago.productservice.product;

import com.tiago.coredomain.domain.product.Product;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String sku,
        String tenantId,
        String name,
        BigDecimal price
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.id(),
                product.sku().value(),
                product.tenantId().value(),
                product.name(),
                product.price().amount()
        );
    }
}
