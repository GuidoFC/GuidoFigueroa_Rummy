package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private ArrayList<Carta> pilaStcok;
    private ArrayList<Carta> pilaDescarte;
    private ArrayList<Carta> combinacionCartas = new ArrayList<>();
    private ArrayList<Jugador> jugadorArrayList = new ArrayList<>();

    public Tablero(Carta carta){
        pilaStcok = new ArrayList<>();
        pilaStcok.add(carta);

        this.pilaDescarte = new ArrayList<>();

        barajarCartas();
        // barajar las cartas
    }

    private void barajarCartas(){

        int randomNumber = generateIndice(this.pilaStcok.size());

        if ( (randomNumber >= 0) && ( randomNumber <= this.pilaStcok.size()) ){
            if (this.pilaStcok.size() > 0){
                Carta carta = pilaStcok.get(randomNumber);
                this.pilaStcok.get(randomNumber);
                this.pilaDescarte.add(carta);
            }else {
                this.pilaStcok = this.pilaDescarte;
            }

        }
    }

    public int generateIndice(int tamanoArray){
        Random random = new Random();
        return random.nextInt(tamanoArray);
    }
}
