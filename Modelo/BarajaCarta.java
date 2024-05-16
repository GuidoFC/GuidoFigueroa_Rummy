package Modelo;

import java.util.ArrayList;

public class BarajaCarta {
    // Si necesitamos 2 barajas de cartas, vale la pena hacer 2 arrayList
    // o con uno es suficiente? He decidido hacerlo con uno porque no tiene
    // sentido crear 2 ya que no lo tenemos que diferenciar
    private ArrayList<Carta> listBarajaCartas ;


    public BarajaCarta(){
        listBarajaCartas = new ArrayList<>();

    }

    public void addCarta(Carta carta){
        listBarajaCartas.add(carta);
    }
    public ArrayList<Carta> getListBarajaCartas() {
        return listBarajaCartas;
    }




}
