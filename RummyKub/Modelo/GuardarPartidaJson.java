package RummyKub.Modelo;

import java.util.ArrayList;

public class GuardarPartidaJson {
    // Quiero guardar todas las cartas del jugador
    ArrayList<Carta> mazoCartasJugador1;
    int turno;


//    private ArrayList<Carta> mazoCartasJugador;
//
//    private ArrayList<Jugadas> jugadasArrayList;

    // voy a hacer una rama para decidir que cosas voy a guardar en esta clase
    // creo que hare constructores. Uno para guardar toda la partida
    // y el otro constructor para guardar los elementos necesarios
    // o puedo guardarlo todo y luego decidir que cosas necesito
    // Empezamos
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

