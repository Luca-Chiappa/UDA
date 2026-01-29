@RestController
@RequestMapping("/energia")
/**
 * Controller REST per le operazioni CRUD sull'entità "Energia".
 *
 * Espone endpoint sotto la base "/energia" e delega la logica
 * di business al relativo servizio.
 */
@RestController
@RequestMapping("/energia")
public class ControllerEnergia{

    /** Service che gestisce la logica di persistenza e accesso ai dati di Energia. */
    private final energiaService energiaService;

    /**
     * Costruttore per l'iniezione del servizio.
     *
     * @param energiaService istanza del servizio da iniettare
     */
    public EnergiaController(EnergiaRepository energiaService){
        this.energiaService = energiaService;
    }

    /**
     * Recupera tutte le entità Energia presenti.
     *
     * @return lista di oggetti Energia
     */
    @GetMapping
    public List<Energia> getAll(){
        return energiaService.findAll();
    }

    /**
     * Recupera l'entità Energia con l'identificatore specificato.
     *
     * @param id identificatore dell'entità
     * @return istanza di Energia corrispondente all'id
     */
    @GetMapping("/{id}")
    public Energia getById(@PathVariable Long id){
        return energiaService.findById(id);
    }

    /**
     * Crea una nuova entità Energia.
     *
     * @param e entità da creare
     * @return entità salvata
     */
    @PostMapping
    public Energia create(@RequestMapping Energia e){
        return energiaService.salva(e);
    }

    /**
     * Elimina l'entità Energia con l'identificatore indicato.
     *
     * @param id identificatore dell'entità da cancellare
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        energiaService.delete(id);
    }
}