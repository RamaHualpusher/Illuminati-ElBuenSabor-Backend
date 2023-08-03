package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class Base implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activo")
    private Boolean activo;

}