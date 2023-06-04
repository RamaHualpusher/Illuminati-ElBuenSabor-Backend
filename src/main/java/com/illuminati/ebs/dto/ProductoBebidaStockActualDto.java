package com.illuminati.ebs.dto;
import lombok.Data;

import java.util.Date;

@Data
public class ProductoBebidaStockActualDto {
    private Long idProductoBebidaStockActual;
    private Integer stockActual;
    private Date fecha;
    private Long idArticulo;
}
