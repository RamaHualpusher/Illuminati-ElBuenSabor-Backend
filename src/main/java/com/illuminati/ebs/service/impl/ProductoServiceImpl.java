package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoDto;
import com.illuminati.ebs.entity.Producto;
import com.illuminati.ebs.mapper.ProductoMapper;
import com.illuminati.ebs.repository.ProductoRepository;
import com.illuminati.ebs.service.ProductoService;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements ProductoService {

    public ProductoServiceImpl(ProductoRepository repository) {
        super(repository);
    }
}
