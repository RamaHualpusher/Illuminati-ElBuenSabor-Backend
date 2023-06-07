package com.illuminati.ebs.mapper;


import com.illuminati.ebs.entity.Base;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<D, E extends Base> {

    ModelMapper modelMapper = new ModelMapper();

    default E toEntity(D dto){
        return modelMapper.map(dto, (Class<E>) ((java.lang.reflect.ParameterizedType) getClass()
                .getGenericInterfaces()[0])
                .getActualTypeArguments()[1]);
    }

    default D toDto(E entity){
        return modelMapper.map(entity, (Class<D>) ((java.lang.reflect.ParameterizedType) getClass()
                .getGenericInterfaces()[0])
                .getActualTypeArguments()[0]);
    }

    default List<E> toEntityList(List<D> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    default List<D> toDtoList(List<E> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}

