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
    @ManyToOne
    @JoinColumn(name = "id_estado_pedido", insertable = false, updatable = false)
    private EstadoPedido estadoPedido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_entrega_pedido", insertable = false, updatable = false)
    private TipoEntregaPedido tipoEntregaPedido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", insertable = false, updatable = false)
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    /*@OneToOne
    @JoinColumn(name = "idDomicilio", insertable = false, updatable = false)
    private Domicilio domicilio;*/

    /*@OneToMany(mappedBy = "Pedido")
    private List<DetallePedido> detallePedidos;*/

    @Column
    private Integer numero_orden;

    @Column
    private Date hora_estimada_fin;

    @Column
    private String tipo_envio;

    @Column
    private Date fecha;
}