package com.illuminati.ebs.controller;

import com.illuminati.ebs.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class GenericController<D, ID extends Serializable> {

    protected GenericService<D, ID> service;

    public GenericController(GenericService<D, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<D>> findAll() throws Exception {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(params = { "page", "size" })
    public ResponseEntity<Page<D>> findAll(Pageable pageable) throws Exception {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable ID id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody D dto) throws Exception {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto) throws Exception {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ID id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }
}
