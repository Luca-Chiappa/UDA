/**
 * Classe che rappresenta una televisione.
 * 
 * Estende Elettrodomestico e aggiunge l'attributo specifico della dimensione dello schermo in pollici.
 */
public class Televisione extends Elettrodomestico{
    /** Dimensione dello schermo in pollici */
    private double pollici;

    /**
     * Costruttore per inizializzare una televisione.
     * 
     * @param consumoOrario consumo orario in kWh
     * @param classeEnergetica classe energetica della TV
     * @param pollici dimensione dello schermo in pollici
     */
    public Televisione(double consumoOrario,String classeEnergetica,boolean attivo,double pollici){
        super(consumoOrario,classeEnergetica,attivo);
        this.pollici=pollici;
    }

    /**
     * Restituisce la dimensione dello schermo.
     * 
     * @return dimensione in pollici
     */
    public double getPollici(){
        return pollici;
    }
    
    /**
     * Imposta la dimensione dello schermo.
     * 
     * @param pollici dimensione in pollici
     */
    public void setPollici(double pollici){
        this.pollici=pollici;
    }
    
    @Override
    public String toString(){
        return super.toString()+",pollici:"+pollici+"\"";
    }
    
    /**
     * Calcola il consumo annuale della televisione.
     * Formula: consumo orario * ore di utilizzo giornaliere * 365 giorni
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