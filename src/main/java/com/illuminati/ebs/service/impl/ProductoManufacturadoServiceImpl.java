package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoManufacturadoDto;
import com.illuminati.ebs.entity.ProductoManufacturado;
import com.illuminati.ebs.mapper.ProductoManufacturadoMapper;
import com.illuminati.ebs.repository.ProductoManufacturadoRepository;
import com.illuminati.ebs.service.ProductoManufacturadoService;
import org.springframework.stereotype.Service;

@Service
public class ProductoManufacturadoServiceImpl extends GenericServiceImpl<ProductoManufacturadoDto, ProductoManufacturado, Long> implements ProductoManufacturadoService {

    public ProductoManufacturadoServiceImpl(ProductoManufacturadoRepository repository,ProductoManufacturadoMapper mapper) {
        super(repository, mapper);
    }
}
