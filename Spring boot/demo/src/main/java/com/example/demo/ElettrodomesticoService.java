package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElettrodomesticoService {
    private final ElettrodomesticoRepository repository;

    public ElettrodomesticoService(ElettrodomesticoRepository repository) {
        this.repository = repository;
    }

    public List<Elettrodomestico> findAll() {
        return repository.findAll();
    }

    public Elettrodomestico findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Elettrodomestico non trovato"));
    }

    public Elettrodomestico salva(Elettrodomestico e) {
        return repository.save(e);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Calcola la somma totale dei consumi orari di tutti i dispositivi attivi
     * Implementa il polimorfismo iterando su tutti gli Elettrodomestici dal database
     */
    public double calcolaSommaConsumi() {
        double sommaConsumi = 0.0;
        for (Elettrodomestico dispositivo : repository.findAll()) {
            if (dispositivo.getAttivo()) {
                sommaConsumi += dispositivo.getConsumoOrario();
            }
        }
        return sommaConsumi;
    }

    /**
     * Calcola il bilancio energetico: Surplus = Produzione - ∑Consumi
     * @param produzioneFotovoltaica kwh prodotti dai pannelli solari
     */
    public double calcolaSurplus(double produzioneFotovoltaica) {
        double sommaConsumi = calcolaSommaConsumi();
        return produzioneFotovoltaica - sommaConsumi;
    }

    /**
     * Logica Smart: verifica se è consigliato accendere la lavatrice
     * basandosi sul surplus di energia disponibile
     */
    public String consiglioLavatrice(double produzioneFotovoltaica, double sogliaSurplus) {
        double surplus = calcolaSurplus(produzioneFotovoltaica);
        
        if (surplus > sogliaSurplus) {
            return "CONSIGLIATO: È disponibile surplus di energia fotovoltaica (surplus: " + 
                   String.format("%.2f", surplus) + " kWh). Accendi la lavatrice!";
        } else if (surplus > 0) {
            return "POSSIBILE: Hai energia disponibile ma non è in surplus (surplus: " + 
                   String.format("%.2f", surplus) + " kWh). Valuta se accendere.";
        } else {
            return "NON CONSIGLIATO: Stai consumando più di quanto produci (deficit: " + 
                   String.format("%.2f", Math.abs(surplus)) + " kWh). Non accendere la lavatrice.";
        }
    }
}
