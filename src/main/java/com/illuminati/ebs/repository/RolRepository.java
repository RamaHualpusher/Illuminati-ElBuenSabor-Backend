package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.Rol;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends GenericRepository<Rol, Long> {
    Rol findByNombreRol(String nombreRol);
}
