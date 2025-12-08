package com.tiago.productservice.product;

import com.tiago.coreapplication.product.CreateProductUseCase;
import com.tiago.coreapplication.product.GetProductByIdUseCase;
import com.tiago.coredomain.domain.product.ProductRepository;
import com.tiago.coreinfrastructure.product.InMemoryProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository repository) {
        return new CreateProductUseCase(repository);
    }

    @Bean
    public GetProductByIdUseCase getProductByIdUseCase(ProductRepository repository) {
        return new GetProductByIdUseCase(repository);
    }
}
