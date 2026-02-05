

package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Energia")
public class Energia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String classeEnergetica;

    @Column(nullable = false)
    public double consumoOrario;

    public Energia() {}

    public Energia(String classeEnergetica, double consumoOrario) {
        this.classeEnergetica = classeEnergetica;
        this.consumoOrario = consumoOrario;
    }

}