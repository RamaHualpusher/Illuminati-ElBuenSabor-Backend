package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class ProductoBebidaCostoDto {
    private Long idProductoBebidaCosto;
    private Double costo;
    private Date fecha;
    private ArticuloDto articulo;
}