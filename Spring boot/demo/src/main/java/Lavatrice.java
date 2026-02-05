/**
 * Classe che rappresenta una lavatrice.
 * 
 * Estende Elettrodomestico e aggiunge l'attributo specifico della durata del ciclo di lavaggio in minuti.
 */
public class Lavatrice extends Elettrodomestico{
    /** Durata di un ciclo di lavaggio in minuti */
    private double durataCiclo;

    /**
     * Costruttore per inizializzare una lavatrice.
     * 
     * @param consumoOrario consumo orario in kWh
     * @param classeEnergetica classe energetica della lavatrice
     * @param durataCiclo durata del ciclo di lavaggio in minuti
     */
    public Lavatrice(double consumoOrario,String classeEnergetica,double durataCiclo){
        super(consumoOrario,classeEnergetica);
        this.durataCiclo=durataCiclo;
    }

    /**
     * Restituisce la durata del ciclo di lavaggio.
     * 
     * @return durata in minuti
     */
    public double getDurataCiclo(){
        return durataCiclo;
    }
    
    
    /**
     * Imposta la durata del ciclo di lavaggio.
     * 
     * @param durataCiclo durata in minuti
     */
    public void setDurataCiclo(double durataCiclo){
        this.durataCiclo = durataCiclo;
    }

    /**
     * Calcola il consumo annuale della lavatrice.
     * Formula: consumo orario * ore di utilizzo giornaliere * 365 giorni
     * Considerando che un ciclo tipico dura 45-90 minuti.
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

    @Override
    public String toString(){
        return super.toString()+",Durata ciclo:"+durataCiclo+" min";
    }

}