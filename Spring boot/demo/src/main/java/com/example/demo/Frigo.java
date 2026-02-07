package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Frigo")
public class Frigo extends Elettrodomestico{
    @Column
    private double capacitaLitri;

    public Frigo() {
        super(0.0, "", false);
    }

    public Frigo(double consumoOrario,String classeEnergetica,boolean attivo,double capacitaLitri){
        super(consumoOrario, classeEnergetica,attivo);
        this.capacitaLitri=capacitaLitri;
    }
    
    public double getCapacitaLitri(){
        return capacitaLitri;
    }
    
    public void setCapacitaLitri(double capacitaLitri){
        this.capacitaLitri=capacitaLitri;
    }

    @Override
    public String toString(){
        return super.toString()+",capacita Litri:"+capacitaLitri+"L";
    }

    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        return getConsumoOrario()*oreUsoGiornaliere*365;
    }
    @Override
    public void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato){
        System.out.println("Il frigo deve essere sempre accesa a meno che è vuota");
    }
}
