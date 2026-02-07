package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
