package com.hacom.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Autora: Daysy Malvaceda Rojas
// Controlador de prueba para verificar que la API funciona
@RestController
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "pong - Daysy Malvaceda Rojas";
    }
}
