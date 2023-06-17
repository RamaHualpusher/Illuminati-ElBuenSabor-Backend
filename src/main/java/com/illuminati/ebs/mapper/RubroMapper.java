// RubroMapper.java
package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.RubroDto;
import com.illuminati.ebs.entity.Rubro;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;


@Component
public class RubroMapper implements GenericMapper<RubroDto, Rubro> {

    private TypeMap<Rubro, RubroDto> toDtoTypeMap;
    private TypeMap<RubroDto, Rubro> toEntityTypeMap;

    @PostConstruct
    public void initializeTypeMaps() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        toDtoTypeMap = modelMapper.createTypeMap(Rubro.class, RubroDto.class);
        toEntityTypeMap = modelMapper.createTypeMap(RubroDto.class, Rubro.class);

        toDtoTypeMap.addMappings(mapper -> mapper.map(Rubro::getId, RubroDto::setIdRubro));
        toEntityTypeMap.addMappings(mapper -> mapper.map(RubroDto::getIdRubro, Rubro::setId));

        toDtoTypeMap.addMappings(mapper -> mapper.skip(RubroDto::setRubroPadre));
        toEntityTypeMap.addMappings(mapper -> mapper.skip(Rubro::setRubroPadre));
    }

    @Override
    public RubroDto toDto(Rubro entity) {
        RubroDto rubroDto = toDtoTypeMap.map(entity);
        if (entity.getRubroPadre() != null) {
            rubroDto.setRubroPadre(toDto(entity.getRubroPadre()));
        }
        return rubroDto;
    }

    @Override
    public Rubro toEntity(RubroDto dto) {
        Rubro rubro = toEntityTypeMap.map(dto);
        if (dto.getRubroPadre() != null) {
            rubro.setRubroPadre(toEntity(dto.getRubroPadre()));
        }
        return rubro;
    }
}
