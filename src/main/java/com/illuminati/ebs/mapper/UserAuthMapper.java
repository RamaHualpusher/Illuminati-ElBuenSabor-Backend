package com.illuminati.ebs.mapper;

import com.illuminati.ebs.dto.UserAuthDto;
import com.illuminati.ebs.entity.UserAuth;
import org.springframework.stereotype.Component;

@Component
public class UserAuthMapper implements GenericMapper<UserAuthDto, UserAuth> {

    @Override
    public UserAuth toEntity(UserAuthDto dto) {
        UserAuth entity = new UserAuth();
        // Set entity fields based on dto
        return entity;
    }

    @Override
    public UserAuthDto toDto(UserAuth entity) {
        UserAuthDto dto = new UserAuthDto();
        // Set dto fields based on entity
        return dto;
    }
}
