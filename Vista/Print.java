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
            // Si es múltiplo de 7, imprimir salto de línea
            if (i % 7 == 0){
                System.out.println(" ");
            }
            ;
            System.out.print( printColor(barajaCartaRef, i) + barajaCartaRef.getListBarajaCartas().get(i).toString() + " " + ConsoleColors.RESET);
        }
    }

    private static String printColor(MazoCartas barajaCartaRef, int i) {
        return ConsoleColors.chooseColorCard(barajaCartaRef.getListBarajaCartas().get(i).getCardSymbol());
    }

    public void verCartaJugador(Jugador jugadorRef){
        NombreJugador(jugadorRef);
        ArrayList<Carta> mazoCartasJugador = jugadorRef.getMazoCartas();
        int totalCartas = mazoCartasJugador.size();

        for (int i = 0; i < totalCartas; i++) {
            // multiple de 5. Vere las cartas de 5 en 5
            if (i % 5== 0){
                System.out.println();
            }
            System.out.print( ConsoleColors.chooseColorCard(mazoCartasJugador.get(i).getCardSymbol()) + mazoCartasJugador.get(i).toString() + " " + ConsoleColors.RESET );
            if ( i == totalCartas-1){
                System.out.println();
            }
        }
    }

    public void NombreJugador(Jugador jugadorRef){
        System.out.println();
        System.out.println("El jugador: " + jugadorRef.getNombre() + "\n Tiene las siguientes cartas:");
        System.out.println();
    }
}
