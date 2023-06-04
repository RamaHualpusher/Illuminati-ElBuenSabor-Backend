package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.IngredienteDto;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.mapper.IngredienteMapper;
import com.illuminati.ebs.repository.IngredienteRepository;
import com.illuminati.ebs.service.IngredienteService;
import org.springframework.stereotype.Service;

@Service
public class IngredienteServiceImpl extends GenericServiceImpl<IngredienteDto, Ingrediente, Long> implements IngredienteService {

    public IngredienteServiceImpl(IngredienteRepository repository, IngredienteMapper mapper) {
        super(repository, mapper);
    }

}
