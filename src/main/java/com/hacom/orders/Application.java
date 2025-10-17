package com.hacom.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Proyecto: Order Processing System - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Punto de entrada principal de la aplicación Reactiva.
 * Usa WebFlux y Log4j2 para gestión eficiente de logs.
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("🚀 Iniciando aplicación Order Processing System...");
        SpringApplication.run(Application.class, args);
        logger.info("✅ Aplicación iniciada correctamente.");
    }
}
