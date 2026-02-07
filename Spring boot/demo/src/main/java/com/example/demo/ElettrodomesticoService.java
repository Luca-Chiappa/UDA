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
}
