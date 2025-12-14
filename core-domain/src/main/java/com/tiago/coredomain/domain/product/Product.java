package com.tiago.coredomain.domain.product;

import com.tiago.coredomain.domain.product.vo.Price;
import com.tiago.coredomain.domain.product.vo.Sku;
import com.tiago.coredomain.domain.product.vo.TenantId;

import java.util.UUID;

public record Product(
        String id,
        Sku sku,
        TenantId tenantId,
        String name,
        Price price
) {
    public static Product create(
            Sku sku,
            TenantId tenantId,
            String name,
            Price price
    ) {
        return new Product(
                UUID.randomUUID().toString(),
                sku,
                tenantId,
                name,
                price
        );
    }
}
