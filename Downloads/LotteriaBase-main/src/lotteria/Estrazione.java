/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

/**
 *
 * @author AllababidiJakub
 */
public class Estrazione extends Thread {
    // attributi
    private int[][] matrice;
    private int[] vincitori;
    private int premiAssegnati;
    private static final int MAX_PREMI = 3;
    
    /**
     * 
     * Metodo costruttore
     */   
    public Estrazione(int n) {
        // popolamento matrice numeri estratti
        matrice = new int[n][n];
        vincitori = new int[MAX_PREMI];
        // inizializzazione array vincitori
        for (int i = 0; i < MAX_PREMI; i++) {
            vincitori[i] = 0;
    }
    premiAssegnati = 0;
    popolaMatrice(n); //metodo per popolare la matrice
    }   
    private void popolaMatrice(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrice[i][j] = random.nextInt(100) + 1; // Numeri casuali tra 1 e 100
            }
        }
    }

    /**
    * 
    * Metodo per visualizzare la matrice dei numeri estratti
    */
    public void stampaMatrice() {
       // stampa matrice dei numeri estratti
       for (int i = 0; i < matrice.length; i++) {
        for (int j = 0; j < matrice[i].length; j++) {
            System.out.print(matrice[i][j] + "\t");
        }
        System.out.println();
    }
    }
    
    /**
    * 
    * Metodo per visualizzare i vincitori dell'estrazione
    */
    public void stampaVincitori() {
        // stampa array dei vincitori
            System.out.println("Vincitori:");
            for (int i = 0; i < MAX_PREMI; i++) {
                if (vincitori[i] != -1) {
                    System.out.println("Giocatore " + vincitori[i] + " ha vinto il premio " + (i + 1));
                }
            }
        }

    /**
    * 
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    */
    public void verifica(int numero, int idGiocatore) {
            if (premiAssegnati >= MAX_PREMI) {
                System.out.println("Giocatore " + idGiocatore + ": Non ci sono più premi disponibili.");
                return;
            }
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[i].length; j++) {
                    if (matrice[i][j] == numero) {
                        vincitori[premiAssegnati] = idGiocatore;
                        premiAssegnati++;
                        System.out.println("Giocatore " + idGiocatore + " ha indovinato il numero " + numero + " e ha vinto il premio!");
                        return;
                    }
                }
            }
            System.out.println("Giocatore " + idGiocatore + ": Numero non trovato.");
           
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        // stampa iniziale
        // estrazione dei numeri
        // stampa matrice
        // stampa finale
    }
}


