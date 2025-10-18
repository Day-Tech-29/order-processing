/*
 * API REST WebFlux para pedidos
 * Autora: Daysy Malvaceda Rojas
 */

package com.hacom.orders.api;

import com.hacom.orders.model.Order;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{id}")
    public Mono<Order> getOrder(@PathVariable String id) {
        // TODO: Consultar MongoDB por ID
        return Mono.empty();
    }

    @GetMapping("/total")
    public Mono<Long> getTotalOrders(
            @RequestParam OffsetDateTime from,
            @RequestParam OffsetDateTime to) {
        // TODO: Consultar MongoDB por rango de fecha
        return Mono.just(0L);
    }
}



