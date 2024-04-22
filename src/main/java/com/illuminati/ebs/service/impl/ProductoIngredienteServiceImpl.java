package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoIngredienteDto;
import com.illuminati.ebs.entity.Producto_Ingrediente;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.mapper.ProductoIngredienteMapper;
import com.illuminati.ebs.repository.Producto_IngredienteRepository;
import com.illuminati.ebs.service.ProductoIngredienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductoIngredienteServiceImpl extends GenericServiceImpl<Producto_Ingrediente, Long> implements ProductoIngredienteService {

    public ProductoIngredienteServiceImpl(Producto_IngredienteRepository repository) {
        super(repository);
    }
    @Override
    @Transactional
    public boolean delete(Long id) throws ServiceException {
        try {
            Optional<Producto_Ingrediente> entityOptional = genericRepository.findById(id);
            if (entityOptional.isPresent()) {
                Producto_Ingrediente entity = entityOptional.get();
                genericRepository.delete(entity);
                return true;
            } else {
                return false; // No se encontró el registro
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}

