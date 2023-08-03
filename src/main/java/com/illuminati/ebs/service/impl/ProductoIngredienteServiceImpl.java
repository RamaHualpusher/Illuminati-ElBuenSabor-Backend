package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoIngredienteDto;
import com.illuminati.ebs.entity.Producto_Ingrediente;
import com.illuminati.ebs.mapper.ProductoIngredienteMapper;
import com.illuminati.ebs.repository.Producto_IngredienteRepository;
import com.illuminati.ebs.service.ProductoIngredienteService;
import org.springframework.stereotype.Service;

@Service
public class ProductoIngredienteServiceImpl extends GenericServiceImpl<Producto_Ingrediente, Long> implements ProductoIngredienteService {

    public ProductoIngredienteServiceImpl(Producto_IngredienteRepository repository) {
        super(repository);
    }


}
