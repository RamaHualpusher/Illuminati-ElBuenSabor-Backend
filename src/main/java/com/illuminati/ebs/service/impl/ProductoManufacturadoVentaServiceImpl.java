package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoManufacturadoVentaDto;
import com.illuminati.ebs.entity.ProductoManufacturadoVenta;
import com.illuminati.ebs.mapper.ProductoManufacturadoVentaMapper;
import com.illuminati.ebs.repository.ProductoManufacturadoVentaRepository;
import com.illuminati.ebs.service.ProductoManufacturadoVentaService;
import org.springframework.stereotype.Service;

@Service
public class ProductoManufacturadoVentaServiceImpl extends GenericServiceImpl<ProductoManufacturadoVentaDto, ProductoManufacturadoVenta, Long> implements ProductoManufacturadoVentaService {

    public ProductoManufacturadoVentaServiceImpl(ProductoManufacturadoVentaRepository repository, ProductoManufacturadoVentaMapper mapper) {
        super(repository, mapper);
    }

}
