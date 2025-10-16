/*
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Clase principal de la aplicación Spring Boot
 *              que inicia el servidor WebFlux y carga los beans.
 */

 package com.hacom.orders;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 
 @SpringBootApplication
 public class Application {
 
     public static void main(String[] args) {
         // Inicia la aplicación Spring Boot
         SpringApplication.run(Application.class, args);
         System.out.println("🚀 🚀Aplicación 'Procesamiento de Pedidos HACOM' iniciada por Daysy Malvaceda Rojas en WebFlux");
     }
 }
 
 