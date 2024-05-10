package Controlador;

import Modelo.BarajaCarta;
import Modelo.CardNumber;
import Modelo.CardSymbol;
import Modelo.Carta;

public class Juego {
    BarajaCarta barajaCarta = new BarajaCarta();
    public Juego(){

        // primero vamos a crear las cartas
        CreateAllCard();


    }

    private void CreateAllCard(){

        int MaxComodin = 2;
        // FOR para recorrer un ENUM
            // Crear las cartas sin Comodin
        for (CardSymbol symbol : CardSymbol.values()) {
            for (CardNumber number : CardNumber.values()) {
                if ((symbol == CardSymbol.COMODIN) || (number == CardNumber.COMODIN)){
                    continue;
                }
                Carta carta1al10 = new Carta(symbol, number);
                this.barajaCarta.addCard(carta1al10);
            }
        }

        for (int i = 0; i < MaxComodin; i++) {
            Carta cartaComodin = new Carta(CardSymbol.COMODIN, CardNumber.COMODIN);
            this.barajaCarta.addCard(cartaComodin);
        }


    }

    public void verTodasLasCartas(){
        for (int i=0;i<barajaCarta .size();i++) {

            System.out.println(lista.get(i));
        }
    }

}
