package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.repository.GenericRepository;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
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

            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .id(pedido.getId().toString())
                    .title("Pedido de " + pedido.getUsuario().getNombre() + " " + pedido.getUsuario().getApellido())
                    .quantity(1)
                    .unitPrice(new BigDecimal(pedido.getTotal()))
                    .currencyId("ARG")
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            PreferenceBackUrlsRequest backURL = PreferenceBackUrlsRequest.builder()
                    .success("http://localhost:5173/mpsuccess")
                    .pending("http://localhost:5173/mppending")
                    .failure("http://localhost:5173/mpfailure")
                    .build();

            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backURL)
                    .build();

            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);

            return preference.getId();
        } catch (MPException e) {
            e.printStackTrace();
            throw e;
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }
}
