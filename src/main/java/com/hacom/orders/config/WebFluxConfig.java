/*
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Configuración programática de WebFlux.
 *              Se usa el puerto definido en application.yml.
 */

 package com.hacom.orders.config;

 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
 import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
 
 @Configuration
 public class WebFluxConfig {
 
     // Puerto definido en application.yml
     @Value("${apiPort}")
     private int apiPort;
 
     @Bean
     public ReactiveWebServerFactory reactiveWebServerFactory() {
         // Se crea un servidor WebFlux con el puerto programático 
         NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
         factory.setPort(apiPort);
         System.out.println("🌐 🌐Servidor WebFlux iniciado en puerto: " + apiPort);
         return factory;
     }
 }
 