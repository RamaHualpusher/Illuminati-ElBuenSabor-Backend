package com.illuminati.ebs.service;

import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.entity.Pedido;
import com.mercadopago.exceptions.MPException;

public interface MercadoPagoDatosService extends GenericService<MercadoPagoDatos, Long> {
    void init() throws MPException;
    String createPreference(Pedido pedido) throws MPException;
}
