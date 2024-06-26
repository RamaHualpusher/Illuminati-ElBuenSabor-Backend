package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.IngredienteDto;
import com.illuminati.ebs.entity.Ingrediente;
import com.illuminati.ebs.exception.ServiceException;
import com.illuminati.ebs.service.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ingrediente")


public class IngredienteController extends GenericController<Ingrediente, Long>{
    private final IngredienteService service;
    public IngredienteController(IngredienteService service) {
        super(service);
        this.service = service;
    }

    @PutMapping("/{ingredienteId}/addStock/{cantidad}")
    public ResponseEntity<?> addStock(@PathVariable Long ingredienteId, @PathVariable Integer cantidad) {
        try {
            Ingrediente ingrediente = service.addStock(ingredienteId, cantidad);
            return new ResponseEntity<>(ingrediente, HttpStatus.OK);
        } catch (ServiceException e) {
            System.out.println("cantidad" + cantidad);
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
    }

    @PutMapping("/{ingredienteId}/subtractStock/{cantidad}")
    public ResponseEntity<?> subtractStock(@RequestBody Ingrediente ingredienteBody, @PathVariable Integer cantidad) {
        try {
            Ingrediente ingrediente = service.subtractStock(ingredienteBody, cantidad);
            return new ResponseEntity<>(ingrediente, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
    }
}
