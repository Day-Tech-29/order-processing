package com.hacom.orders.repository;

import com.hacom.orders.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio MongoDB para órdenes
 * Autora: Daysy Malvaceda Rojas
 */
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
