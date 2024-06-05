package RummyKub.Modelo;

import java.util.ArrayList;

public class GuardarPartidaJson {
    // Quiero guardar todas las cartas del jugador
    ArrayList<Carta> mazoCartasJugador1;


//    private ArrayList<Carta> mazoCartasJugador;
//
//    private ArrayList<Jugadas> jugadasArrayList;

    public GuardarPartidaJson(){
    }

    public void setTodasCartasJugador(ArrayList<Jugador> listaJugadores){
        this.mazoCartasJugador1 = listaJugadores.get(0).getMazoCartas();
    }

    public ArrayList<Carta> getTodasCartasJugador() {
        return mazoCartasJugador1;
    }

    // toString sirve para visuarlizar el contenido que
    // tengo guardado dentro de los atributos

    @Override
    public String toString() {
        return "GuardarPartidaJson{" +
                "mazoCartasJugador1=" + mazoCartasJugador1 +
                '}';
    }
}

