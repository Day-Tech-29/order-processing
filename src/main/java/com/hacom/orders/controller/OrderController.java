package com.hacom.orders.controller;

import com.hacom.orders.model.Order;
import com.hacom.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

/**
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Controlador REST para gestionar pedidos.
 *              Permite consultar el estado de pedidos y
 *              obtener estadísticas por rango de fechas.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Consulta el estado de un pedido por su ID.
     *
     * @param orderId ID del pedido a consultar
     * @return Mono<Order> con la información del pedido
     */
    @GetMapping("/{orderId}")
    public Mono<Order> getOrderById(@PathVariable String orderId) {
        return orderRepository.findById(orderId)
                .doOnNext(order -> System.out.println("🔎 Pedido consultado: " + order.getOrderId()));
    }

    /**
     * Consulta todos los pedidos entre dos fechas.
     *
     * @param start fecha inicial (OffsetDateTime)
     * @param end   fecha final (OffsetDateTime)
     * @return Flux<Order> con todos los pedidos en el rango
     */
    @GetMapping("/range")
    public Flux<Order> getOrdersByDateRange(@RequestParam("start") OffsetDateTime start,
                                            @RequestParam("end") OffsetDateTime end) {
        System.out.println("📅 Consultando pedidos entre: " + start + " y " + end);
        return orderRepository.findByTsBetween(start, end);
    }

    /**
     * Retorna la cantidad de pedidos procesados entre dos fechas.
     *
     * @param start fecha inicial
     * @param end   fecha final
     * @return Mono<Long> con el total de pedidos
     */
    @GetMapping("/count")
    public Mono<Long> countOrdersByDateRange(@RequestParam("start") OffsetDateTime start,
                                             @RequestParam("end") OffsetDateTime end) {
        System.out.println("📊 Contando pedidos entre: " + start + " y " + end);
        return orderRepository.findByTsBetween(start, end).count();
    }

@GetMapping("/hello")
public Mono<String> hello() {
    return Mono.just("Bienvenido estimado Freddy! La app funciona correctamente.");
}

@RestController
public class TestController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hola, Daysy! La app funciona correctamente.");
    }
}




}
