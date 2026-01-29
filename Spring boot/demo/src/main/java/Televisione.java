public class Televisione extends Elettrodomestico{
    private double pollici;

    public Televisione(double consumoOrario,String classeEnergetica,double pollici){
        super(consumoOrario,classeEnergetica);
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
    
}