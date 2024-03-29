package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.Factura;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/factura")
@CrossOrigin(origins = "*")
public class FacturaController extends GenericController<Factura, Long> {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        super(facturaService);
        this.facturaService = facturaService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Factura> saveFactura(@RequestBody Pedido pedido) throws Exception {
        Factura factura = facturaService.saveFactura(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }
}
