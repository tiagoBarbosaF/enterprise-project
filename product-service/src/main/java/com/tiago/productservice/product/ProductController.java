package com.tiago.productservice.product;

import com.tiago.coreapplication.product.CreateProductUseCase;
import com.tiago.coreapplication.product.GetProductByIdUseCase;
import com.tiago.coredomain.domain.product.Product;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, GetProductByIdUseCase getProductByIdUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable String id) {
        Product product = getProductByIdUseCase.execute(id);
        return ProductResponse.from(product);
    }

    @PostMapping
    public ProductResponse create(@Valid @RequestBody CreateProductRequest request) {
        Product product = createProductUseCase.execute(
                request.toSkuVO(),
                request.toTenantIdVO(),
                request.name(),
                request.toPriceVO()
        );
        return ProductResponse.from(product);
    }
}
