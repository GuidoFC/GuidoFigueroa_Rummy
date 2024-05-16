package Controlador;

import Modelo.*;
import Vista.Print;

import java.util.ArrayList;

public class Juego {

    Print presentacion = new Print();

    public Juego(){

        // primero creamos un objeto de la clase BarajaCarta que es donde guardaremos las cartas
        MazoCartas mazoCartas1 = new MazoCartas();
        // segundo vamos a crear las cartas y las guardamos en el objeto que hemos creado
        createAllCard(mazoCartas1);

        // Vemos las cartas
        this.presentacion.verTodasLasCartas(mazoCartas1);

        // barajamos las cartas

        mazoCartas1.barajarCartas();
        // vemos las cartas barajadas

        this.presentacion.verTodasLasCartas(mazoCartas1);

        // ahora quiero hacer un método para repartir las cartas para cada jugador

    }

    private void createAllCard(MazoCartas mazoCartasRef){
        final int MAX_COMODIN = 2;
        final int CREAR_2_MAZOS = 2;
        // Crear las cartas sin Comodin
        crearCards1to13(mazoCartasRef, CREAR_2_MAZOS);

        createAllComodinCard(mazoCartasRef, MAX_COMODIN);

    }

    private void crearCards1to13(MazoCartas mazoCartasRef, int CREAR_2_MAZOS) {
        for (int i = 0; i < CREAR_2_MAZOS; i++) {
            // FOR para recorrer un ENUM
            for (CardSymbol symbol : CardSymbol.values()) {
                for (CardNumber number : CardNumber.values()) {
                    if (isComodinCard(symbol, number)) {
                        continue;
                    }
                    Carta carta1al13 = new Carta(symbol, number);
                    mazoCartasRef.addCarta(carta1al13);
                }
            }
        }
    }

    private void createAllComodinCard(MazoCartas mazoCartasRef, int MAX_COMODIN) {
        for (int j = 0; j < MAX_COMODIN; j++) {
            Carta cartaComodin = new Carta(CardSymbol.COMODIN, CardNumber.COMODIN);
            mazoCartasRef.addCarta(cartaComodin);
        }

    }

    private static boolean isComodinCard(CardSymbol symbol, CardNumber number) {
        return (symbol == CardSymbol.COMODIN) || (number == CardNumber.COMODIN);
    }




}
