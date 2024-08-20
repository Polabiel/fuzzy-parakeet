package com.cotuca.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class SalesOrder {

    @EmbeddedId
    private SalesOrderKey salesOrderKey;
    
    @ManyToOne
    @MapsId("CustomerId")
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_SalesOrder_Customer"))
    private ProductCategory customer;

    @ManyToOne
    @MapsId("EmployeeId")
    @JoinColumn(name = "Employee_id", foreignKey = @ForeignKey(name = "FK_SalesOrder_Employee"))
    private Employee employee;

    @ManyToOne
    @MapsId("ShipperId")
    @JoinColumn(name = "Shipper_id", foreignKey = @ForeignKey(name = "FK_SalesOrder_Shipper"))
    private Shipper shipper;


    @Column(nullable = false)
    private LocalDateTime orderDate;
    @Column(nullable = true)
    private LocalDate estimatedDeliveryDate;
    @Column(nullable = false, length = 30)
    private String status;
    @Column(nullable = false)
    private Double total;

    public SalesOrder(Integer salesOrderId, LocalDateTime orderDate, LocalDate estimatedDeliveryDate, String status, Double total) {
        if(salesOrderId < 0 || Objects.equals(status, "") || total <= 0) throw new IllegalArgumentException("Cannot have an ID less than 0, Status cannot be empty, and Total cannot be less than or equal to 0");
        this.SalesOrderId = salesOrderId;
        this.orderDate = orderDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = status;
        this.total = total;
    }

    public Integer getSalesOrderId() {
        return SalesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        SalesOrderId = salesOrderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "SalesOrderId=" + SalesOrderId +
                ", orderDate=" + orderDate +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                ", status='" + status + '\'' +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrder that)) return false;
        return Objects.equals(SalesOrderId, that.SalesOrderId) && Objects.equals(orderDate, that.orderDate) && Objects.equals(estimatedDeliveryDate, that.estimatedDeliveryDate) && Objects.equals(status, that.status) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SalesOrderId, orderDate, estimatedDeliveryDate, status, total);
    }
}