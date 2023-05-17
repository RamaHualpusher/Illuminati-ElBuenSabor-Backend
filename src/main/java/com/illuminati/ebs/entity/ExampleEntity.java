package com.illuminati.ebs.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "example_entity")
@Data
public class ExampleEntity extends Base{

    @Column
    private String name;
}