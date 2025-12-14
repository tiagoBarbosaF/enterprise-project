package com.tiago.productservice.product;

import com.tiago.coredomain.domain.product.vo.Price;
import com.tiago.coredomain.domain.product.vo.Sku;
import com.tiago.coredomain.domain.product.vo.TenantId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank(message = "Sku cannot be blank.")
        String sku,

        @NotBlank(message = "TenantId cannot be blank.")
        String tenantId,
        @NotBlank(message = "Name cannot be blank.")
        String name,

        @NotNull(message = "Price cannot be null.")
        @Positive(message = "Price must be greater than zero.")
        BigDecimal price
) {
    public Sku toSkuVO() {
        return new Sku(sku);
    }

    public TenantId toTenantIdVO() {
        return new TenantId(tenantId);
    }

    public Price toPriceVO() {
        return new Price(price);
    }
}
