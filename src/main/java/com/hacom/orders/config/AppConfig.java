package com.hacom.orders.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;

/**
 * Proyecto: Order Processing System - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Configuración principal de la aplicación.
 * Configura MongoDB reactivo y el puerto del servidor Netty.
 */
@Configuration
@EnableWebFlux
public class AppConfig extends AbstractReactiveMongoConfiguration {

    @Value("${apiPort}")
    private int apiPort;

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    // Nombre de la base de datos
    @Override
    protected String getDatabaseName() {
        return "orderdb";
    }

    // Configura MongoClient reactivo
    @Override
    public MongoClient reactiveMongoClient() {
        ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(settings);
    }



        @Bean
public ReactiveWebServerFactory reactiveWebServerFactoryWebFlux() {
    NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
    factory.setPort(9898); //  apiPort
    return factory;
}

    }

