package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.ExampleDto;
import com.illuminati.ebs.service.ExampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController extends GenericController<ExampleDto, Long> {

    public ExampleController(ExampleService service) {
        super(service);
    }
}
