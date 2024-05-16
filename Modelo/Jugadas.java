package Modelo;

import java.util.ArrayList;

public class Jugadas {
    ArrayList<Carta> jugada;
    public Jugadas(){
        this.jugada = new ArrayList<>();
    }

    private void addCarta(Carta cartaRef){
        this.jugada.add(cartaRef);
    }

}
