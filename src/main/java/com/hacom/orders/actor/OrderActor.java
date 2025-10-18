/*
 * Actor de Akka para procesar pedidos
 * Autora: Daysy Malvaceda Rojas
 */


package com.hacom.orders.actor;
import akka.actor.AbstractActor;
import com.hacom.orders.grpc.OrderRequest;

public class OrderActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(OrderRequest.class, order -> {
                // TODO: Insertar pedido en MongoDB
                // TODO: Enviar SMS usando SmppClient
                System.out.println("Procesando pedido " + order.getOrderId());
            })
            .build();
    }



}

