package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.RubroDto;
import com.illuminati.ebs.entity.Rubro;
import com.illuminati.ebs.mapper.RubroMapper;
import com.illuminati.ebs.repository.RubroRepository;
import com.illuminati.ebs.service.RubroService;
import org.springframework.stereotype.Service;

@Service
public class RubroServiceImpl extends GenericServiceImpl<Rubro, Long> implements RubroService{
    public RubroServiceImpl(RubroRepository repository) {
        super(repository);
    }
}
