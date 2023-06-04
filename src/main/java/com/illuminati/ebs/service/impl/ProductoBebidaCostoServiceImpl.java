package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoBebidaCostoDto;
import com.illuminati.ebs.entity.ProductoBebidaCosto;
import com.illuminati.ebs.mapper.ProductoBebidaCostoMapper;
import com.illuminati.ebs.repository.ProductoBebidaCostoRepository;
import com.illuminati.ebs.service.ProductoBebidaCostoService;
import org.springframework.stereotype.Service;

@Service
public class ProductoBebidaCostoServiceImpl extends GenericServiceImpl<ProductoBebidaCostoDto, ProductoBebidaCosto, Long> implements ProductoBebidaCostoService {

    public ProductoBebidaCostoServiceImpl(ProductoBebidaCostoRepository repository, ProductoBebidaCostoMapper mapper) {
        super(repository, mapper);
    }

}
