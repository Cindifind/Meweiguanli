package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "visitors")
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer del;
    private Integer level;
    private Integer level2;
    // Getters and Setters
}
