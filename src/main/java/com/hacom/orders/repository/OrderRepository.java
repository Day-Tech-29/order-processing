/*
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Repositorio Reactivo de MongoDB para la entidad Order.
 *              Permite operaciones CRUD y consultas reactivas.
 */

 package com.hacom.orders.repository;

 import com.hacom.orders.model.Order;
 import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
 import org.springframework.stereotype.Repository;
 import reactor.core.publisher.Flux;
 
 import java.time.OffsetDateTime;
 
 @Repository
 public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
 
     // Para Consultar todos los pedidos de un rango de fechas usando OffsetDateTime
     Flux<Order> findByTsBetween(OffsetDateTime start, OffsetDateTime end);
 
     
 }
 