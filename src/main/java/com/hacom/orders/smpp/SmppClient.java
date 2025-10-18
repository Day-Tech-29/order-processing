/*
 * Cliente SMPP para envío de SMS
 * Autora: Daysy Malvaceda Rojas
 */

package com.hacom.orders.smpp;

public class SmppClient {

    public void sendSms(String phone, String message) {
        // TODO: Configurar Cloudhopper SMPP
        System.out.println("Enviando SMS a " + phone + ": " + message);
    }
}
