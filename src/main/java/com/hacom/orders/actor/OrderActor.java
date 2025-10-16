/*
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Actor de Akka Classic para procesar pedidos.
 *              Inserta en MongoDB y envía SMS cuando termina.
 */

 package com.hacom.orders.actor;

 import akka.actor.AbstractActor;
 import akka.actor.Props;
 import com.hacom.orders.model.Order;
 import com.hacom.orders.repository.OrderRepository;
 import com.hacom.orders.service.SmppService;
 import reactor.core.publisher.Mono;
 
 import java.time.OffsetDateTime;
 
 public class OrderActor extends AbstractActor {
 
     private final OrderRepository orderRepository;
     private final SmppService smppService;
 
     public OrderActor(OrderRepository orderRepository, SmppService smppService) {
         this.orderRepository = orderRepository;
         this.smppService = smppService;
     }
 
     // Props para crear el actor
     public static Props props(OrderRepository orderRepository, SmppService smppService) {
         return Props.create(OrderActor.class, () -> new OrderActor(orderRepository, smppService));
     }
 
     @Override
     public Receive createReceive() {
         return receiveBuilder()
                 .match(Order.class, order -> {
                     System.out.println("🎯 Procesando pedido: " + order.getOrderId());
 
                     // Setea estado y timestamp
                     order.setStatus("PROCESSED");
                     order.setTs(OffsetDateTime.now());
 
                     // Inserta el pedido en MongoDB
                     Mono<Order> saved = orderRepository.save(order);
                     saved.subscribe(o -> {
                         System.out.println("💾 Pedido guardado en MongoDB: " + o.getOrderId());
 
                         // Envía SMS notificando que el pedido fue procesado
                         smppService.sendSms(o.getCustomerPhoneNumber(),
                                 "Your order " + o.getOrderId() + " has been processed");
 
                         // Respuesta gRPC se enviaría aquí (simplificado)
                         System.out.println("✅ Respuesta gRPC enviada para pedido: " + o.getOrderId());
                     });
                 })
                 .build();
     }
 }
 