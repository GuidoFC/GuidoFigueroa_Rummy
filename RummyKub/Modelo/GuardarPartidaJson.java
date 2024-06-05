package RummyKub.Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class GuardarPartidaJson {
    // Quiero guardar todas las cartas del jugador
    ArrayList<Carta> mazoCartasJugador1;


//    private ArrayList<Carta> mazoCartasJugador;
//
//    private ArrayList<Jugadas> jugadasArrayList;

    public GuardarPartidaJson(){
    }

    public void obtenTodasCartasJugador(ArrayList<Jugador> listaJugadores){
        this.mazoCartasJugador1 = listaJugadores.get(0).getMazoCartas();
    }

}

