package com.illuminati.ebs.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericService<D, ID extends Serializable> {

    List<D> findAll() throws Exception;

    Page<D> findAll(Pageable pageable) throws Exception;

    D findById(ID id) throws Exception;

    D save(D dto) throws Exception;

    D update(ID id, D dto) throws Exception;

    boolean delete(ID id) throws Exception;
}
