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
    public Lavatrice(double consumoOrario,String classeEnergetica,boolean attivo,double durataCiclo){
        super(consumoOrario,classeEnergetica,attivo);
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
    public void consiglio(int orarioAttuale,int temperaturaEsterna,boolean soleggiato){
        if(soleggiato == true)
        {
            if(orarioAttuale>11 && orarioAttuale<15){
                if(temperaturaEsterna>20){
                    System.out.println("Fortemente consigliato di accendere la lavatrice")
                }
                System.out.println("Si può accendere la lavatrice");
            }
            System.out.println("Meglio di non accendere la lavatrice");
        }
        else{
            System.out.println("No, non è assulutamente consigliabile accendere la lavatrice");
        }

    @Override
    public String toString(){
        return super.toString()+",Durata ciclo:"+durataCiclo+" min";
    }

}