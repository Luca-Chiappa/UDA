package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Televisione")
public class Televisione extends Elettrodomestico{
    @Column
    private double pollici;

    public Televisione(){
        super(0.0,"",false);
    }

    public Televisione(double consumoOrario,String classeEnergetica,boolean attivo,double pollici){
        super(consumoOrario,classeEnergetica,attivo);
        this.pollici=pollici;
    }

    public double getPollici(){
        return pollici;
    }
    
    public void setPollici(double pollici){
        this.pollici=pollici;
    }
    
    @Override
    public String toString(){
        return super.toString()+",pollici:"+pollici+"\"";
    }
    
    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        return getConsumoOrario()*oreUsoGiornaliere*365;
    }

    @Override
    public void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato){
        if(soleggiato == true)
        {
            if(orarioAttuale>11 && orarioAttuale<15){
                if(temperaturaEsterna>20){
                    System.out.println("Fortemente consigliato di accendere la televisione");
                }
                System.out.println("Si può accendere la televisione");
            }
            System.out.println("Meglio di non accendere la televisione");
        }
        else{
            System.out.println("No, non è consigliato accendere la televisione");
        }
    }

}
