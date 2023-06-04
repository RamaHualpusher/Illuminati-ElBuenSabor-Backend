package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoManufacturadoCostoDto;
import com.illuminati.ebs.entity.ProductoManufacturadoCosto;
import com.illuminati.ebs.mapper.ProductoManufacturadoCostoMapper;
import com.illuminati.ebs.repository.ProductoManufacturadoCostoRepository;
import com.illuminati.ebs.service.ProductoManufacturadoCostoService;
import org.springframework.stereotype.Service;

@Service
public class ProductoManufacturadoCostoImpl extends GenericServiceImpl<ProductoManufacturadoCostoDto, ProductoManufacturadoCosto, Long> implements ProductoManufacturadoCostoService {

    public ProductoManufacturadoCostoImpl(ProductoManufacturadoCostoRepository repository, ProductoManufacturadoCostoMapper mapper) {
        super(repository, mapper);
    }

}
