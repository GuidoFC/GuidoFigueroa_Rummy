package RummyKub.Modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntuacion; // max punt 101
    private ArrayList<Carta> mazoCartas;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntuacion = 0;
        mazoCartas = new ArrayList<>();

    }

    public void addCardMazo(Carta carta){
        mazoCartas.add(carta);
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getPuntuacion(){
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public ArrayList<Carta> getMazoCartas(){
        return mazoCartas;
    }
}
