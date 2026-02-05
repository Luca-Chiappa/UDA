/**
 * Classe astratta che rappresenta un elettrodomestico generico.
 * 
 * Fornisce attributi comuni a tutti gli elettrodomestici come il consumo orario
 * e la classe energetica. Ogni sottoclasse deve implementare il calcolo del consumo annuale
 * in base alle proprie caratteristiche specifiche.
 */
public abstract class Elettrodomestico {
    /** Consumo orario dell'elettrodomestico in kWh */
    private double consumoOrario;
    
    /** Classe energetica dell'elettrodomestico (A+, A, B, ecc.) */
    private String classeEnergetica;
    private boolean attivo;
    /**
     * Costruttore per inizializzare un elettrodomestico.
     * 
     * @param consumoOrario consumo orario in kWh
     * @param classeEnergetica classe energetica dell'apparecchio
     */
    public Elettrodomestico(double consumoOrario, String classeEnergetica,boolean attivo)
    {
        this.consumoOrario = consumoOrario;
        this.classeEnergetica = classeEnergetica;
        this.attivo=attivo;

    }

    public boolean getAttivo(){
        return attivo
    }

    public void setAttivo(boolean attivo){
        this.attivo=attivo;
    }

    /**
     * Restituisce il consumo orario dell'elettrodomestico.
     * 
     * @return consumo orario in kWh
     */
    public double getConsumoOrario(){
        return consumoOrario;
    }

    /**
     * Imposta il consumo orario dell'elettrodomestico.
     * 
     * @param consumoOrario consumo orario in kWh
     */
    public void setConsumoOrario(double consumoOrario){
        this.consumoOrario = consumoOrario;
    }

    /**
     * Restituisce la classe energetica dell'elettrodomestico.
     * 
     * @return classe energetica
     */
    public String getClasseEnergetica(){
        return classeEnergetica;
    }

    /**
     * Imposta la classe energetica dell'elettrodomestico.
     * 
     * @param classeEnergetica classe energetica dell'apparecchio
     */
    public void setClasseEnergetica(String classeEnergetica){
        this.classeEnergetica = classeEnergetica;
    }

    /**
     * Calcola il consumo annuale dell'elettrodomestico.
     * Metodo astratto che deve essere implementato da ogni sottoclasse.
     * 
     * @param oreUsoGiornaliere numero di ore di uso giornaliero
     * @return consumo annuale in kWh
     */
    public abstract double calcolaConsumoAnnuale(int oreUsoGiornaliere);

    public abstract void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato)

    @Override
    public String toString(){
        return "Classe Energetica: " + classeEnergetica + ", Consumo Orario: " + consumoOrario+"Kw*h";
    }
}