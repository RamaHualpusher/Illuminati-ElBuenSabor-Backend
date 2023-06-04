package com.illuminati.ebs.mapper;
import com.illuminati.ebs.dto.ArticuloDto;
import com.illuminati.ebs.entity.Articulo;
import com.illuminati.ebs.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
import com.illuminati.ebs.entity.*;
import com.illuminati.ebs.dto.*;


@Component
public class ArticuloMapper {

    @Autowired
    private RubroRepository rubroRepository;

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public ArticuloDto toDto(Articulo articulo) {
        ArticuloDto dto = new ArticuloDto();
        dto.setIdArticulo(articulo.getId());
        dto.setDenominacion(articulo.getDenominacion());
        dto.setPrecioCompra(articulo.getPrecioCompra());
        dto.setPrecioVenta(articulo.getPrecioVenta());
        dto.setStockMinimo(articulo.getStockMinimo());
        dto.setStockActual(articulo.getStockActual());
        dto.setEsBebida(articulo.getEsBebida());
        dto.setIdRubro(articulo.getRubro().getId());
        dto.setIdUnidadMedida(articulo.getUnidadMedida().getId());

        dto.setDetallesPedidoIds(articulo.getDetallesPedido().stream()
                .map(DetallePedido::getId)
                .collect(Collectors.toList()));

        dto.setProductosBebidasCostoIds(articulo.getProductosBebidasCosto().stream()
                .map(ProductoBebidaCosto::getId)
                .collect(Collectors.toList()));

        dto.setProductosBebidasVentaIds(articulo.getProductosBebidasVenta().stream()
                .map(ProductoBebidaVenta::getId)
                .collect(Collectors.toList()));

        dto.setProductosBebidasStockActualIds(articulo.getProductosBebidasStockActual().stream()
                .map(ProductoBebidaStockActual::getId)
                .collect(Collectors.toList()));

        return dto;
    }

    public Articulo toEntity(ArticuloDto dto) {
        Articulo articulo = new Articulo();
        articulo.setId(dto.getIdArticulo());
        articulo.setDenominacion(dto.getDenominacion());
        articulo.setPrecioCompra(dto.getPrecioCompra());
        articulo.setPrecioVenta(dto.getPrecioVenta());
        articulo.setStockMinimo(dto.getStockMinimo());
        articulo.setStockActual(dto.getStockActual());
        articulo.setEsBebida(dto.getEsBebida());

        Rubro rubro = rubroRepository.findById(dto.getIdRubro()).orElseThrow();
        articulo.setRubro(rubro);

        UnidadMedida unidadMedida = unidadMedidaRepository.findById(Math.toIntExact(dto.getIdUnidadMedida())).orElseThrow();
        articulo.setUnidadMedida(unidadMedida);

        // Las relaciones con DetallePedido, ProductoBebidaCosto, ProductoBebidaVenta y ProductoBebidaStockActual se administrarán en sus respectivos servicios

        return articulo;
    }
}


