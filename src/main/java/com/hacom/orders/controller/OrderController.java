/*
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Controlador REST para consultar pedidos y totales
 *              usando WebFlux y ReactiveMongoRepository.
 */

 package com.hacom.orders.controller;

 import com.hacom.orders.model.Order;
 import com.hacom.orders.repository.OrderRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.format.annotation.DateTimeFormat;
 import org.springframework.web.bind.annotation.*;
 import reactor.core.publisher.Flux;
 import reactor.core.publisher.Mono;
 
 import java.time.OffsetDateTime;
 
 @RestController
 @RequestMapping("/api/orders")
 public class OrderController {
 
     @Autowired
     private OrderRepository orderRepository;
 
     // 🔎 Endpoint para consultar todos los pedidos
     @GetMapping
     public Flux<Order> getAllOrders() {
         return orderRepository.findAll();
     }
 
     // 📅 Endpoint para consultar pedidos por rango de fechas
     @GetMapping("/range")
     public Flux<Order> getOrdersByDateRange(
             @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime start,
             @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime end
     ) {
         return orderRepository.findByTsBetween(start, end);
     }
 
     // 💯 Endpoint para contar total de pedidos por rango de fechas
     @GetMapping("/count")
     public Mono<Long> getTotalOrdersByDateRange(
             @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime start,
             @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime end
     ) {
         return orderRepository.findByTsBetween(start, end).count();
     }
 }
 