package com.tiago.coreinfrastructure.product;

import com.tiago.coreapplication.product.CreateProductUseCase;
import com.tiago.coreapplication.product.GetProductByIdUseCase;
import com.tiago.coredomain.domain.product.Product;
import com.tiago.coredomain.domain.product.vo.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class ProductFlowTest {

    @Test
    public void flow_create_and_get_product() {
        InMemoryProductRepository repository = new InMemoryProductRepository();

        CreateProductUseCase create = new CreateProductUseCase(repository);
        GetProductByIdUseCase getById = new GetProductByIdUseCase(repository);

        Price price = new Price(new BigDecimal("59.90"));
        Product created = create.execute("Camiseta Polo", price);

        assertNotNull(created.id());
        assertEquals("Camiseta Polo", created.name());
        assertEquals(price, created.price());

        Product found = getById.execute(created.id());

        assertEquals(created, found);
    }
}
