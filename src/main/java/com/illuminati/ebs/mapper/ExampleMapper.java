package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.ExampleDto;
import com.illuminati.ebs.entity.ExampleEntity;
import org.springframework.stereotype.Component;

@Component
public class ExampleMapper implements GenericMapper<ExampleDto, ExampleEntity> {

    @Override
    public ExampleEntity toEntity(ExampleDto dto) {
        ExampleEntity entity = new ExampleEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public ExampleDto toDto(ExampleEntity entity) {
        ExampleDto dto = new ExampleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
