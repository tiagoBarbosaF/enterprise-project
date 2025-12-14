package com.tiago.coreinfrastructure.product;

import com.tiago.coredomain.domain.product.Product;
import com.tiago.coredomain.domain.product.ProductRepository;
import com.tiago.coredomain.domain.product.vo.Price;
import com.tiago.coredomain.domain.product.vo.Sku;
import com.tiago.coredomain.domain.product.vo.TenantId;

import java.util.Optional;

public class JpaProductRepositoryAdapter implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;

    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = this.toEntity(product);
        ProductEntity saved = jpaProductRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Product> findById(String id) {
        return jpaProductRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Optional<Product> findBySkuAndTenantId(Sku sku, TenantId tenantId) {
        return jpaProductRepository.findBySkuAndTenantId(sku.value(), tenantId.value())
                .map(this::toDomain);
    }

    private Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                new Sku(entity.getSku()),
                new TenantId(entity.getTenantId()),
                entity.getName(),
                new Price(entity.getPrice()));
    }

    private ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.id(),
                product.sku().value(),
                product.tenantId().value(),
                product.name(),
                product.price().amount()
        );
    }
}
