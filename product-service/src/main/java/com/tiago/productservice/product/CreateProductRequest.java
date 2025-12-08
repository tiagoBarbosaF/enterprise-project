package com.tiago.productservice.product;

import com.tiago.coredomain.domain.product.vo.Price;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank(message = "Name cannot be blank.")
        String name,

        @NotNull(message = "Price cannot be null.")
        @Positive(message = "Price must be greater than zero.")
        BigDecimal price
) {
    public Price toPriceVO() {
        return new Price(price);
    }
}
