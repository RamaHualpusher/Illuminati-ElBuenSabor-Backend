package com.illuminati.ebs.repository;

import com.illuminati.ebs.entity.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepository<E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}
