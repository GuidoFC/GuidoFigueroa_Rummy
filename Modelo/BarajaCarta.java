package Modelo;

import java.util.ArrayList;

public class BarajaCarta {
    // Si necesitamos 2 barajas de cartas, vale la pena hacer 2 arrayList
    // o con uno es suficiente? He decidido hacerlo con uno


    // Hacemos una prueba de que existe esta rama con un commit and push
    private ArrayList<Carta> listBarajaCartas ;


    public BarajaCarta(){
        listBarajaCartas = new ArrayList<>();

    }

    public void addCard(Carta carta){
        listBarajaCartas.add(carta);

    }

    public ArrayList<Carta> getListBarajaCartas() {
        return listBarajaCartas;
    }




}
