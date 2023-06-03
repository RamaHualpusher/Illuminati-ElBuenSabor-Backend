package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.UserAuthDto;
import com.illuminati.ebs.entity.UserAuth;
import com.illuminati.ebs.mapper.UserAuthMapper;
import com.illuminati.ebs.repository.UserAuthRepository;
import com.illuminati.ebs.service.UserAuthService;
import com.illuminati.ebs.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl extends GenericServiceImpl<UserAuthDto, UserAuth, Long> implements UserAuthService {

    public UserAuthServiceImpl(UserAuthRepository repository, UserAuthMapper mapper) {
        super(repository, mapper);
    }
}