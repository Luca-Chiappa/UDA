package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Controller REST per le operazioni CRUD sull'entità "Energia".
 * Espone endpoint sotto la base "/energia" e delega la logica di business al relativo servizio.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping("/energia")
public class ControllerEnergia {

    private final EnergiaService energiaService;

    public ControllerEnergia(EnergiaService energiaService) {
        this.energiaService = energiaService;
    }

    @GetMapping
    public List<Energia> getAll() {
        return energiaService.findAll();
    }

    @GetMapping("/{id}")
    public Energia getById(@PathVariable Long id) {
        return energiaService.findById(id);
    }

    @PostMapping
    public Energia create(@RequestBody Energia e) {
        return energiaService.salva(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        energiaService.delete(id);
    }

}