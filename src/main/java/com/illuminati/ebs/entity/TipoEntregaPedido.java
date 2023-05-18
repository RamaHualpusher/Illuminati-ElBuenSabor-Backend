package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "TipoEntregaPedido")
@AttributeOverride(name = "id", column = @Column(name = "id_tipo_entrega_pedido"))
@Data
public class TipoEntregaPedido extends Base {
    @OneToMany(mappedBy = "tipoEntregaPedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    @Column(name = "tipo_entrega_descripcion")
    private String tipoEntregaDescripcion;
}
