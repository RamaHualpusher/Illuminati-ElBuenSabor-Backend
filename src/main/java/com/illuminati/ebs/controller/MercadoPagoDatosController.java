package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import com.illuminati.ebs.service.PedidoService;
import com.mercadopago.exceptions.MPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;

@RestController
@RequestMapping("/api/mercado-pago-dato")
@CrossOrigin(origins = "*")
public class MercadoPagoDatosController extends GenericController<MercadoPagoDatos, Long> {
    private final PedidoService pedidoService;
    private final MercadoPagoDatosService mercadoPagoDatosService;

    public MercadoPagoDatosController(MercadoPagoDatosService mercadoPagoDatosService, PedidoService pedidoService) {
        super(mercadoPagoDatosService);
        this.pedidoService = pedidoService;
        this.mercadoPagoDatosService = mercadoPagoDatosService;
    }

    @PostMapping("/mercadoPago")
    public ResponseEntity<?> createPedido(@RequestBody Pedido pedido) {
        try {
            // Guardar el pedido en la base de datos
            Pedido savedPedido = pedidoService.save(pedido);

            // Crear la preferencia de Mercado Pago
            String preferenceId = mercadoPagoDatosService.createPreference(savedPedido);

            // Crear y asociar el objeto MercadoPagoDatos al pedido
            MercadoPagoDatos mercadoPagoDatos = new MercadoPagoDatos();
            mercadoPagoDatos.setActivo(true);
            mercadoPagoDatos.setFechaCreacion(new Date());
            mercadoPagoDatos.setEstado("pendiente");
            mercadoPagoDatos.setPreferenceId(preferenceId); // Establecer el preferenceId
            mercadoPagoDatos.setPedido(savedPedido);
            mercadoPagoDatosService.save(mercadoPagoDatos);

            return ResponseEntity.ok().body(Collections.singletonMap("preferenceId", preferenceId));
        } catch (MPException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el pedido: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el pedido.");
        }
    }
}
