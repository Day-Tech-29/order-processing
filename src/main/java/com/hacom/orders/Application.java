package com.hacom.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Punto de entrada principal de la aplicación reactiva de procesamiento de pedidos.
 * Usa WebFlux y Log4j2 para gestión eficiente de logs.
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("🚀 Iniciando aplicación Order Processing System (versión reactiva)...");
        SpringApplication.run(Application.class, args);
        logger.info("✅ Aplicación iniciada correctamente.");
    }
}


 