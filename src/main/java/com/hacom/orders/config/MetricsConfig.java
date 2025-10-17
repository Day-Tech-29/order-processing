package com.hacom.orders.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Proyecto: Order Processing System - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Configuración de métricas para Prometheus usando Micrometer.
 */
@Configuration
public class MetricsConfig {

    // Contador de pedidos procesados exitosamente
    @Bean
    public Counter processedOrdersCounter(MeterRegistry registry) {
        return Counter.builder("orders_processed_total")
                .description("Número total de pedidos procesados exitosamente")
                .register(registry);
    }
}
