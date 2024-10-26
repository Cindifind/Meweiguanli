package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false, unique = true)
        private String authority;

        // Getters and Setters

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getAuthority() {
                return authority;
        }

        public void setAuthority(String authority) {
                this.authority = authority;
        }
}
