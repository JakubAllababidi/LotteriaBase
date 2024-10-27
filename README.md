# Progetto Lotteria

**Jakub Allababidi** 


---

## Scopo del Progetto

Simulare un gioco a premi in cui più giocatori cercano di indovinare numeri presenti in una matrice NxN generata casualmente. I primi tre giocatori che indovinano un numero vincono un premio.

---

## Classi e Struttura del Codice

### Classe `Lotteria`
- **Descrizione**: Contiene il metodo `main`, avvia il gioco e gestisce la configurazione iniziale.
- **Funzioni principali**:
  - Richiede all'utente la dimensione della matrice e il numero di giocatori.
  - Avvia un thread `Estrazione` per creare la matrice con numeri casuali.
  - Crea e avvia i thread `Giocatore` per rappresentare i partecipanti.
  - Mostra i vincitori alla fine del gioco.

### Classe `Giocatore`
- **Descrizione**: Rappresenta un partecipante al gioco.
- **Funzioni principali**:
  - Ogni giocatore sceglie un numero casuale (1-100).
  - Invia il numero scelto a `Estrazione` per verificare se è presente nella matrice.
  - Se il numero è presente, il giocatore vince uno dei premi.

### Classe `Estrazione`
- **Descrizione**: Crea la matrice dei numeri estratti e gestisce la verifica dei numeri scelti dai giocatori.
- **Funzioni principali**:
  - Genera una matrice NxN con numeri casuali tra 1 e 100.
  - Tiene traccia dei vincitori e dei premi assegnati.
  - Verifica se i numeri scelti dai giocatori sono presenti nella matrice e assegna i premi.

#### Metodo `verifica(int numero, int idGiocatore)`
- **Descrizione**: Controlla se il numero scelto da un giocatore è presente nella matrice.
- **Funzionamento**:
  1. Verifica se ci sono ancora premi disponibili.
  2. Cerca il numero nella matrice e, se lo trova, assegna il premio al giocatore e incrementa il contatore dei premi.
  3. Se il numero non è presente, il giocatore viene informato della mancata corrispondenza.
- **Output**: Stampa un messaggio che indica se il giocatore ha vinto o meno, e aggiorna la lista dei vincitori.

#### Metodo `popolaMatrice()`
- **Descrizione**: Metodo privato di `Estrazione` che riempie la matrice NxN con numeri casuali (1-100).

---

## Librerie Utilizzate

- `java.util.Scanner`: Per l'input da tastiera.
- `java.util.Random`: Per generare i numeri casuali.
- `java.lang.Thread`: Per gestire i thread `Giocatore` ed `Estrazione`.


