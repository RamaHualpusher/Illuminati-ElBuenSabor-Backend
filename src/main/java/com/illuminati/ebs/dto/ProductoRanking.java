package com.illuminati.ebs.dto;

import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.entity.Rubro;
import lombok.Data;

@Data

public class ProductoRanking {
    private Long id;
    private boolean activo;
    private String denominacion;
    private boolean esBebida;
    private String imagen;
    private String nombre;
    private double precio;
    private String preparacion;
    private int stockActual;
    private int stockMinimo;
    private int tiempoEstimadoCocina;
    private Rubro rubro;
    private long totalVendido;

    public ProductoRanking(Long id, boolean activo, String denominacion, boolean esBebida, String imagen, String nombre, double precio, String preparacion, int stockActual, int stockMinimo, int tiempoEstimadoCocina, Rubro rubro, long totalVendido) {
        this.id = id;
        this.activo = activo;
        this.denominacion = denominacion;
        this.esBebida = esBebida;
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.preparacion = preparacion;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.tiempoEstimadoCocina = tiempoEstimadoCocina;
        this.rubro = rubro;
        this.totalVendido = totalVendido;
    }

    // Getters y setters
}

