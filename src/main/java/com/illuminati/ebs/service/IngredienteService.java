package com.illuminati.ebs.service;

import com.illuminati.ebs.entity.Ingrediente;

public interface IngredienteService extends GenericService<Ingrediente, Long>{
    public Ingrediente addStock(Long ingredienteId, Integer cantidad);
    public Ingrediente subtractStock(Long ingredienteId, Integer cantidad);
}
