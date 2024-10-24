# Progetto Lotteria

## Scopo del Progetto

Il progetto **Lotteria** è una simulazione di un gioco a premi in cui più giocatori scelgono numeri casuali nel tentativo di indovinare i numeri presenti in una matrice NxN generata con numeri random. I primi tre giocatori che indovinano un numero corretto vincono un premio. 
## Principali Classi Usate

### 1. `Lotteria`
Questa classe contiene il metodo `main`.Le sue funzioni principali sono:
- Chiedere all'utente la dimensione della matrice e il numero di giocatori.
- Creare e avviare un thread della classe `Estrazione`, che genera una matrice di numeri casuali.
- Creare e avviare i thread della classe `Giocatore`, che rappresentano i vari giocatori.
- Visualizzare i vincitori alla fine del gioco.

### 2. `Giocatore`
Questa classe estende `Thread` e rappresenta ciascun giocatore. Le sue funzioni principali sono:
- Ogni giocatore sceglie un numero casuale compreso tra 1 e 100.
- Invia il numero scelto alla classe `Estrazione` per verificare se è presente nella matrice dei numeri estratti.
- Se un giocatore indovina il numero, vince uno dei tre premi.

### 3. `Estrazione`
La classe `Estrazione` estende `Thread`.Le sue funzioni principali sono:
- Generare una matrice NxN riempita con numeri casuali da 1 a 100.
- Tenere traccia dei vincitori e del numero di premi assegnati.
- Verificare se il numero scelto da ciascun giocatore è presente nella matrice e, se lo è, assegnare un premio.

#### Metodo `verifica(int numero, int idGiocatore)`
Il metodo `verifica()` determina se un giocatore ha vinto. Ecco una descrizione dettagliata del suo funzionamento:
- **Funzionamento**:
  1. Controlla se i premi disponibili sono finiti.
  2. Scorre ogni elemento della matrice NxN. Se trova una corrispondenza tra il numero scelto e un numero nella matrice, assegna il premio al giocatore e incrementa il contatore dei premi assegnati.
  3. Se il numero non viene trovato nella matrice, il giocatore viene informato che il numero scelto non è presente.
- **Output**: stampa un messaggio che indica se il giocatore ha vinto o meno, e aggiorna lo stato dei vincitori.

### 4. `popolaMatrice()`
Un metodo privato della classe `Estrazione` che riempie la matrice con numeri casuali da 1 a 100. Viene chiamato dal costruttore di `Estrazione`.

## Librerie Utilizzate

- **java.util.Scanner**: Per gestire l'input dell'utente da tastiera.
- **java.util.Random**: Per generare numeri casuali sia per la matrice che per i numeri scelti dai giocatori.
- **java.lang.Thread**: Per la gestione dei thread, sia per i giocatori che per il processo di estrazione.

## Scenari Alternativi di Funzionamento

- **Numero di giocatori troppo basso**: Se il numero di giocatori è inferiore a tre, non tutti i premi saranno assegnati.
- **Nessun vincitore**: Se nessuno dei giocatori indovina un numero presente nella matrice, nessun premio sarà assegnato.
- **Numeri scelti duplicati**: Se due giocatori scelgono lo stesso numero, il primo che viene eseguito dal thread sarà premiato se il numero è corretto, mentre l'altro perderà.
- **Esaurimento dei premi**: Una volta che i tre premi sono stati assegnati, i giocatori successivi verranno informati che non ci sono più premi disponibili.

## Commento sull'Esecuzione

1. **Input dell'utente**: All'inizio del programma, l'utente inserisce la dimensione della matrice NxN e il numero di giocatori.
2. **Creazione dei thread**: Vengono avviati i thread per l'estrazione dei numeri e i giocatori, che operano in parallelo.
3. **Estrazione e scelta dei numeri**: Il thread `Estrazione` genera la matrice e stampa i numeri estratti. Ogni giocatore sceglie un numero e invia una richiesta di verifica.
4. **Assegnazione dei premi**: Quando un giocatore indovina un numero presente nella matrice, viene assegnato un premio. Il gioco prosegue fino all'assegnazione di tutti i premi.
5. **Fine del gioco**: Quando i premi sono esauriti o tutti i giocatori hanno scelto i loro numeri, vengono stampati i vincitori e il gioco si conclude.

## Esempio di Output

