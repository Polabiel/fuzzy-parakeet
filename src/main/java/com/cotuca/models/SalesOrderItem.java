import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class SalesOrderItem {
    @EmbeddedId
    private SalesOrderItemKey salesOrderItemKey;

    @ManyToOne
    @MapsId("SalesOrderId")
    @JoinColumn(name = "sales_order_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_SalesOrder"))
    private SalesOrder salesOrder;

    @ManyToOne
    @MapsId("ProductId")
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_Product"))
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double unitPrice;

    @Column(nullable = false)
    private Double discount;

    public SalesOrderItem(SalesOrder salesOrder, Product product, Integer quantity, Double unitPrice, Double discount) {
        this.salesOrder = salesOrder;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public SalesOrderItemKey getSalesOrderItemKey() {
        return salesOrderItemKey;
    }

    public void setSalesOrderItemKey(SalesOrderItemKey salesOrderItemKey) {
        this.salesOrderItemKey = salesOrderItemKey;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((salesOrderItemKey == null) ? 0 : salesOrderItemKey.hashCode());
        result = prime * result + ((salesOrder == null) ? 0 : salesOrder.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
        result = prime * result + ((discount == null) ? 0 : discount.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SalesOrderItem other = (SalesOrderItem) obj;
        if (salesOrderItemKey == null) {
            if (other.salesOrderItemKey != null)
                return false;
        } else if (!salesOrderItemKey.equals(other.salesOrderItemKey))
            return false;
        if (salesOrder == null) {
            if (other.salesOrder != null)
                return false;
        } else if (!salesOrder.equals(other.salesOrder))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        if (unitPrice == null) {
            if (other.unitPrice != null)
                return false;
        } else if (!unitPrice.equals(other.unitPrice))
            return false;
        if (discount == null) {
            if (other.discount != null)
                return false;
        } else if (!discount.equals(other.discount))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SalesOrderItem [salesOrderItemKey=" + salesOrderItemKey + ", salesOrder=" + salesOrder + ", product="
                + product + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", discount=" + discount + "]";
    }

}