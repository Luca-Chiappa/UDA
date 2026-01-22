
@Entity
@Table(name = "Energia");
public class Energia{
    @id
    @GeneretedValue(strategy = GenerationType.IDENTITY);
    public Long id;

    @Column(nullable = false)
    public String classeEnergetica;

    @Column(nullable = false)
    public double consumoOrario;

    public Energia(){}

    public Energia(String classeEnergetica, double consumoOrario){
        this.classeEnergetica = classeEnergetica;
        this.consumoOrario = consumoOrario;
    }
}