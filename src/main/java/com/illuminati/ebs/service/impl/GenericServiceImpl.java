package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.Base;
import com.illuminati.ebs.mapper.GenericMapper;
import com.illuminati.ebs.repository.GenericRepository;
import com.illuminati.ebs.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<D, E extends Base, ID extends Serializable> implements GenericService<D, ID> {

    protected GenericRepository<E, ID> repository;
    protected GenericMapper<D, E> mapper;

    public GenericServiceImpl(GenericRepository<E, ID> repository, GenericMapper<D, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<D> findAll() throws Exception {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<D> findAll(Pageable pageable) throws Exception {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public D findById(ID id) throws Exception {
        return mapper.toDto(repository.findById(id).orElseThrow(Exception::new));
    }

    @Override
    @Transactional
    public D save(D dto) throws Exception {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    @Transactional
    public D update(ID id, D dto) throws Exception {
        if (!repository.existsById(id)) throw new Exception();
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        if (!repository.existsById(id)) throw new Exception();
        repository.deleteById(id);
        return true;
    }
}
