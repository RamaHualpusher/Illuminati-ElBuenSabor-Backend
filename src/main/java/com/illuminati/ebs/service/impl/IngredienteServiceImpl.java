package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.IngredienteDto;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.IngredienteMapper;
import com.illuminati.ebs.repository.IngredienteRepository;
import com.illuminati.ebs.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredienteServiceImpl extends GenericServiceImpl<Ingrediente, Long> implements IngredienteService {
    private final IngredienteRepository repository;
    public IngredienteServiceImpl(IngredienteRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional
    public Ingrediente addStock(Long ingredienteId, Integer cantidad) {
        if (cantidad <= 0) {
            throw new ServiceException("La cantidad debe ser un número positivo.", HttpStatus.BAD_REQUEST);
        }

        Ingrediente ingrediente = findById(ingredienteId);

        ingrediente.setStockActual(ingrediente.getStockActual() + cantidad);

        return save(ingrediente);
    }

    @Override
    @Transactional
    public Ingrediente subtractStock(Long ingredienteId, Integer cantidad) {
        if (cantidad <= 0) {
            throw new ServiceException("La cantidad debe ser un número positivo.", HttpStatus.BAD_REQUEST);
        }

        Ingrediente ingrediente = findById(ingredienteId);

        if(ingrediente.getStockActual() < cantidad){
            throw new ServiceException("No hay suficiente stock para restar.", HttpStatus.BAD_REQUEST);
        }
        ingrediente.setStockActual(ingrediente.getStockActual() - cantidad);

        return save(ingrediente);
    }
}
