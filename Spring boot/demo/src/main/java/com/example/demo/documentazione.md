# Documentazione - Sistema di Gestione Energia

## Repository - EnergiaRepository
Interfaccia repository per la gestione della persistenza dell'entità Energia.
- Estende `JpaRepository<Energia, Long>` per operazioni CRUD automatiche
- Fornisce metodi standard di salvataggio, recupero, aggiornamento e cancellazione

## Service - energiaService
Servizio che gestisce la logica di business per l'entità Energia.

**Metodi:**
- `findAll()`: Recupera tutte le energie dal database
- `findById(Long id)`: Recupera un'energia specifica per ID, lancia eccezione se non trovata
- `salva(Energia e)`: Salva o aggiorna un'energia nel database
- `delete(Long id)`: Elimina un'energia dal database tramite ID

## Controller - ControllerEnergia
Controller REST che espone gli endpoint per gestire le operazioni su Energia.

**Endpoint:**
- `GET /energia`: Recupera tutte le energie
- `GET /energia/{id}`: Recupera un'energia specifica per ID
- `POST /energia`: Crea una nuova energia
- `DELETE /energia/{id}`: Elimina un'energia per ID

## Entity - Energia
Entità JPA che rappresenta un record di energia nel database.

**Attributi:**
- `id`: Identificatore univoco (generato automaticamente)
- `classeEnergetica`: Classe energetica (obbligatoria)
- `consumoOrario`: Consumo orario in kWh (obbligatorio)

**Costruttori:**
- Costruttore vuoto per JPA
- Costruttore con parametri per inizializzazione