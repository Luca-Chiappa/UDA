package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Energia;

/**
 * Repository JPA per l'entità Energia.
 *
 * Estende {@link JpaRepository} per fornire operazioni CRUD standard
 * e query di base senza implementazione manuale.
 */
public interface EnergiaRepository extends JpaRepository<Energia, Long> {
}
