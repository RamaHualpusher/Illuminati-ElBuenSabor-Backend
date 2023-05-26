package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Long> {
}
