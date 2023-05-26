package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.UserAuthDto;
import com.illuminati.ebs.service.UserAuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/auth")
public class UserAuthController extends GenericController<UserAuthDto, Long> {

    public UserAuthController(UserAuthService service) {
        super(service);
    }
}
