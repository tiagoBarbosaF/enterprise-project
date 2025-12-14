package com.tiago.coredomain.domain.product.vo;

import java.util.Objects;

public record TenantId(String value) {
    public TenantId {
        Objects.requireNonNull(value, "TenantId cannot be null.");

        if (value.isBlank()) {
            throw new IllegalArgumentException("TenantId cannot be blank.");
        }
    }
}
