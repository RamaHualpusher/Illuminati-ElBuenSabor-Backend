package com.illuminati.ebs.controller;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MercadoPago {
    public void ConfiCredencial(PreferenceRequest request)

    {
        try {
            // Configura tus credenciales de Mercado Pago
            MercadoPagoConfig.setAccessToken("TEST-2585974153916505-060716-0b8024b43cc27a8b4df4803df0ad9d81-740640413");

            PreferenceItemRequest itemRequest =
                    PreferenceItemRequest.builder()
                            .id("1234")
                            .title("Games")
                            .description("PS5")
                            .pictureUrl("http://picture.com/PS5")
                            .categoryId("games")
                            .quantity(2)
                            .currencyId("BRL")
                            .unitPrice(new BigDecimal("4000"))
                            .build();
            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items).build();
            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(request);

        } catch (MPException | MPApiException e) {
            // Manejo de excepciones de Mercado Pago
            e.printStackTrace();
        }
    }

}
