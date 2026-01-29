/**
 * Classe che rappresenta un forno.
 * 
 * Estende Elettrodomestico e rappresenta un forno da cucina.
 * Non possiede attributi specifici oltre a quelli della classe madre.
 */
public class Forno extends Elettrodomestico{
    /**
     * Costruttore per inizializzare un forno.
     * 
     * @param consumoOrario consumo orario in kWh
     * @param classeEnergetica classe energetica del forno
     */
    public Forno(double consumoOrario, String classeEnergetica){
        super(consumoOrario,classeEnergetica);
    }
    
    /**
     * Calcola il consumo annuale del forno.
     * Formula: consumo orario * ore di utilizzo giornaliere * 365 giorni
     * Tipicamente utilizzato 1-2 ore per utilizzo.
     * 
     * @param oreUsoGiornaliere numero di ore di utilizzo giornaliero
     * @return consumo annuale in kWh
     */
    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        double consumoGiornaliere;
        consumoGiornaliere=getConsumoOrario()*oreUsoGiornaliere;
        return consumoGiornaliere*365;
    }
}