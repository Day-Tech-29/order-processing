# Proyecto: Procesamiento de Pedidos Telco - HACOM

**Autora:** Daysy Malvaceda Rojas

---

## Descripción

Este proyecto es un **sistema de procesamiento de pedidos** para un entorno Telco, desarrollado con **Spring Boot, WebFlux, MongoDB, gRPC, Akka Classic Actors y SMPP**.  
Permite insertar pedidos, procesarlos, enviarlos a MongoDB, notificar por SMS y consultar información mediante una API REST.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring WebFlux
- Spring Data MongoDB (reactivo)
- Spring Actuator
- Log4j2 (YAML)
- gRPC
- Akka Classic Actors
- SMPP (Cloudhopper)
- Gradle

---

## Configuración

### application.yml

Variables configurables:

```yaml
mongodbDatabase: exampleDb
mongodbUri: "mongodb://127.0.0.1:27017"
apiPort: 9898
