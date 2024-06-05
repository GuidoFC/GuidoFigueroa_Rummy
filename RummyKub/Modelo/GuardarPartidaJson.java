package RummyKub.Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class GuardarPartidaJson {
    // Quiero guardar todas las cartas del juedor
    ArrayList<Carta> mazoCartasJugador1;

  //  private ArrayList<Jugador> listaJugadores ;

//    private ArrayList<Carta> mazoCartasJugador;
//
//    private ArrayList<Jugadas> jugadasArrayList;


    public GuardarPartidaJson(){

    }

    public void obtenTodasCartasJugador(ArrayList<Jugador> listaJugadores){
        this.mazoCartasJugador1 = listaJugadores.get(0).getMazoCartas();
    }





    //    public void setJugadasArrayList(ArrayList<Jugadas> jugadasArrayList) {
//        this.jugadasArrayList = jugadasArrayList;
//    }
//
//    public ArrayList<Jugadas> getJugadasArrayList() {
//        return jugadasArrayList;
//    }
//
//    public ArrayList<Carta> getMazoCartasJugador() {
//        return mazoCartasJugador;
//    }
//
//    public void setMazoCartasJugador(ArrayList<Carta> mazoCartasJugador) {
//        this.mazoCartasJugador = mazoCartasJugador;
//    }

//    @Override
//    public String toString() {
//        return "GuardarPartidaJson{" +
//                "listaJugadores=" + listaJugadores +
////                ", mazoCartasJugador=" + mazoCartasJugador +
////                ", jugadasArrayList=" + jugadasArrayList +
//                '}';
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        GuardarPartidaJson that = (GuardarPartidaJson) o;
//        return Objects.equals(listaJugadores, that.listaJugadores) && Objects.equals(mazoCartasJugador, that.mazoCartasJugador) && Objects.equals(jugadasArrayList, that.jugadasArrayList);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(listaJugadores, mazoCartasJugador, jugadasArrayList);
//    }

//    public ArrayList<Jugador> getListaJugadores() {
//        return listaJugadores;
//    }
//
//    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
//        this.listaJugadores = listaJugadores;
//    }
}

