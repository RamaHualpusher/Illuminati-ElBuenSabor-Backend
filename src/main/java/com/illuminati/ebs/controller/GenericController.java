package com.illuminati.ebs.controller;

import com.illuminati.ebs.entity.Base;
import com.illuminati.ebs.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.illuminati.ebs.exception.ErrorResponse;
import com.illuminati.ebs.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

public abstract class GenericController<T extends Base, ID extends Serializable> {

    protected GenericService<T, ID> service;

    public GenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() throws Exception {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/active")
    public ResponseEntity<List<T>> findAllActive() throws Exception {
        return ResponseEntity.ok(service.findAllActive());
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<T>> findAllInactive() throws Exception {
        return ResponseEntity.ok(service.findAllActiveFalse());
    }


    @GetMapping(params = { "page", "size" })
    public ResponseEntity<Page<T>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T entity) throws Exception {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T entity) throws Exception {
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ID id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }
    // Manejo de excepciones
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        HttpStatus httpStatus = ex.getHttpStatus();
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), ex.getMessage());
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}
