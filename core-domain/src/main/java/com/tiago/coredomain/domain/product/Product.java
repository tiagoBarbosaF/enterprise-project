package com.tiago.coredomain.domain.product;

import com.tiago.coredomain.domain.product.vo.Price;

public record Product(
        String id,
        String name,
        Price price
) {
}
