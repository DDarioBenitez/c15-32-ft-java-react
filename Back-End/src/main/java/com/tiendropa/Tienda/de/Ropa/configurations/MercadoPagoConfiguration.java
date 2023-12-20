package com.tiendropa.Tienda.de.Ropa.configurations;

import org.springframework.stereotype.Component;

import com.mercadopago.MercadoPagoConfig;

import jakarta.annotation.PostConstruct;


@Component
public class MercadoPagoConfiguration 
{
    private final String MERCADOPAGO_ACCESS_TOKEN = "TEST-9001052719957239-121116-1972de136ba40f31bdf7c53e7fbd66a7-258641558";

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(MERCADOPAGO_ACCESS_TOKEN);
    }
}
