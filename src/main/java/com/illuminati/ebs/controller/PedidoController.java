package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.MercadoPagoDatos;
import com.illuminati.ebs.entity.Pedido;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.service.MercadoPagoDatosService;
import com.illuminati.ebs.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController extends GenericController<Pedido, Long>{
    private final PedidoService pedidoService;
    private final MercadoPagoDatosService mercadoPagoDatosService;
    @Autowired
    public PedidoController(PedidoService pedidoService, MercadoPagoDatosService mercadoPagoDatosService) {
        super(pedidoService);
        this.pedidoService = pedidoService;
        this.mercadoPagoDatosService = mercadoPagoDatosService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pedido> getPedidosByUsuarioId(@PathVariable Long usuarioId) {
        return pedidoService.findPedidosByUsuarioId(usuarioId);
    }
    @GetMapping("/estado/{estadoPedido}")
    public List<Pedido> getPedidosByEstado(@PathVariable String estadoPedido) {
        String estadoPedidoSinEspacios = estadoPedido.replace("_", " "); // Reemplaza los guiones bajos con espacios
        return pedidoService.findPedidosByEstado(estadoPedidoSinEspacios);
    }
//    @PostMapping("/mercadoPago")
//    public ResponseEntity<?> createPedido(@RequestBody Pedido pedido) throws Exception {
//        Usuario usuario = pedido.getUsuario();
//
//        String nombreUsuario = usuario.getNombre();
//        String apellidoUsuario = usuario.getApellido();
//        String emailUsuario = usuario.getEmail();
//
//        // Crear preferencia en MercadoPago
//        String preferenceId = mercadoPagoDatosService.createPreference(
//                "Pedido de " + nombreUsuario+ " "+ apellidoUsuario,
//                pedido.getTotal(),
//                1,
//                "http://localhost:4200/success",
//                "http://localhost:4200/failure",
//                "http://localhost:4200/pending"
//        );
//
//        // Crear objeto de MercadoPagoDatos y asociarlo al pedido
//        MercadoPagoDatos mercadoPagoDatos = new MercadoPagoDatos();
//        mercadoPagoDatos.setId(Long.valueOf(preferenceId));
//        mercadoPagoDatos.setActivo(true);
//        mercadoPagoDatos.setFechaCreacion(new Date());
//        mercadoPagoDatos.setEstado("pendiente");
//        mercadoPagoDatos.setPedido(pedido);
//
//        // Asociar MercadoPagoDatos al pedido
//        pedido.setMercadoPagoDatos(mercadoPagoDatos);
//
//        // Guardar pedido con los datos de MercadoPago
//        Pedido savedPedido = pedidoService.save(pedido);
//
//        // Devolver el pedido guardado y el ID de la preferencia
//        return ResponseEntity.ok(savedPedido);
//    }


}


