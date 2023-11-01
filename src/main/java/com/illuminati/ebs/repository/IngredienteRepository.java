package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.exception.ServiceException;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends GenericRepository<Ingrediente,Long>{
}
