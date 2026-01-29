public abstract class Elettrodomestico {
    private double consumoOrario;
    private String classeEnergetica;
    
    public Elettrodomestico(double consumoOrario, String classeEnergetica)
    {
        this.consumoOrario = consumoOrario;
        this.classeEnergetica = classeEnergetica;
    }

    public double getConsumoOrario(){
        return consumoOrario;
    }

    public void setConsumoOrario(double consumoOrario){
        this.consumoOrario = consumoOrario;
    }

    public String getClasseEnergetica(){
        return classeEnergetica;
    }

    public void setClasseEnergetica(String classeEnergetica){
        this.classeEnergetica = classeEnergetica;
    }

    public abstract double calcolaConsumoAnnuale(int oreUsoGiornaliere);

    @Override
    public String toString(){
        return "Classe Energetica: " + classeEnergetica + ", Consumo Orario: " + consumoOrario+"Kw*h";
    }
}