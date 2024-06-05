import RummyArgentino.Prueba;
import RummyKub.Controlador.Juego;
import RummyKub.Modelo.Jugador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        mostrarJuegos();
        int opcionElegida = getOpcionElegidaPorJugador();
        if (opcionElegida == 1){
            Jugador player1 =new Jugador("Guido");
            Jugador player2 =new Jugador("Maria");
            Juego juego = new Juego(player1, player2);
        } else if (opcionElegida == 2) {
            Prueba.pintarArgentino();
        }

    }
    public static void mostrarJuegos(){
        System.out.println("""
                Bienvenido, a que juego quiere jugar:
                    1) RummyKub
                    2) RummyArgentino
                """);
    }

    public static int getOpcionElegidaPorJugador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el juego que quieres jugar");

        int opcion = sc.nextInt();
        return opcion;
    }
}
