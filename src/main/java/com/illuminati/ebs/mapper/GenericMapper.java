package com.illuminati.ebs.mapper;


import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

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
