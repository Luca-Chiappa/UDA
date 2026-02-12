# UDA
# Documentazione - Sistema di Gestione Energia

### Architettura Implementata

È stata creata una gerarchia di classi per la gestione degli elettrodomestici utilizzando il pattern di ereditarietà:

#### **Classe Base Astratta: `Elettrodomestico`**
- **Attributi comuni**: 
  - `consumoOrario` (double): consumo in kWh per ora
  - `classeEnergetica` (String): classificazione energetica (A+, A, B, etc.)
- **Metodi**:
  - `getConsumoOrario()` / `setConsumoOrario()`: getter e setter per il consumo
  - `getClasseEnergetica()` / `setClasseEnergetica()`: getter e setter per la classe energetica
  - `calcolaConsumoAnnuale(int oreUsoGiornaliere)`: **metodo astratto** che ogni sottoclasse deve implementare

#### **Classe Concreta: `Televisione`**
- **Attributi specifici**: `pollici` (dimensione dello schermo)
- **Implementazione**: Calcola consumo annuale moltiplicando ore giornaliere per 365 giorni
- **Caso d'uso**: TV 32" classe F

#### **Classe Concreta: `Frigorifero`**
- **Attributi specifici**: `capacitaLitri` (capacità di stoccaggio)
- **Implementazione**: Calcola consumo annuale considerando l'utilizzo quasi continuo
- **Caso d'uso**: Frigo classe B con consumo medio annuale ~140 kWh

#### **Classe Concreta: `Forno`**
- **Attributi specifici**: nessuno (utilizza solo quelli della classe madre)
- **Implementazione**: Calcola consumo basato su ore di utilizzo giornaliere
- **Caso d'uso**: Forno classe A+ con consumo 0,82 kWh/ora (uso tipico 1-2 ore)

#### **Classe Concreta: `Climatizzatore`**
- **Attributi specifici**: `potenzaBTU` (potenza di raffreddamento/riscaldamento)
- **Implementazione**: Calcola consumi annuali variabili
- **Caso d'uso**: Classe A++ con consumi differenziati
  - Raffreddamento: 1,96 kWh/h
  - Riscaldamento: 2,6 kWh/h

#### **Classe Concreta: `Lavatrice`**
- **Attributi specifici**: `durataCiclo` (durata del ciclo in minuti)
- **Implementazione**: Calcola consumo annuale basato su cicli giornalieri
- **Caso d'uso**: Classe A con cicli di 45-90 minuti

---

## DATA AUDIT

## Sintesi
Un impianto fotovoltaico medio (4,5–6 kWp) produce energia solo durante il giorno e la produzione varia nell'arco della giornata. È preferibile consumare l'energia nell'istante della produzione piuttosto che immagazzinarla, a causa delle perdite di accumulo delle batterie.

## Profilo di produzione giornaliera
- Mattina: produzione moderata.
- Ore 11:00–15:00: picco di produzione (si può arrivare a circa 22 kWh). Momento ideale per usare apparecchi ad alto consumo.
- Pomeriggio: produzione in calo, circa 10–12 kWh.
- Notte: zero produzione.

## Raccomandazioni d'uso
- Favorire l'utilizzo degli elettrodomestici più energivori durante il picco (11–15).
- Evitare di accumulare energia nelle batterie se non necessario per minimizzare le perdite dovute all'efficienza di carica/scarica.
- Riservare l'uso della batteria per consumi serali/notturni o per coprire picchi quando la produzione è insufficiente.

## Consumi degli elettrodomestici (dati forniti)
- Frigorifero (classe B)
  - Consumo annuo: 140 kWh
  - Consumo giornaliero: 0,38 kWh
  - Funzionamento continuo; basso consumo grazie al termostato che interrompe il ciclo di raffreddamento.
- Forno (classe A+)
  - Uso tipico: 1–2 ore per utilizzo
  - Consumo: 0,82 kWh per ora
- Climatizzatore (classe A++)
  - Funzioni: raffreddamento e riscaldamento
  - Consumo: 1,96 kWh/ora (raffreddamento), 2,6 kWh/ora (riscaldamento)
- Lavatrice (classe A)
  - Durata ciclo: 45–90 minuti
  - Consumo riportato: 42 kWh per ora (dati forniti)
- Televisione (classe bassa, es. F)
  - Display 32"
  - Consumo: 0,037KWh

## Esempio pratico di gestione
- Durante il picco (11–15): accendere lavatrice, forno, climatizzatore se necessario.
- Pomeriggio: utilizzare apparecchi leggeri; valutare ricarica batterie solo se previsto uso serale.
- Notte: usare energia accumulata solo per consumi essenziali.


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
