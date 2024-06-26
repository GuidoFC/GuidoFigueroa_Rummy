package RummyKub.Modelo;

import java.util.ArrayList;
import java.util.Random;

public class MazoCartas implements Cloneable {
    // Si necesitamos 2 barajas de cartas, vale la pena hacer 2 arrayList
    // o con uno es suficiente? He decidido hacerlo con uno porque no tiene
    // sentido crear 2 ya que no lo tenemos que diferenciar
    private ArrayList<Carta> pilaStock ;
    private ArrayList<Jugadas> jugadasArrayList;


    public MazoCartas(){
        pilaStock = new ArrayList<>();
        jugadasArrayList = new ArrayList<>();
    }

    // Creamos un constructor para hacer la clonacion
    public MazoCartas(MazoCartas other) {
        pilaStock = other.pilaStock;
        jugadasArrayList = other.jugadasArrayList;
    }

    public void addCarta(Carta carta){
        pilaStock.add(carta);
    }
    public ArrayList<Carta> getListBarajaCartas() {
        return pilaStock;
    }

    public ArrayList<Carta> getPilaStock() {
        return pilaStock;
    }

    public void setPilaStock(ArrayList<Carta> pilaStock) {
        this.pilaStock = pilaStock;
    }

    private boolean isIndiceValido(int randomNumber) {
        return (randomNumber >= 0) && (randomNumber <= this.pilaStock.size());
    }

    public int generateIndice(int tamanoArray){
        Random random = new Random();
        return random.nextInt(tamanoArray);
    }

    public void barajarCartas(){
        ArrayList<Carta> arrayAuxiliar = new ArrayList<>();

        while (this.pilaStock.size() > 0){
            int randomNumber = generateIndice(this.pilaStock.size());

            if (isIndiceValido(randomNumber)){
                if (this.pilaStock.size() > 0){
                    Carta carta = this.pilaStock.get(randomNumber);
                    arrayAuxiliar.add(carta);
                    this.pilaStock.remove(randomNumber);
                }else {
                    break;
                }

            }
        }
        this.pilaStock = arrayAuxiliar;


    }

    public Carta getCogerUltimaCarta(){
        int numCartas = pilaStock.size() -1;

        Carta cartaref = pilaStock.get(numCartas);
        pilaStock.remove(numCartas);
        return cartaref;
    }

    @Override
    public String toString() {
        return "MazoCartas{" +
                "pilaStock=" + pilaStock +
                ", jugadasArrayList=" + jugadasArrayList +
                '}';
    }
}
