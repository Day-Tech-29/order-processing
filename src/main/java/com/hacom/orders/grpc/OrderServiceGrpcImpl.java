package com.hacom.orders.grpc;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.hacom.orders.actor.OrderActor;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class OrderServiceGrpcImpl extends OrderServiceGrpc.OrderServiceImplBase {

    private final ActorRef orderActor;

    public OrderServiceGrpcImpl(ActorSystem system) {
        this.orderActor = system.actorOf(Props.create(OrderActor.class), "orderActor");
    }
@Override
public void createOrder(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
    OrderResponse response = OrderResponse.newBuilder()
            .setConfirmationId("CONFIRM-" + request.getOrderId())
            .setStatus("Order " + request.getOrderId() + " is PROCESSING")
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
}

}



