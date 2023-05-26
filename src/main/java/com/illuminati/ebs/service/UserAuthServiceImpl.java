package com.illuminati.ebs.service;

import com.illuminati.ebs.dto.UserAuthDto;
import com.illuminati.ebs.entity.UserAuth;
import com.illuminati.ebs.mapper.UserAuthMapper;
import com.illuminati.ebs.repository.UserAuthRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl extends GenericServiceImpl<UserAuthDto, UserAuth, Long> implements UserAuthService {

    public UserAuthServiceImpl(UserAuthRepository repository, UserAuthMapper mapper) {
        super(repository, mapper);
    }
}