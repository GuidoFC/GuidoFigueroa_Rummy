package Controlador;

import Modelo.*;

public class Juego {
    BarajaCarta barajaCarta = new BarajaCarta();
    public Juego(){

        // primero vamos a crear las cartas
        CreateAllCard();
        Tablero tablero = new Tablero(barajaCarta);


    }

    private void CreateAllCard(){

        final int MAX_COMODIN = 2;

        final int CREAR_2_MAZOS = 2;

        // FOR para recorrer un ENUM
            // Crear las cartas sin Comodin
        for (int i = 0; i < CREAR_2_MAZOS; i++) {

            for (CardSymbol symbol : CardSymbol.values()) {
                for (CardNumber number : CardNumber.values()) {
                    if ((symbol == CardSymbol.COMODIN) || (number == CardNumber.COMODIN)) {
                        continue;
                    }
                    Carta carta1al10 = new Carta(symbol, number);
                    this.barajaCarta.addCard(carta1al10);
                }
            }
        }

        for (int i = 0; i < CREAR_2_MAZOS; i++) {
            for (int j = 0; j < MAX_COMODIN; j++) {
                Carta cartaComodin = new Carta(CardSymbol.COMODIN, CardNumber.COMODIN);
                this.barajaCarta.addCard(cartaComodin);
            }
        }

    }

    public void verTodasLasCartas(){
        for (int i = 0; i < barajaCarta.getListBarajaCartas().size() ; i++) {
            System.out.println(barajaCarta.getListBarajaCartas().get(i).toString());
        }
    }

}
