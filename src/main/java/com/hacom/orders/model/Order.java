package com.hacom.orders.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * Proyecto: Order Processing System - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Modelo de datos Order para MongoDB reactivo.
 */
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String orderId;
    private String customerId;
    private String customerPhoneNumber;
    private String status;
    private List<String> items;
    private OffsetDateTime ts;

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { this.customerPhoneNumber = customerPhoneNumber; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }
    public OffsetDateTime getTs() { return ts; }
    public void setTs(OffsetDateTime ts) { this.ts = ts; }
}
