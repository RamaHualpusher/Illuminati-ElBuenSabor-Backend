package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Producto")
@Data
public class Producto extends Base{
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "imagen", length = 1000)
    private String imagen;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @Column(name = "stock_actual")
    private Integer stockActual;
    @Column(name = "preparacion", length = 1000)
    private String preparacion;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "es_bebida")
    private Boolean esBebida;
    @Transient
    private Integer maxCantidadProducto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Producto_Ingrediente> productosIngredientes = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;

    @Transient
    public Integer getMaxCantidadProducto() {
        if (this.productosIngredientes != null) {
            return calcularCantidadMaximaDeProductoPosible();
        } else {
            return 0;
        }
    }

    private Integer calcularCantidadMaximaDeProductoPosible() {
        List<Integer> stockDeIngredientes = new ArrayList<>();
        for (Producto_Ingrediente productoIngrediente : this.productosIngredientes) {
            stockDeIngredientes.add(productoIngrediente.getIngrediente().getStockActual() / productoIngrediente.getCantidad());
        }
        return stockDeIngredientes.stream().min(Integer::compareTo).orElse(0);
    }
}