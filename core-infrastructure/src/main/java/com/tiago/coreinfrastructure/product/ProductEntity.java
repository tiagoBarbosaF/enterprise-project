package com.tiago.coreinfrastructure.product;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"sku", "tenant_id"})
        }
)
public class ProductEntity {
    @Id
    private String id;
    private String sku;

    @Column(name = "tenant_id")
    private String tenantId;
    private String name;
    private BigDecimal price;

    public ProductEntity() {
    }

    public ProductEntity(String id, String sku, String tenantId, String name, BigDecimal price) {
        this.id = id;
        this.sku = sku;
        this.tenantId = tenantId;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
