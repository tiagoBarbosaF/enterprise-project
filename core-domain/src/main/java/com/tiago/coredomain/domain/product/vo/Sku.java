package com.tiago.coredomain.domain.product.vo;

import java.util.Objects;

public record Sku(String value) {
    public Sku {
        Objects.requireNonNull(value, "SKU cannot be null.");

        if (value.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be blank.");
        }
    }
}
