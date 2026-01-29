public class Lavatrice extends Elettrodomestico(){
    private double durataCiclo;

    public Lavatrice(double consumoOrario,String classeEnergetica,double durataCiclo){
        super(consumoOrario,classeEnergetica);
        this.durataCiclo=durataCiclo;
    }

    public double getDurataCiclo(){
        return durataCiclo;
    }
    
    public void setDurataCiclo(){
        this.durataCiclo = durataCiclo;
    }

    @Override
    public calcolaConsumoAnnuale(int oreUsoGiornaliere)
    double consumoGiornaliere;
    consumoGiornaliere=consumoOrario*oreUsoGiornaliere;
    return consumoGiornaliere*365;

    @Override
    public String toString(){
        return super.toString()+",Durata ciclo:"+durataCiclo;
    }

}