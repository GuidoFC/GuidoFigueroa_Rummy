package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private ArrayList<Carta> pilaStcok;
    private ArrayList<Carta> pilaDescarte;
    private ArrayList<Carta> combinacionCartas = new ArrayList<>();
    private ArrayList<Jugador> jugadorArrayList = new ArrayList<>();

    public Tablero(BarajaCarta barajaCartaRef){

        this.pilaStcok = barajaCartaRef.getListBarajaCartas();
        this.pilaDescarte = new ArrayList<>();

        barajarCartas();
        // barajar las cartas
    }

    public ArrayList<Carta> getPilaStcok() {
        return pilaStcok;
    }

    private void barajarCartas(){

        while (this.pilaStcok.size() > 0){
            int randomNumber = generateIndice(this.pilaStcok.size());

            if (isIndiceValido(randomNumber)){
                if (this.pilaStcok.size() > 0){
                    Carta carta = pilaStcok.get(randomNumber);
                    this.pilaDescarte.add(carta);
                    this.pilaStcok.remove(randomNumber);
                }else {
                    this.pilaStcok = this.pilaDescarte;
                    break;
                }

            }
        }

    }

    private boolean isIndiceValido(int randomNumber) {
        return (randomNumber >= 0) && (randomNumber <= this.pilaStcok.size());
    }

    public int generateIndice(int tamanoArray){
        Random random = new Random();
        return random.nextInt(tamanoArray);
    }
}
