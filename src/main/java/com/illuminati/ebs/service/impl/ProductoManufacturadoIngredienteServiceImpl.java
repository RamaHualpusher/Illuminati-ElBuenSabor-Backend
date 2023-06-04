package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.dto.ProductoManufacturadoIngredienteDto;
import com.illuminati.ebs.entity.ProductoManufacturado_Ingrediente;
import com.illuminati.ebs.mapper.ProductoManufacturadoIngredienteMapper;
import com.illuminati.ebs.repository.ProductoManufacturado_IngredienteRepository;
import com.illuminati.ebs.service.ProductoManufacturadoIngredienteService;
import org.springframework.stereotype.Service;

@Service
public class ProductoManufacturadoIngredienteServiceImpl extends GenericServiceImpl<ProductoManufacturadoIngredienteDto, ProductoManufacturado_Ingrediente, Long> implements ProductoManufacturadoIngredienteService {

    public ProductoManufacturadoIngredienteServiceImpl(ProductoManufacturado_IngredienteRepository repository, ProductoManufacturadoIngredienteMapper mapper) {
        super(repository, mapper);
    }


}
