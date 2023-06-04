package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ArticuloDto;
import com.illuminati.ebs.entity.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ArticuloMapper implements GenericMapper<ArticuloDto, Articulo> {

    @Autowired
    private RubroMapper rubroMapper;

    @Autowired
    private UnidadMedidaMapper unidadMedidaMapper;

    @Autowired
    private DetallePedidoMapper detallePedidoMapper;

    @Autowired
    private ProductoBebidaCostoMapper productoBebidaCostoMapper;

    @Autowired
    private ProductoBebidaVentaMapper productoBebidaVentaMapper;

    @Autowired
    private ProductoBebidaStockActualMapper productoBebidaStockActualMapper;

    @Override
    public Articulo toEntity(ArticuloDto dto) {
        Articulo entity = new Articulo();
        entity.setId(dto.getIdArticulo());
        entity.setDenominacion(dto.getDenominacion());
        entity.setPrecioCompra(dto.getPrecioCompra());
        entity.setPrecioVenta(dto.getPrecioVenta());
        entity.setStockMinimo(dto.getStockMinimo());
        entity.setStockActual(dto.getStockActual());
        entity.setEsBebida(dto.getEsBebida());

        // Convertir idRubro y idUnidadMedida a entidades correspondientes
        entity.setRubro(rubroMapper.toEntity(dto.getIdRubro()));
        entity.setUnidadMedida(unidadMedidaMapper.toEntity(dto.getIdUnidadMedida()));

        // Convertir las listas de IDs a listas de entidades anidadas
        entity.setDetallesPedido(detallePedidoMapper.toEntityList(dto.getDetallesPedidoIds()));
        entity.setProductosBebidasCosto(productoBebidaCostoMapper.toEntityList(dto.getProductosBebidasCostoIds()));
        entity.setProductosBebidasVenta(productoBebidaVentaMapper.toEntityList(dto.getProductosBebidasVentaIds()));
        entity.setProductosBebidasStockActual(productoBebidaStockActualMapper.toEntityList(dto.getProductosBebidasStockActualIds()));

        return entity;
    }

    @Override
    public ArticuloDto toDto(Articulo entity) {
        ArticuloDto dto = new ArticuloDto();
        dto.setIdArticulo(entity.getId());
        dto.setDenominacion(entity.getDenominacion());
        dto.setPrecioCompra(entity.getPrecioCompra());
        dto.setPrecioVenta(entity.getPrecioVenta());
        dto.setStockMinimo(entity.getStockMinimo());
        dto.setStockActual(entity.getStockActual());
        dto.setEsBebida(entity.getEsBebida());

        // Convertir entidades anidadas a IDs
        dto.setIdRubro(entity.getRubro().getId());
        dto.setIdUnidadMedida(entity.getUnidadMedida().getId());

        // Convertir las listas de entidades anidadas a listas de IDs
        dto.setDetallesPedidoIds(detallePedidoMapper.toDtoList(entity.getDetallesPedido()).stream().map(DetallePedidoDto::getIdDetallePedido).collect(Collectors.toList()));
        dto.setProductosBebidasCostoIds(productoBebidaCostoMapper.toDtoList(entity.getProductosBebidasCosto()).stream().map(ProductoBebidaCostoDto::getIdProductoBebidaCosto).collect(Collectors.toList()));
        dto.setProductosBebidasVentaIds(productoBebidaVentaMapper.toDtoList(entity.getProductosBebidasVenta()).stream().map(ProductoBebidaVentaDto::getIdProductoBebidaVenta).collect(Collectors.toList()));
        dto.setProductosBebidasStockActualIds(productoBebidaStockActualMapper.toDtoList(entity.getProductosBebidasStockActual()).stream().map(ProductoBebidaStockActualDto::getIdProductoBebidaStockActual).collect(Collectors.toList()));

        return dto;
    }
}
