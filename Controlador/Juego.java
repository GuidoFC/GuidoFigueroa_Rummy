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
        // FOR para recorrer un ENUM
        for (CardSymbol Symbol : CardSymbol.values()) {
            for (CardNumber number : CardNumber.values()) {
                Carta carta1 = new Carta(Symbol, number);
                this.barajaCarta.addCard(carta1);
            }
        }
    }

    public void verTodasLasCartas(){
        for (int i=0;i<barajaCarta .size();i++) {

            System.out.println(lista.get(i));
        }
    }

}
