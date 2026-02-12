package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping("/elettrodomestici")
public class ElettrodomesticoController {

    private final ElettrodomesticoService service;

    public ElettrodomesticoController(ElettrodomesticoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Elettrodomestico> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Elettrodomestico getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Elettrodomestico create(@RequestBody Elettrodomestico e) {
        return service.salva(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    /**
     * Endpoint per calcolare il bilancio energetico
     * GET /elettrodomestici/bilancio?produzione=5.0&soglia=2.0
     * @param produzioneFotovoltaica kwh prodotti dai pannelli solari
     * @param sogliaSurplus soglia minima di surplus per suggerire azioni
     */
    @GetMapping("/bilancio/calcola")
    public Map<String, Object> calcolaBilancio(
            @RequestParam(defaultValue = "0.0") double produzioneFotovoltaica,
            @RequestParam(defaultValue = "1.5") double sogliaSurplus) {
        
        Map<String, Object> risposta = new HashMap<>();
        
        double sommaConsumi = service.calcolaSommaConsumi();
        double surplus = service.calcolaSurplus(produzioneFotovoltaica);
        String consiglioLavatrice = service.consiglioLavatrice(produzioneFotovoltaica, sogliaSurplus);
        
        risposta.put("produzioneFotovoltaica", produzioneFotovoltaica);
        risposta.put("sommaConsumi", sommaConsumi);
        risposta.put("surplus", surplus);
        risposta.put("consiglioLavatrice", consiglioLavatrice);
        risposta.put("numeroDispositivi", service.findAll().size());
        risposta.put("sogliaSurplus", sogliaSurplus);
        
        return risposta;
    }


    @GetMapping("/consiglio-lavatrice")
    public Map<String, String> consiglioLavatrice(
            @RequestParam(defaultValue = "0.0") double produzioneFotovoltaica,
            @RequestParam(defaultValue = "1.5") double sogliaSurplus) {
        
        Map<String, String> risposta = new HashMap<>();
        risposta.put("consiglio", service.consiglioLavatrice(produzioneFotovoltaica, sogliaSurplus));
        return risposta;
    }
}
