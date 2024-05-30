package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.repository.GenericRepository;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoDatosServiceImpl extends GenericServiceImpl<MercadoPagoDatos, Long> implements MercadoPagoDatosService {

    @Value("${MERCADO_PAGO_ACCESS_TOKEN}")
    private String mercadoPagoAccessToken;

    public MercadoPagoDatosServiceImpl(GenericRepository<MercadoPagoDatos, Long> genericRepository) {
        super(genericRepository);
    }

    @Override
    public void init() throws MPException {
        MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
    }

    @Override
    public String createPreference(Pedido pedido) throws MPException {
        try {
            MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

            // Crear el item de la preferencia
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .id(pedido.getId().toString())
                    .title("Pedido de " + pedido.getUsuario().getNombre() + " " + pedido.getUsuario().getApellido())
                    .quantity(1)
                    .unitPrice(new BigDecimal(pedido.getTotal()))
                    .currencyId("ARS")
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            // Crear URLs de retorno
            PreferenceBackUrlsRequest backURL = PreferenceBackUrlsRequest.builder()
                    .success("http://localhost:3000/mpsuccess")
                    .pending("http://localhost:3000/mppending")
                    .failure("http://localhost:3000/mpfailure")
                    .build();

            // Crear la preferencia
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .autoReturn("approved")
                    .backUrls(backURL)
                    .notificationUrl("https://localhost:3000/confirmacion-pedido")
                    .build();

            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);

            return preference.getId();
        } catch (MPException e) {
            e.printStackTrace();
            // Log more details about the exception
            System.err.println("MPException: " + e.getMessage());
            throw e;
        } catch (MPApiException e) {
            // Log more details about the API exception
            System.err.println("MPApiException: " + e.getMessage() + ", status: " + e.getStatusCode());
            throw new RuntimeException(e);
        }
    }
}
