package RummyKub.Modelo;

import java.util.ArrayList;

public class JugadaTupla extends Jugadas{
    // poner logica de antes de crear este objeto para validar
    // si es una tupla

    private static int contador = 1;
    private int idJugada;
    private int numeroTupla;

    private int tamanoArrayList;
    ArrayList<Carta> cartasTuplasArrayList;

    public JugadaTupla(int numeroTuplaRef){
        this.numeroTupla = numeroTuplaRef;
        this.idJugada = contador;
        cartasTuplasArrayList = new ArrayList<>();
        incrementarContador();

    }

    @Override
    public int putSizeArray(){
        int tamano = cartasTuplasArrayList.size();
        return tamano;
    }

    @Override
    public void addCard(Carta carta){
        this.cartasTuplasArrayList.add(carta);

    }

    @Override
    public Carta getCard(int i){
        Carta cartaRef;
        return cartaRef = this.cartasTuplasArrayList.get(i);
    }


    private void incrementarContador(){
        contador++;
    }



}
