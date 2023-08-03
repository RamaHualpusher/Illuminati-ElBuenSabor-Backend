package com.illuminati.ebs.service;


import com.illuminati.ebs.entity.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends Base, ID extends Serializable> {

    List<T> findAll() throws Exception;

    Page<T> findAll(Pageable pageable) throws Exception;

    T findById(ID id) throws Exception;

    T save(T entity) throws Exception;

    T update(T entity) throws Exception;

    boolean delete(ID id) throws Exception;
}
