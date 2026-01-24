@RestController
@RequestMapping("/energia")

public class ControllerEnergia{

    private final energiaService energiaService;

    public EnergiaController(EnergiaRepository energiaService){
        this.energiaService = energiaService;
    }

    @GetMapping
    public List<Energia> getAll(){
        return energiaService.findAll();
    }

    @GetMapping("/{id}")
    public Energia getById(@PathVariable Long id){
        return energiaService.findById(id);
    }

    @PostMapping
    public Energia create(@RequestMapping Energia e){
        return energiaService.salva(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        energiaService.delete(id);
    }
}