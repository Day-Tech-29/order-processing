/*
 * Proyecto: Procesamiento de Pedidos Telco - HACOM
 * Autora: Daysy Malvaceda Rojas
 * Descripción: Servicio para enviar SMS usando la librería Cloudhopper SMPP.
 * Esta clase incluye un ejemplo funcional simplificado y seguro de cómo inicializar
 * una sesión SMPP y simular el envío de mensajes de texto.
 */

package com.hacom.orders.service;

import com.cloudhopper.smpp.SmppClient;
import com.cloudhopper.smpp.SmppSession;
import com.cloudhopper.smpp.SmppSessionConfiguration;
import com.cloudhopper.smpp.impl.DefaultSmppClient;
import com.cloudhopper.smpp.pdu.SubmitSm;
import com.cloudhopper.smpp.pdu.PduRequest;
import com.cloudhopper.smpp.pdu.PduResponse;
import com.cloudhopper.smpp.type.Address;
import com.cloudhopper.smpp.type.SmppInvalidArgumentException;
import org.springframework.stereotype.Service;

/**
 * Servicio responsable de manejar la comunicación SMPP.
 * En este ejemplo, la sesión y el envío de SMS se simulan con logs,
 * pero puede adaptarse fácilmente a un entorno real con servidor SMPP.
 */
@Service
public class SmppService {

    private SmppClient client;
    private SmppSession session;

    /**
     * Inicializa el cliente SMPP con parámetros básicos.
     * En producción se deben configurar host, puerto, credenciales y handlers.
     * En este proyecto se simula la inicialización para fines de demostración.
     */
    public void initSmpp() {
        System.out.println("🔌 [SMPP] Inicializando cliente SMPP - Daysy Malvaceda Rojas");

        try {
            // Configuración base (solo demostrativa)
            SmppSessionConfiguration config = new SmppSessionConfiguration();
            config.setName("HACOM_SMPP_CLIENT");
            config.setHost("smpp.server.com");  // Cambiar por el host real
            config.setPort(2775);               // Cambiar por el puerto real
            config.setSystemId("usuario");      // Usuario SMPP
            config.setPassword("contraseña");   // Contraseña SMPP

            // Cliente Cloudhopper
            client = new DefaultSmppClient();

            // No se realiza bind real para evitar errores si no hay servidor SMPP
            System.out.println("✅ [SMPP] Cliente configurado correctamente (modo demo).");

        } catch (Exception e) {
            System.err.println("❌ [SMPP] Error al inicializar el cliente: " + e.getMessage());
        }
    }

    /**
     * Envía un mensaje SMS al número indicado.
     * Actualmente se simula el envío (sin conexión real).
     *
     * @param phoneNumber Número de destino (en formato internacional)
     * @param message     Contenido del mensaje
     */
    public void sendSms(String phoneNumber, String message) {
        System.out.println("📲 [SMPP] Enviando SMS a " + phoneNumber + ": " + message);

        try {
            // Ejemplo de cómo se crearía el SubmitSm si hubiera sesión activa
            SubmitSm submit = new SubmitSm();
            submit.setSourceAddress(new Address((byte) 0x03, (byte) 0x00, "HACOM"));
            submit.setDestAddress(new Address((byte) 0x01, (byte) 0x01, phoneNumber));
            submit.setShortMessage(message.getBytes());

            // En un entorno real:
            // session.submit(submit, 10000);

            System.out.println("✅ [SMPP] Mensaje procesado correctamente (modo demo).");

        } catch (SmppInvalidArgumentException e) {
            System.err.println("⚠️ [SMPP] Error de argumento al enviar SMS: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ [SMPP] Error inesperado: " + e.getMessage());
        }
    }
}
