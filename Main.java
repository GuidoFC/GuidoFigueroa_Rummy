import Controlador.Juego;
import Modelo.Jugador;

public class Main {
    public static void main(String[] args) {
        Jugador player1 =new Jugador("Guido");
        Jugador player2 =new Jugador("Maria");
        Juego juego = new Juego(player1, player2);
        // Como puedo visualizar la carta?

    }
}
