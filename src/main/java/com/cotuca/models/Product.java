package com.cotuca.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Product {

    @EmbeddedId
    private SalesOrderKey salesOrderKey;

    @ManyToOne
    @MapsId("ProductId")
    @JoinColumn(name = "saProductid", foreignKey = @ForeignKey(name = "FK_ProductKey_Product"))
    private Product product;
    
    @ManyToOne
    @MapsId("SupplierId")
    @JoinColumn(name = "Supplier_id", foreignKey = @ForeignKey(name = "FK_ProductKey_Supplier"))
    private Supplier supplier;

    @ManyToOne
    @MapsId("Product_categoryId")
    @JoinColumn(name = "Product_category_id", foreignKey = @ForeignKey(name = "FK_ProductKey_Product_category"))
    private ProductCategory productCategory2;

    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private Double unitPrice;
    @Column(nullable = false)
    private Int unitsInStock;
    @Column(nullable = false)
    private Boolean discounted;

    public Product(Integer id, String name, String email, Double latitude, Double longitude) {
        this.ProductId = id;
        this.name = name;
        this.unitPrice = longitude;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getUnitPrice(), product.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName(), getUnitPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
    
}
