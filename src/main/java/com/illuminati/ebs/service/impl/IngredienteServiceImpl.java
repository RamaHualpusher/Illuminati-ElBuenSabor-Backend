package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.IngredienteDto;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.entity.Rubro;
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
    public Ingrediente save(Ingrediente entity) throws ServiceException {
        //Se valida que el tipo de rubro sea propio de un ingrediente, si no lo es lanzará un error.
        boolean isIngredient = true;
        if(entity != null){
            if(entity.getRubro()!=null){
                if(entity.getRubro().getIngredientOwner()!=null){
                    isIngredient = entity.getRubro().getIngredientOwner();
                }
            }
        }
        try {
            if(!isIngredient)
                throw new ServiceException("El rubro indicado no pertenece a los ingredientes");
            entity = genericRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
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
    public Ingrediente subtractStock(Ingrediente ingrediente, Integer cantidad) {
        ingrediente.setStockActual(ingrediente.getStockActual() - cantidad);
        return save(ingrediente);
    }
}
