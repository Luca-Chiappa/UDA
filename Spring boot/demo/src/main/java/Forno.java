public class Forno extends Elettrodomestico(){
    public Forno(double consumoOrario, String classeEnergetica){
        super(consumoOrario,classeEnergetica);
    }
    
    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        double consumoGiornaliere;
        consumoGiornaliere=consumoOrario*oreUsoGiornaliere;
        return consumoGiornaliere*365;
    }
    

}