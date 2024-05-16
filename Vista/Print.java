package Vista;

import Modelo.Carta;
import Modelo.Jugador;
import Modelo.MazoCartas;

import java.util.ArrayList;

public class Print {

    public Print(){

    }
    public void choseeGame(){
         String elegirOpcion = """
                Elija uno de los siguientes Juegos:
                    1) Rummy Juego Original
                    2) Rummikub
                    3) Gin Rummy
                    4) Rummy Argentino
                
                """;
    }

    public void verTodasLasCartas(MazoCartas barajaCartaRef){
        for (int i = 0; i < barajaCartaRef.getListBarajaCartas().size() ; i++) {
            System.out.println(barajaCartaRef.getListBarajaCartas().get(i).toString());
        }
    }

    public void verCartaJugador(Jugador jugadorRef){
        NombreJugador(jugadorRef);
        ArrayList<Carta> mazoCartasJugador = jugadorRef.getMazoCartas();
        int totalCartas = mazoCartasJugador.size();

        for (int i = 0; i < totalCartas; i++) {
            System.out.println( mazoCartasJugador.get(i).toString() );
        }
    }

    public void NombreJugador(Jugador jugadorRef){
        System.out.println();
        System.out.println("El jugador: " + jugadorRef.getNombre() + "\n Tiene las siguientes cartas:");
        System.out.println();
    }
}
