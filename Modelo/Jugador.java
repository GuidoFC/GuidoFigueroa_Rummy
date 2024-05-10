package Modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private ArrayList<Carta> mazoCartas;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntuacion = 0;

    }

    public String getNombre(){
        return this.nombre;
    }

    public int getPuntuacion(){
        return this.puntuacion;
    }
}
