/**
 * Classe che rappresenta un climatizzatore.
 * 
 * Estende Elettrodomestico e aggiunge l'attributo specifico della potenza in BTU.
 * Può essere utilizzato sia per il raffreddamento che per il riscaldamento.
 */
public class Climatizzatore extends Elettrodomestico{
    /** Potenza del climatizzatore in BTU (British Thermal Units) */
    private double potenzaBTU;

    /**
     * Costruttore per inizializzare un climatizzatore.
     * 
     * @param consumoOrario consumo orario in kWh
     * @param classeEnergetica classe energetica del climatizzatore
     * @param potenzaBTU potenza in BTU
     */
    public Climatizzatore(double consumoOrario,String classeEnergetica,boolean attivo,double potenzaBTU){
        super(consumoOrario,classeEnergetica,attivo);
        this.potenzaBTU=potenzaBTU;
    }
    
    /**
     * Restituisce la potenza del climatizzatore.
     * 
     * @return potenza in BTU
     */
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
    /**
     * Imposta la potenza del climatizzatore.
     * 
     * @param potenzaBTU potenza in BTU
     */
    public void setPotenzaBTU(double potenzaBTU){
        this.potenzaBTU=potenzaBTU;
    }
    
    @Override
    public String toString(){
        return super.toString()+",potenza BTU:"+potenzaBTU+"BTU";
    }
    
    /**
     * Calcola il consumo annuale del climatizzatore.
     * Formula: consumo orario * ore di utilizzo giornaliere * 365 giorni
     * Il consumo varia in base alla modalità (raffreddamento: 1,96 kWh/h, riscaldamento: 2,6 kWh/h)
     * 
     * @param oreUsoGiornaliere numero di ore di utilizzo giornaliero
     * @return consumo annuale in kWh
     */
    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        return getConsumoOrario()*oreUsoGiornaliere*365;
    }
}