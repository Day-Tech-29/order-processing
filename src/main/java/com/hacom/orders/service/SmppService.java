package com.hacom.orders.service;

import org.springframework.stereotype.Service;

/**
 * Proyecto: Order Processing System - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Servicio para envío de SMS mediante SMPP.
 */
@Service
public class SmppService {

    public void sendSms(String phoneNumber, String message) {
        // Aquí iría la integración real con Cloudhopper SMPP
        System.out.println("📩 Enviando SMS a " + phoneNumber + ": " + message);
    }
}
