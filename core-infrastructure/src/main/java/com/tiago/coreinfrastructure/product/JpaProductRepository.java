package com.tiago.coreinfrastructure.product;


import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaProductRepository extends JpaRepository<@NonNull ProductEntity, @NonNull String> {
    Optional<ProductEntity> findBySkuAndTenantId(String sku, String tenantId);
}