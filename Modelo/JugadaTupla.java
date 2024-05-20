package Modelo;

import java.util.ArrayList;

public class JugadaTupla extends Jugadas{
    // poner logica de antes de crear este objeto para validar
    // si es una tupla
    private int id = 1;
    ArrayList<Carta> cartasTuplasArrayList;

    public JugadaTupla(Carta carta){
        cartasTuplasArrayList = new ArrayList<>();
        cartasTuplasArrayList.add(carta);
        id = incrementarID();
    }

    private int incrementarID(){
       return this.id ++;
    }

    private void comprobarTupla(){
        int numVarlorReferencia = 0;
        int numVarlorCarta;
        for (int i = 0; i < cartasTuplasArrayList.size(); i++) {
            if (i== 0){
                numVarlorReferencia = cartasTuplasArrayList.get(i).getCardNumber().getValor();
                continue;
            }
            numVarlorCarta = cartasTuplasArrayList.get(i).getCardNumber().getValor();
            if ( numVarlorReferencia != numVarlorCarta ){
                // como se puede borrar un objeto creado?
                    // a lo mejor es mas interesante primero comprobar y luego crear el objeto
                    // entonces solo me centraria si el nuevo elemento que se quiere
                    // introducir pertenece a la misma tupla
            }
        }
    }
}
