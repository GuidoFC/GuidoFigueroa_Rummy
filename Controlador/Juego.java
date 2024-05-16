package Controlador;

import Modelo.*;
import Vista.Print;

import java.util.ArrayList;

public class Juego {

    Print presentacion = new Print();

    ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public Juego(Jugador player1, Jugador player2){

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

        // añadimos los jugadores en el arraylist
        this.listaJugadores.add(player1);
        this.listaJugadores.add(player2);

        // ahora quiero hacer un método para repartir las cartas para cada jugador
        repartirCartas(mazoCartas1);


    }



    public void repartirCartas(MazoCartas mazoCartasRef ) {
        // Cuantos jugadores tenemos
        int totalJugadores = numJugadores();
        // Cartas a repartir 14 * jugador
        final int CARTAS_REPARTIR = 14;
        int cartaTotalRepartir = totalJugadores * CARTAS_REPARTIR;

        for (int i = 0; i < cartaTotalRepartir; i++) {
            Carta cartaRef = mazoCartasRef.getCogerUltimaCarta();
            // definimos el turno
            int turno = 1;
            int elegirJugador = turno % totalJugadores;
             Jugador jugadorRef = listaJugadores.get(elegirJugador);
             jugadorRef.addCardMazo(cartaRef);
             turno ++;

        }

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


    public int numJugadores(){
        // Cuantos jugadores tenemos
        return listaJugadores.size();
    }

}
