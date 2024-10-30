package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="visitors")
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer del;
    private String reason;
    private String created_at;
    private Integer GA;
    private Integer OAAA;
    private String carID;
    private String phonenum;
    // Getters and Setters

}