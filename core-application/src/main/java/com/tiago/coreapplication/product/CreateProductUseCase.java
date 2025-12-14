package com.tiago.coreapplication.product;

import com.tiago.coredomain.domain.product.Product;
import com.tiago.coredomain.domain.product.ProductRepository;
import com.tiago.coredomain.domain.product.exception.ProductAlreadyExistsException;
import com.tiago.coredomain.domain.product.vo.Price;
import com.tiago.coredomain.domain.product.vo.Sku;
import com.tiago.coredomain.domain.product.vo.TenantId;

public class CreateProductUseCase {
    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(Sku sku, TenantId tenantId, String name, Price price) {
        productRepository.findBySkuAndTenantId(sku, tenantId)
                .ifPresent(_ -> {
                    throw new ProductAlreadyExistsException(sku.value(), tenantId.value());
                });

        Product product = Product.create(sku, tenantId, name, price);
        productRepository.save(product);

        return product;
    }
}
