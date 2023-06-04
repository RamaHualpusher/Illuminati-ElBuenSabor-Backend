package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.IngredienteStockActualDto;
import com.illuminati.ebs.entity.IngredienteStockActual;
import com.illuminati.ebs.mapper.IngredienteStockActualMapper;
import com.illuminati.ebs.repository.IngredienteStockActualRepository;
import com.illuminati.ebs.service.IngredienteStockActualService;
import org.springframework.stereotype.Service;

@Service
public class IngredienteStockActualServiceImpl extends GenericServiceImpl<IngredienteStockActualDto, IngredienteStockActual, Long> implements IngredienteStockActualService {

    public IngredienteStockActualServiceImpl(IngredienteStockActualRepository repository, IngredienteStockActualMapper mapper) {
        super(repository, mapper);
    }

}
