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



##  **Instalación**

### 1. Clonar repositorio
```bash
git clone https://github.com/Day-Tech-29/order-processing.git
cd order-processing


### 2. Instalar MongoDB

#### Ubuntu/Debian
```bash
sudo apt-get install mongodb
sudo systemctl start mongodb
```

#### macOS
```bash
brew install mongodb-community
brew services start mongodb-community
```

#### Docker
```bash
docker run -d -p 27017:27017 --name mongodb mongo:latest
```

### 3. Compilar el proyecto

```bash
./gradlew clean build
```

## Ejecución

## Usando Gradle

```bash
./gradlew bootRun
```

### Usando JAR

#bash
./gradlew bootJar
java -jar build/libs/order-processing-1.0.0.jar
```


- REST API: http://localhost:9898
- gRPC Server: localhost:9090
- Actuator: http://localhost:9898/actuator

## Pruebas

#.curl http://localhost:9898/actuator/health

## Crear tarea
### curl -X POST http://localhost:9898/api/v1/tasks \
-H "Content-Type: application/json" \
-d '{
  "title": "Revisar código",
  "description": "Revisar pull request #23",
  "dueDate": "2025-10-30"
}'
###Consultar tareas

###curl http://localhost:9898/api/v1/tasks

# SMPP

### Inicia simulador

#bash
python3 smpp-simulator.py

### Verificar mensajes SMS durante la creación de órdenes

El simulador mostrará los mensajes SMS cuando se procesen órdenes:


### Puerto personalizado

```bash
python3 smpp-simulator.py 2776
```

