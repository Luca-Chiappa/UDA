package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Climatizzatore")
public class Climatizzatore extends Elettrodomestico{
    @Column
    private double potenzaBTU;

    public Climatizzatore(){
        super(0.0,"",false);
    }

    public Climatizzatore(double consumoOrario,String classeEnergetica,boolean attivo,double potenzaBTU){
        super(consumoOrario,classeEnergetica,attivo);
        this.potenzaBTU=potenzaBTU;
    }
    
    public double getPotenzaBTU(){
        return potenzaBTU;
    }
    @Override
    public void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato){
        if(soleggiato == true)
        {
            if(orarioAttuale>11 && orarioAttuale<15){
                if(temperaturaEsterna>20){
                    System.out.println("Fortemente consigliato di accendere");
                }
                System.out.println("Si può accendere");
            }
            System.out.println("Meglio di no");
        }
        else{
            System.out.println("No");
        }

    }

    public void setPotenzaBTU(double potenzaBTU){
        this.potenzaBTU=potenzaBTU;
    }
    
    @Override
    public String toString(){
        return super.toString()+",potenza BTU:"+potenzaBTU+"BTU";
    }
    
    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        return getConsumoOrario()*oreUsoGiornaliere*365;
    }
}
