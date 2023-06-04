package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoBebidaStockActualDto;
import com.illuminati.ebs.entity.ProductoBebidaStockActual;
import com.illuminati.ebs.mapper.ProductoBebidaStockActualMapper;
import com.illuminati.ebs.repository.ProductoBebidaStockActualRepository;
import com.illuminati.ebs.service.ProductoBebidaStockActualService;
import org.springframework.stereotype.Service;

@Service
public class ProductoBebidaStockActualServiceImpl extends GenericServiceImpl<ProductoBebidaStockActualDto, ProductoBebidaStockActual, Long> implements ProductoBebidaStockActualService {

    public ProductoBebidaStockActualServiceImpl(ProductoBebidaStockActualRepository repository, ProductoBebidaStockActualMapper mapper) {
        super(repository, mapper);
    }

}
