package com.tiago.coredomain.domain.product.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String sku, String tenantId) {
        super("Product already exists with SKU: '%s' for Tenant: '%s: ".formatted(sku, tenantId));
    }
}
