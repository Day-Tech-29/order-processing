package com.hacom.orders.actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import com.hacom.orders.model.Order;
import com.hacom.orders.repository.OrderRepository;
import com.hacom.orders.service.SmppService;
import io.micrometer.core.instrument.Counter;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

/**
 * Proyecto: Order Processing System - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Actor de Akka para procesar pedidos.
 * Inserta pedidos en MongoDB y envía SMS al cliente.
 */
public class OrderActor extends AbstractActor {

    private final OrderRepository orderRepository;
    private final SmppService smppService;
    private final Counter processedOrdersCounter;

    public OrderActor(OrderRepository orderRepository, SmppService smppService, Counter processedOrdersCounter) {
        this.orderRepository = orderRepository;
        this.smppService = smppService;
        this.processedOrdersCounter = processedOrdersCounter;
    }

    public static Props props(OrderRepository orderRepository, SmppService smppService, Counter counter) {
        return Props.create(OrderActor.class, () -> new OrderActor(orderRepository, smppService, counter));
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Order.class, order -> {
                    // Setea estado y timestamp
                    order.setStatus("PROCESSED");
                    order.setTs(OffsetDateTime.now());

                    // Inserta el pedido en MongoDB
                    Mono<Order> saved = orderRepository.save(order);
                    saved.subscribe(o -> {
                        // Envía SMS notificando que el pedido fue procesado
                        smppService.sendSms(o.getCustomerPhoneNumber(),
                                "Your order " + o.getOrderId() + " has been processed");

                        // Incrementa contador de métricas
                        processedOrdersCounter.increment();

                        System.out.println("✅ Pedido procesado: " + o.getOrderId());
                    });
                })
                .build();
    }
}
