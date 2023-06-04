package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoBebidaVentaDto;
import com.illuminati.ebs.entity.ProductoBebidaVenta;
import com.illuminati.ebs.mapper.ProductoBebidaVentaMapper;
import com.illuminati.ebs.repository.ProductoBebidaVentaRepository;
import com.illuminati.ebs.service.ProductoBebidaVentaService;
import org.springframework.stereotype.Service;

@Service
public class ProductoBebidaVentaServiceImpl extends GenericServiceImpl<ProductoBebidaVentaDto, ProductoBebidaVenta, Long> implements ProductoBebidaVentaService {

    public ProductoBebidaVentaServiceImpl(ProductoBebidaVentaRepository repository, ProductoBebidaVentaMapper mapper) {
        super(repository, mapper);
    }

}
