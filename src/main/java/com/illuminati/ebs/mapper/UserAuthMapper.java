package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.UserAuthDto;
import com.illuminati.ebs.entity.UserAuth;
import org.springframework.stereotype.Component;

@Component
public class UserAuthMapper implements GenericMapper<UserAuthDto, UserAuth> {

    @Override
    public UserAuth toEntity(UserAuthDto dto) {
        UserAuth entity = new UserAuth();
        entity.setId(dto.getIdUserAuth());
        entity.setUser_id(dto.getUser_id());
        entity.setEmail(dto.getEmail());
        entity.setBlocked(dto.isBlocked());
        // Asigna los valores restantes...

        return entity;
    }

    @Override
    public UserAuthDto toDto(UserAuth entity) {
        UserAuthDto dto = new UserAuthDto();
        dto.setIdUserAuth(entity.getId());
        dto.setUser_id(entity.getUser_id());
        dto.setEmail(entity.getEmail());
        dto.setBlocked(entity.isBlocked());
        // Asigna los valores restantes...

        return dto;
    }
}
