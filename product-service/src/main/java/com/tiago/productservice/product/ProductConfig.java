package com.tiago.productservice.product;

import com.tiago.coreapplication.product.CreateProductUseCase;
import com.tiago.coreapplication.product.GetProductByIdUseCase;
import com.tiago.coredomain.domain.product.ProductRepository;
import com.tiago.coreinfrastructure.product.JpaProductRepository;
import com.tiago.coreinfrastructure.product.JpaProductRepositoryAdapter;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.tiago.coreinfrastructure.product"
)
@EntityScan(
        basePackages = "com.tiago.coreinfrastructure.product"
)
public class ProductConfig {

    @Bean
    public ProductRepository productRepository(JpaProductRepository repository) {
        return new JpaProductRepositoryAdapter(repository);
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
