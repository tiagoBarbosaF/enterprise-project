package com.tiago.coreapplication.product;

import com.tiago.coredomain.domain.product.Product;
import com.tiago.coredomain.domain.product.ProductRepository;
import com.tiago.coredomain.domain.product.vo.Price;

import java.util.UUID;

public class CreateProductUseCase {
    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(String name, Price price) {
        Product product = new Product(
                UUID.randomUUID().toString(),
                name,
                price
        );
        return productRepository.save(product);
    }
}
