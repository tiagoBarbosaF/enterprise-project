package com.tiago.coreapplication.product;

import com.tiago.coredomain.domain.product.Product;
import com.tiago.coredomain.domain.product.ProductRepository;
import com.tiago.coredomain.domain.product.exception.ProductNotFoundException;

public class GetProductByIdUseCase {
    private final ProductRepository productRepository;

    public GetProductByIdUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product execute(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
