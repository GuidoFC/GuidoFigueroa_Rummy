package Modelo;

import java.util.ArrayList;

public class JugadaTupla extends Jugadas{
    // poner logica de antes de crear este objeto para validar
    // si es una tupla

    private static int contador = 1;
    private int idJugada;
    private int numeroTupla;
    ArrayList<Carta> cartasTuplasArrayList;

    public JugadaTupla(int numeroTuplaRef){
        this.numeroTupla = numeroTuplaRef;
        this.idJugada = contador;
        cartasTuplasArrayList = new ArrayList<>();
        incrementarContador();

    }

    public void addCardTupla(Carta carta){
        this.cartasTuplasArrayList.add(carta);

    }



    private void incrementarContador(){
        contador++;
    }



}
