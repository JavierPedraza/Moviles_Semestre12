package com.example.mov_app_pizza.interfaces;

public interface AutorizacionSms {
    void smsProcede(String nombre, String domicilio);
    void smsRechazo();
}
