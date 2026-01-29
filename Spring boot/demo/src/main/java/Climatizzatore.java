public class Climatizzatore extends Elettrodomestico{
    privare double potenzaBTU;

    public Climatizzatore(double consumoOrario,String classeEnergetica,double potenzaBTU){
        super(consumoOrario,classeEnergetica);
        this.potenzaBTU=potenzaBTU;
    }
    public double getPotenzaBTU(){
        return potenzaBTU;
    }
    public void setPotenzaBTU(double potenzaBTU){
        this.potenzaBTU=potenzaBTU;
    }
    @Override
    public String toString(){
        return super.toString()+",potenza BTU:"+potenzaBTU+"BTU";
    }
    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        return getConsumoOrario()*oreUsoGiornaliere*365;
    }
}