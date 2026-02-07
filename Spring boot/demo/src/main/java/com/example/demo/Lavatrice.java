package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Lavatrice")
public class Lavatrice extends Elettrodomestico{
    @Column
    private double durataCiclo;

    public Lavatrice(){
        super(0.0,"",false);
    }

    public Lavatrice(double consumoOrario,String classeEnergetica,boolean attivo,double durataCiclo){
        super(consumoOrario,classeEnergetica,attivo);
        this.durataCiclo=durataCiclo;
    }

    public double getDurataCiclo(){
        return durataCiclo;
    }
    
    public void setDurataCiclo(double durataCiclo){
        this.durataCiclo = durataCiclo;
    }

    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        double consumoGiornaliere;
        consumoGiornaliere=getConsumoOrario()*oreUsoGiornaliere;
        return consumoGiornaliere*365;
    }

    @Override
    public void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato){
        if(soleggiato == true)
        {
            if(orarioAttuale>11 && orarioAttuale<15){
                if(temperaturaEsterna>20){
                    System.out.println("Fortemente consigliato di accendere la lavatrice");
                }
                System.out.println("Si può accendere la lavatrice");
            }
            System.out.println("Meglio di non accendere la lavatrice");
        }
        else{
            System.out.println("No, non è assulutamente consigliabile accendere la lavatrice");
        }
    }

    @Override
    public String toString(){
        return super.toString()+",Durata ciclo:"+durataCiclo+" min";
    }
}
