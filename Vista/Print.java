package Vista;

import Modelo.Carta;
import Modelo.Jugador;
import Modelo.MazoCartas;

import java.util.ArrayList;
import java.util.Scanner;

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

    public int chooseDecisionPlayer(Jugador jugadorRef){
        Scanner sc = new Scanner(System.in);
        System.out.println("Le toca al jugador: " + jugadorRef.getNombre());
        String mensaje = """
                Elija una de las siguientes opciones:
                    1) Coger Carta del Deck
                    2) Tengo una jugada
                """;
        System.out.println();
        System.out.println(mensaje);

        int eleccion = sc.nextInt();

        switch (eleccion){
            case 1:
                System.out.println("Ha elegido: Coger Carta del Deck");
                return 1;

            case 2:
                System.out.println("Ha elegido: Tengo una jugada");
                return 2;

            default:
                System.out.println("Opcion no valida, vuelva a interlo");
                return 0;

        }

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

        int contadorCartas = 1;

        for (int i = 0; i < totalCartas; i++) {
            // multiple de 5. Vere las cartas de 5 en 5
            if (i % 5== 0){
                System.out.println();
            }
            // mejor de usar el metodo espaiCarta, poner un tabulador
            System.out.print(contadorCartas + "." + ConsoleColors.chooseColorCard(mazoCartasJugador.get(i).getCardSymbol()) + mazoCartasJugador.get(i).toString() + " " + ConsoleColors.RESET + "\t");
            contadorCartas ++;
            if ( i == totalCartas-1){
                System.out.println();
            }
        }
    }
    private String espaiCarta(int contadorCartas){
        String carta;
        if (contadorCartas<10){
             carta = " " + contadorCartas;
            return carta;
        }
        carta = "" + contadorCartas;
        return carta;
    }

    public void NombreJugador(Jugador jugadorRef){
        System.out.println();
        System.out.println("El jugador: " + jugadorRef.getNombre() + "\n Tiene las siguientes cartas:");
        System.out.println();
    }
}
