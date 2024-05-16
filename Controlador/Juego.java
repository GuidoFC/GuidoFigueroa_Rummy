package Controlador;

import Modelo.*;
import Vista.Print;

import java.util.ArrayList;

public class Juego {

    Print presentacion = new Print();

    public Juego(){

        // primero creamos un objeto de la clase BarajaCarta que es donde guardaremos las cartas
        BarajaCarta barajaCarta1 = new BarajaCarta();
        // segundo  vamos a crear las cartas
        CreateAllCard(barajaCarta1);

        this.presentacion.verTodasLasCartas(barajaCarta1);

        Tablero tablero1 = new Tablero(barajaCarta1);

        this.presentacion.verTodasLasCartas(tablero1.getPilaStcok());




    }

    private void CreateAllCard(BarajaCarta barajaCartaRef){
        final int MAX_COMODIN = 4;
        final int CREAR_2_MAZOS = 2;
        // Crear las cartas sin Comodin
        crearCards1to13(barajaCartaRef, CREAR_2_MAZOS);

        createAllComodinCard(barajaCartaRef, MAX_COMODIN);

    }

    private void createAllComodinCard(BarajaCarta barajaCartaRef, int MAX_COMODIN) {
        for (int j = 0; j < MAX_COMODIN; j++) {
            Carta cartaComodin = new Carta(CardSymbol.COMODIN, CardNumber.COMODIN);
            barajaCartaRef.addCarta(cartaComodin);
        }

    }

    private void crearCards1to13(BarajaCarta barajaCartaRef, int CREAR_2_MAZOS) {
        for (int i = 0; i < CREAR_2_MAZOS; i++) {
            // FOR para recorrer un ENUM
            for (CardSymbol symbol : CardSymbol.values()) {
                for (CardNumber number : CardNumber.values()) {
                    if (isComodinCard(symbol, number)) {
                        continue;
                    }
                    Carta carta1al13 = new Carta(symbol, number);
                    barajaCartaRef.addCarta(carta1al13);
                }
            }
        }
    }

    private static boolean isComodinCard(CardSymbol symbol, CardNumber number) {
        return (symbol == CardSymbol.COMODIN) || (number == CardNumber.COMODIN);
    }



}
