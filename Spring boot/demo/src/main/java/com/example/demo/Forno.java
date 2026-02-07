package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Forno")
public class Forno extends Elettrodomestico{
    public Forno(){
        super(0.0,"",false);
    }

    public Forno(double consumoOrario, String classeEnergetica,boolean attivo){
        super(consumoOrario,classeEnergetica,attivo);
    }
    
    @Override
    public void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato){
        if(soleggiato == true)
        {
            if(orarioAttuale>11 && orarioAttuale<15){
                if(temperaturaEsterna>20){
                    System.out.println("Fortemente consigliato di accendere il forno");
                }
                System.out.println("Si può accendere il forno");
            }
            System.out.println("Meglio di non accendere il forno");
        }
        else{
            System.out.println("No, non è assultamente consigliato accendere il forno");
        }
    }


    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        double consumoGiornaliere;
        consumoGiornaliere=getConsumoOrario()*oreUsoGiornaliere;
        return consumoGiornaliere*365;
    }
}
