package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.RubroDto;
import com.illuminati.ebs.entity.Rubro;
import com.illuminati.ebs.service.RubroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rubro")
public class RubroController extends GenericController<Rubro, Long>{
    public RubroController(RubroService service) {
        super(service);
    }
}
