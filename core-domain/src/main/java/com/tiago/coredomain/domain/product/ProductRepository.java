package com.tiago.coredomain.domain.product;

import com.tiago.coredomain.domain.product.vo.Sku;
import com.tiago.coredomain.domain.product.vo.TenantId;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(String id);
    Optional<Product> findBySkuAndTenantId(Sku sku, TenantId tenantId);
}
