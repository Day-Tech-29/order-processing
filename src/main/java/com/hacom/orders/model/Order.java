/*
 * Modelo de Pedido para MongoDB
 * Autora: Daysy Malvaceda Rojas
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
    private ObjectId _id;
    private String orderId;
    private String customerId;
    private String customerPhoneNumber;
    private String status;
    private List<String> items;
    private OffsetDateTime ts;

    // Getters y Setters omitidos para simplicidad
}
