package com.tiago.coreinfrastructure.product;

import com.tiago.coredomain.domain.product.Product;
import com.tiago.coredomain.domain.product.ProductRepository;
import com.tiago.coredomain.domain.product.vo.Sku;
import com.tiago.coredomain.domain.product.vo.TenantId;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProductRepository implements ProductRepository {
    private final Map<String, Product> db = new ConcurrentHashMap<>();

    @Override
    public Product save(Product product) {
        db.put(product.id(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Optional<Product> findBySkuAndTenantId(Sku sku, TenantId tenantId) {
        return db.values()
                .stream()
                .filter(product -> product.sku().equals(sku) && product.tenantId().equals(tenantId))
                .findFirst();
    }
}
