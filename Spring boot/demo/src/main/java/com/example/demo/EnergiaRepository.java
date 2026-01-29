package com.example.demo.repository;

import com.example.demo.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA per l'entità Energia.
 *
 * Estende {@link JpaRepository} per fornire operazioni CRUD standard
 * e query di base senza implementazione manuale.
 */
public interface EnergiaRepository extends JpaRepository<Energia, Long> {
}
