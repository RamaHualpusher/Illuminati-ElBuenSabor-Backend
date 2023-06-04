package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ArticuloDto;
import com.illuminati.ebs.entity.Articulo;
import com.illuminati.ebs.mapper.ArticuloMapper;
import com.illuminati.ebs.repository.ArticuloRepository;
import com.illuminati.ebs.service.ArticuloService;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl extends GenericServiceImpl<ArticuloDto, Articulo, Long> implements ArticuloService {

    public ArticuloServiceImpl(ArticuloRepository repository, ArticuloMapper mapper) {
        super(repository, mapper);
    }

}
