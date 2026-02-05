package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergiaService {
    private final EnergiaRepository energiaRepository;

    public EnergiaService(EnergiaRepository energiaRepository) {
        this.energiaRepository = energiaRepository;
    }

    public List<Energia> findAll() {
        return energiaRepository.findAll();
    }

    public Energia findById(Long id) {
        return energiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Energia non trovata"));
    }

    public Energia salva(Energia e) {
        return energiaRepository.save(e);
    }

    public void delete(Long id) {
        energiaRepository.deleteById(id);
    }
}
