/*
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Modelo de datos para los pedidos en MongoDB.
 *              Contiene información del pedido y marca de tiempo.
 */

 package com.hacom.orders.model;

 import org.bson.types.ObjectId;
 import org.springframework.data.annotation.Id;
 import org.springframework.data.mongodb.core.mapping.Document;
 
 import java.time.OffsetDateTime;
 import java.util.List;
 
 @Document(collection = "orders")
 public class Order {
 
     @Id
     private ObjectId _id; // ID interno de MongoDB
 
     private String orderId; // ID del pedido
     private String customerId; // ID del cliente
     private String customerPhoneNumber; // Teléfono del cliente
     private String status; // Estado del pedido
     private List<String> items; // Lista de ítems del pedido
     private OffsetDateTime ts; // Marca de tiempo del pedido
 
     // Constructor vacío
     public Order() {}
 
     // Constructor con todos los campos
     public Order(String orderId, String customerId, String customerPhoneNumber, List<String> items, String status, OffsetDateTime ts) {
         this.orderId = orderId;
         this.customerId = customerId;
         this.customerPhoneNumber = customerPhoneNumber;
         this.items = items;
         this.status = status;
         this.ts = ts;
     }
 
     // Getters y Setters
     public ObjectId get_id() { return _id; }
     public void set_id(ObjectId _id) { this._id = _id; }
 
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
 