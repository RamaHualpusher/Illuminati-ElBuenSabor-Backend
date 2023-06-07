package com.illuminati.ebs.mapper;
import com.illuminati.ebs.dto.*;
import com.illuminati.ebs.entity.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ArticuloMapper implements GenericMapper<ArticuloDto, Articulo> {

//    public ArticuloMapper() {
//        // Configure ModelMapper to understand how to map the related entities
//        modelMapper.createTypeMap(ArticuloDto.class, Articulo.class)
//                .addMappings(mapper -> {
//                    mapper.<Long>map(src -> src.getRubro().getIdRubro(),
//                            (dest, v) -> dest.getRubro().setId(v));
//                    mapper.<Long>map(src -> src.getUnidadMedida().getIdUnidadMedida(),
//                            (dest, v) -> dest.getUnidadMedida().setId(v));
//                    // Para las listas, solo se establecen como listas vacías ya que los datos se llenarán en otro lugar
//                    mapper.<List<DetallePedido>>map(src -> src.getDetallesPedido(),
//                            (dest, v) -> dest.setDetallesPedido(new ArrayList<>()));
//                    mapper.<List<ProductoBebidaCosto>>map(src -> src.getProductosBebidasCosto(),
//                            (dest, v) -> dest.setProductosBebidasCosto(new ArrayList<>()));
////                    mapper.<List<ProductoBebidaVenta>>map(src -> src.getProductosBebidasVenta(),
////                            (dest, v) -> dest.setProductosBebidasVenta(new ArrayList<>()));
//                    mapper.<List<ProductoBebidaStockActual>>map(src -> src.getProductosBebidasStockActual(),
//                            (dest, v) -> dest.setProductosBebidasStockActual(new ArrayList<>()));
//                });
//
//        modelMapper.createTypeMap(Articulo.class, ArticuloDto.class)
//                .addMappings(mapper -> {
//                    mapper.<Long>map(src -> src.getRubro().getId(),
//                            (dest, v) -> dest.getRubro().setIdRubro(v));
//                    mapper.<Long>map(src -> src.getUnidadMedida().getId(),
//                            (dest, v) -> dest.getUnidadMedida().setIdUnidadMedida(v));
//                    // Para las listas, solo se establecen como listas vacías ya que los datos se llenarán en otro lugar
//                    mapper.<List<DetallePedidoDto>>map(src -> src.getDetallesPedido(),
//                            (dest, v) -> dest.setDetallesPedido(new ArrayList<>()));
//                    mapper.<List<ProductoBebidaCostoDto>>map(src -> src.getProductosBebidasCosto(),
//                            (dest, v) -> dest.setProductosBebidasCosto(new ArrayList<>()));
////                    mapper.<List<ProductoBebidaVentaDto>>map(src -> src.getProductosBebidasVenta(),
////                            (dest, v) -> dest.setProductosBebidasVenta(new ArrayList<>()));
//                    mapper.<List<ProductoBebidaStockActualDto>>map(src -> src.getProductosBebidasStockActual(),
//                            (dest, v) -> dest.setProductosBebidasStockActual(new ArrayList<>()));
//                });
//    }


    @Override
    public Articulo toEntity(ArticuloDto dto){
        Articulo articulo = modelMapper.map(dto, Articulo.class);
        // Asignar rubro y unidad de medida a partir de los IDs
        Rubro rubro = new Rubro();
        rubro.setId(dto.getRubroId());
        articulo.setRubro(rubro);
        UnidadMedida unidadMedida = new UnidadMedida();
        unidadMedida.setId(dto.getUnidadMedidaId());
        articulo.setUnidadMedida(unidadMedida);
        // Establecer stock actual inicial
        articulo.setStockActual(dto.getStockActual());
        return articulo;
    }

    @Override
    public ArticuloDto toDto(Articulo entity){
        ArticuloDto dto = modelMapper.map(entity, ArticuloDto.class);
        // Asignar IDs del rubro y unidad de medida
        dto.setRubroId(entity.getRubro().getId());
        dto.setUnidadMedidaId(entity.getUnidadMedida().getId());
        return dto;
    }

    @Override
    public List<Articulo> toEntityList(List<ArticuloDto> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticuloDto> toDtoList(List<Articulo> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}




