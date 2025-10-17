package com.hacom.orders.repository;

import com.hacom.orders.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.OffsetDateTime;

/**
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Repositorio ReactiveMongo para la entidad Order.
 *              Permite consultas básicas y por rango de fechas.
 */
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    /**
     * Consulta todos los pedidos cuyo timestamp está entre start y end.
     *
     * @param start fecha inicial
     * @param end   fecha final
     * @return Flux<Order> con todos los pedidos en el rango
     */
    Flux<Order> findByTsBetween(OffsetDateTime start, OffsetDateTime end);
}
