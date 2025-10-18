/*
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Configuración de conexión reactiva con MongoDB.
 */

package com.hacom.orders.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${mongodbUri}")
    private String mongoUri;

    @Value("${mongodbDatabase}")
    private String mongoDatabase;

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoDatabase reactiveMongoDatabase(MongoClient client) {
        return client.getDatabase(mongoDatabase);
    }
}
