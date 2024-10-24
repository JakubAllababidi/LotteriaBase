/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Scanner;

/**
 *
 * @author allababidiJakub
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scelta del numero dei numeri da estrarre
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la dimensione della matrice NxN (esempio: 5 per una matrice 5x5): ");
        int dimensioneMatrice = scanner.nextInt();
        // Istanza ed avvio del thread Estrazione
        Estrazione estrazione = new Estrazione(dimensioneMatrice);
        estrazione.start();
        // Istanza di alcuni thread Giocatore
        System.out.print("Inserisci il numero di giocatori: ");
        int numeroGiocatori = scanner.nextInt();
        Giocatore[] giocatori = new Giocatore[numeroGiocatori];
        for (int i = 0; i < numeroGiocatori; i++) {
            giocatori[i] = new Giocatore(i + 1, estrazione); // Crea un nuovo giocatore con ID 
        }

        // Avvio dei thread Giocatori
        for (Giocatore giocatore : giocatori) {
            giocatore.start();
        }

        // Comunicazione fine gioco
        estrazione.stampaVincitori(); // Stampa i vincitori
        System.out.println("Fine del gioco.");
        scanner.close();
    }
}
   