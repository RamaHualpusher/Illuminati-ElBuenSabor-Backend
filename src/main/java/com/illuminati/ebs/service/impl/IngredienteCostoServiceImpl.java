package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.IngredienteCostoDto;
import com.illuminati.ebs.entity.IngredienteCosto;
import com.illuminati.ebs.mapper.IngredienteCostoMapper;
import com.illuminati.ebs.repository.IngredienteCostoRepository;
import com.illuminati.ebs.service.IngredienteCostoService;
import org.springframework.stereotype.Service;

@Service
public class IngredienteCostoServiceImpl extends GenericServiceImpl<IngredienteCostoDto, IngredienteCosto, Long> implements IngredienteCostoService {

    public IngredienteCostoServiceImpl(IngredienteCostoRepository repository, IngredienteCostoMapper mapper) {
        super(repository, mapper);
    }

}
