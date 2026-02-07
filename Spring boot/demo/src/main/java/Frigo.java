/**
 * Classe che rappresenta un frigorifero.
 * 
 * Estende Elettrodomestico e aggiunge l'attributo specifico della capacità in litri.
 */
public class Frigo extends Elettrodomestico{
    /** Capacità di stoccaggio in litri */
    private double capacitaLitri;

    /**
     * Costruttore per inizializzare un frigorifero.
     * 
     * @param consumoOrario consumo orario in kWh
     * @param classeEnergetica classe energetica del frigorifero
     * @param capacitaLitri capacità di stoccaggio in litri
     */
    public Frigo(double consumoOrario,String classeEnergetica,boolean attivo,double capacitaLitri){
        super(consumoOrario, classeEnergetica,attivo);
        this.capacitaLitri=capacitaLitri;
    }
    
    /**
     * Restituisce la capacità di stoccaggio del frigorifero.
     * 
     * @return capacità in litri
     */
    public double getCapacitaLitri(){
        return capacitaLitri;
    }
    
    /**
     * Imposta la capacità di stoccaggio del frigorifero.
     * 
     * @param capacitaLitri capacità in litri
     */
    public void setCapacitaLitri(double capacitaLitri){
        this.capacitaLitri=capacitaLitri;
    }

    @Override
    public String toString(){
        return super.toString()+",capacita Litri:"+capacitaLitri+"L";
    }

    /**
     * Calcola il consumo annuale del frigorifero.
     * Formula: consumo orario * ore di utilizzo giornaliere * 365 giorni
     * Il frigorifero ha un utilizzo quasi continuo.
     * 
     * @param oreUsoGiornaliere numero di ore di utilizzo giornaliero
     * @return consumo annuale in kWh
     */
    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        return getConsumoOrario()*oreUsoGiornaliere*365;
    }
    @Override
    public void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato){
        System.out.println("Il frigo deve essere sempre accesa a meno che è vuota");
}