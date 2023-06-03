package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedido")
@AttributeOverride(name = "id", column = @Column(name = "id_pedido"))
@Data
public class Pedido extends  Base{
    @Column(name = "numero_pedido")
    private Integer numeroPedido;

    @Column(name="hora_estimada_fin")
    private Date horaEstimadaFin;

    @Column(name = "tipo_envio")
    private String tipoEnvio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "id_estado_pedido")
    private EstadoPedido estadoPedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_entrega_pedido")
    private TipoEntregaPedido tipoEntregaPedido;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_pago")
    private TipoPago tipoPago;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetallePedido> detallesPedidos;
}