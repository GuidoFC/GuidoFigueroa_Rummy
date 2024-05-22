package Modelo;

import java.util.ArrayList;

public abstract class Jugadas {

    // Esta clase me interesa hacerla con el Patron Singleton para guardar todas las
    // jugadas, tanto de tupla como de escalera
        // pero si hago la clase Abstracta no podre crear ningun objeto

    public Jugadas(){
    }

    public abstract int putSizeArray();

    // dejar una carta
    public abstract void addCard(Carta carta);

    // obtener un ArrayList
    public abstract Carta getCard(int i);






}
