package Modelo;

import java.util.ArrayList;

public class BarajaCarta {
    private ArrayList<Carta> cartaArrayList1;
    private ArrayList<Carta> cartaArrayList2;

    public BarajaCarta(){
        cartaArrayList1 = new ArrayList<>();
        cartaArrayList2 = new ArrayList<>();
    }

    public void addCard(Carta carta){
        cartaArrayList1.add(carta);
        cartaArrayList2.add(carta);
    }

    public ArrayList<Carta> getCartaArrayList1() {
        return cartaArrayList1;
    }

    public ArrayList<Carta> getCartaArrayList2() {
        return cartaArrayList2;
    }


}
