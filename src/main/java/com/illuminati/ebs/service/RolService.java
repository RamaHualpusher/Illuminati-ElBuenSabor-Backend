package com.illuminati.ebs.service;

import com.illuminati.ebs.entity.Rol;
public interface RolService extends GenericService<Rol, Long> {
    Rol findByNombreRol(String nombreRol);
}
