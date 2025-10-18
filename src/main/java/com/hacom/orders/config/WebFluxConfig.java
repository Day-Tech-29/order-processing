/*
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Configuración del puerto del servidor WebFlux.
 */

package com.hacom.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebFluxConfig {

    @Value("${apiPort:8080}")
    private int apiPort;

    @Bean
    public WebServerFactoryCustomizer<ReactiveWebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            if (factory instanceof NettyReactiveWebServerFactory nettyFactory) {
                nettyFactory.setPort(apiPort);
            }
        };
    }
}
