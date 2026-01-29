public class Frigo extends Elettrodomestico{
    private double capacitaLitri;

    public Frigo(double consumoOrario,String classeEnergetica,double capacitaLitri){
        super(consumoOrario, classeEnergetica);
        this.capacitaLitri=capacitaLitri;
    }
    public double getCapacitaLitri(){
        return capacitaLitri;
    }
    public void setCapacitaLitri(double capacitaLitri){
        this.capacitaLitri=capacitaLitri;
    }

    @Override
    public String toString(){
        return super.toString()+",capacita Litri:"+capacitaLitri+"L";
    }

    @Override
    public double calcolaConsumoAnnuale(int oreUsoGiornaliere){
        return getConsumoOrario()*oreUsoGiornaliere*365;
    }
}