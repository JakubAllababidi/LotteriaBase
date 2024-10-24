/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

/**
 *
 * @author Allababidijakub
 */
public class Giocatore extends Thread{
    // attributi
    private int idGiocatore;
    private Estrazione estrazione;

    public Giocatore(int idGiocatore, Estrazione estrazione) {
        this.idGiocatore = idGiocatore;
        this.estrazione = estrazione;
    }
    /**
    * Metodo per eseguire il thread
    */
    public void run() {
         Random random = new Random();
         int numeroScelto = random.nextInt(100) + 1; // Numero scelto tra 1 e 100
         System.out.println("Giocatore " + idGiocatore + " ha scelto il numero " + numeroScelto);
         estrazione.verifica(numeroScelto, idGiocatore);
     }
 }