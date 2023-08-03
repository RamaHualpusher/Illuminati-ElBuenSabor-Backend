package com.illuminati.ebs.service.impl;

import com.illuminati.ebs.entity.Base;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.repository.GenericRepository;
import com.illuminati.ebs.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<T extends Base, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericRepository<T,ID> genericRepository;

    public GenericServiceImpl(GenericRepository<T, ID> genericRepository)
    {
        this.genericRepository = genericRepository;
    }

    @Override
    @Transactional
    public List<T> findAll() throws ServiceException {
        try {
            return genericRepository.findAll();
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T findById(ID id) throws ServiceException {
        try {
            return genericRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró ninguna entidad con el ID: " + id));
        } catch (EntityNotFoundException e) {
            throw new ServiceException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @Override
    @Transactional
    public T save(T entity) throws ServiceException {
        try {
            entity = genericRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T update(T entity) throws ServiceException {
        try {
            if (entity.getId() == null) {
                throw new ServiceException("La entidad a modificar debe contener un Id.");
            }
            return genericRepository.save(entity);
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws ServiceException {
        try {
            genericRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<T> findAll(Pageable pageable) throws ServiceException {
        try {
            Page<T> entities = genericRepository.findAll(pageable);
            return entities;
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
