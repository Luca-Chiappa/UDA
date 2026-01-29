@Service
/**
 * Service che incapsula la logica di business per `Energia`.
 *
 * Fornisce metodi per recuperare, salvare e cancellare entità Energia.
 */
public class energiaService{
    private final EnergiaRepository energiaRepository;

    /**
     * Costruttore per l'iniezione del repository.
     *
     * @param energiaRepository repository per l'entità Energia
     */
    public energiaService(EnergiaRepository energiaRepository){
        this.energiaRepository = energiaRepository;
    }

    /**
     * Restituisce tutte le entità Energia presenti nel database.
     *
     * @return lista di Energia
     */
    public List<Energia> findAll(){
        return energiaRepository.findAll();
    }

    /**
     * Recupera l'entità Energia con il dato identificatore.
     *
     * @param id identificatore dell'entità
     * @return Energia trovata
     * @throws RuntimeException se l'entità non viene trovata
     */
    public Energia findById(Long id){
        return energiaRepository.findById(id).orElseThrow(()-> new RuntimeException);
    }

    /**
     * Salva (crea o aggiorna) un'istanza di Energia.
     *
     * @param e entità da salvare
     * @return entità salvata
     */
    public Energia salva(Energia e){
        return energiaRepository.save(energia);
    }

    /**
     * Elimina l'entità Energia con l'identificatore specificato.
     *
     * @param id identificatore dell'entità da eliminare
     */
    public void delete(Long id){
        energiaRepository.deleteById(id);
    }
}