package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "visitors")
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DEL")
    private Integer del;

    @Column(name = "GA")
    private Integer ga;

    @Column(name = "OAAA")
    private Integer oaaa;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getGa() {
        return ga;
    }

    public void setGa(Integer ga) {
        this.ga = ga;
    }

    public Integer getOaaa() {
        return oaaa;
    }

    public void setOaaa(Integer oaaa) {
        this.oaaa = oaaa;
    }
}
