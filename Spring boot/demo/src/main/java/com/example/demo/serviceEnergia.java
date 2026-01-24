@Service
public class energiaService{
    private final EnergiaRepository energiaRepository;

    public energiaService(EnergiaRepository energiaRepository){
        this.energiaRepository = energiaRepository;
    }

    public List<Energia> findAll(){
        return energiaRepository.findAll();
    }

    public Energia findById(Long id){
        return energiaRepository.findById(id).orElseThrow(()-> new RuntimeException);
    }

    public Energia salva(Energia e){
        return energiaRepository.save(energia);
    }

    public void delete(Long id){
        energiaRepository.deleteById(id);
    }
}