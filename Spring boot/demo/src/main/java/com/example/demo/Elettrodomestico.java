package com.example.demo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "elettrodomestico")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Frigo.class, name = "Frigo"),
    @JsonSubTypes.Type(value = Lavatrice.class, name = "Lavatrice"),
    @JsonSubTypes.Type(value = Forno.class, name = "Forno"),
    @JsonSubTypes.Type(value = Televisione.class, name = "Televisione"),
    @JsonSubTypes.Type(value = Climatizzatore.class, name = "Climatizzatore")
})
public abstract class Elettrodomestico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double consumoOrario;
    
    @Column(nullable = false)
    private String classeEnergetica;
    private boolean attivo;

    public Elettrodomestico() {
    }

    public Elettrodomestico(double consumoOrario, String classeEnergetica, boolean attivo) {
        this.consumoOrario = consumoOrario;
        this.classeEnergetica = classeEnergetica;
        this.attivo = attivo;
    }

    public Long getId() {
        return id;
    }

    public boolean getAttivo(){
        return attivo;
    }

    public void setAttivo(boolean attivo){
        this.attivo=attivo;
    }

    public double getConsumoOrario(){
        return consumoOrario;
    }

    public void setConsumoOrario(double consumoOrario){
        this.consumoOrario = consumoOrario;
    }

    public String getClasseEnergetica(){
        return classeEnergetica;
    }

    public void setClasseEnergetica(String classeEnergetica){
        this.classeEnergetica = classeEnergetica;
    }

    public abstract double calcolaConsumoAnnuale(int oreUsoGiornaliere);

    public abstract void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato);

    @Override
    public String toString(){
        return "Classe Energetica: " + classeEnergetica + ", Consumo Orario: " + consumoOrario + "Kw*h";
    }
}
