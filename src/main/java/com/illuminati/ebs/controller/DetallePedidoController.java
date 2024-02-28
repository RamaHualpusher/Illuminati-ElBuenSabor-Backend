package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.DetallePedido;
import com.illuminati.ebs.entity.Producto; // Asegúrate de importar la clase Producto
import com.illuminati.ebs.service.DetallePedidoService;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.exception.ErrorResponse; // Importa la clase ErrorResponse
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-pedido")
@CrossOrigin(origins = "*")
public class DetallePedidoController extends GenericController<DetallePedido, Long> {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService service) {
        super(service);
        this.detallePedidoService = service;
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<DetallePedido>> getDetallesPedidoByPedidoId(@PathVariable Long pedidoId) {
        List<DetallePedido> detallesPedido = detallePedidoService.findDetallesPedidoByPedidoId(pedidoId);
        return new ResponseEntity<>(detallesPedido, HttpStatus.OK);
    }

}
