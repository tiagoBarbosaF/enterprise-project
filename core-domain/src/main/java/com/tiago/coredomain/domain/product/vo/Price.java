package com.tiago.coredomain.domain.product.vo;

import java.math.BigDecimal;

public record Price(BigDecimal amount) {
    public Price {
        if (amount == null) throw new IllegalArgumentException("Price cannot be null");
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Price must be positive");
    }

    public boolean isZero() {
        return amount.compareTo(BigDecimal.ZERO) == 0;
    }

    public Price applyDiscount(BigDecimal discount) {
        BigDecimal finalValue = amount.subtract(discount);

        if (finalValue.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Discount results in negative price.");

        return new Price(finalValue);
    }
}
