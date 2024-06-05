package RummyKub.Modelo;

import java.util.ArrayList;

public class GuardarRestablecerJson {
    // Quiero guardar todas las cartas del jugador
    ArrayList<Carta> mazoCartaJugador;
    // Quiero guardar todas las jugadas presentadas
    ArrayList<Jugadas> jugadasArrayList;

    public GuardarRestablecerJson(){
    }

    public void setTodasCartasJugador(ArrayList<Carta> mazoCartaJugadorRef){
        this.mazoCartaJugador = mazoCartaJugadorRef;
    }

    public ArrayList<Carta> getTodasCartasJugador() {
        return mazoCartaJugador;
    }

    public void setJugadasArrayList(ArrayList<Jugadas> jugadasArrayList) {
        this.jugadasArrayList = jugadasArrayList;
    }

    public ArrayList<Jugadas> getJugadasArrayList() {
        return jugadasArrayList;
    }


    // toString sirve para visuarlizar el contenido que
    // tengo guardado dentro de los atributos


}
