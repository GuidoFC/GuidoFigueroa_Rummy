import RummyArgentino.Prueba;
import RummyKub.Controlador.Juego;
import RummyKub.Modelo.GuardarPartidaJson;
import RummyKub.Modelo.Jugador;
import Util.JsonReader;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

import static Util.JsonFileWriter.construirRutaArchivoJson;

public class Main {
    public static void main(String[] args) {

        mostrarJuegos();
        int opcionElegida = getOpcionElegidaPorJugador();
        if (opcionElegida == 1){
            Jugador player1 =new Jugador("Guido");
            Jugador player2 =new Jugador("Maria");
            Juego juego = new Juego(player1, player2);

        }  else if (opcionElegida == 2) {
            Prueba.pintarArgentino();
        }  else if (opcionElegida == 3) {

        }

    }
    public static void mostrarJuegos(){
        System.out.println("""
                Bienvenido, a que juego quiere jugar:
                    1) RummyKub
                    2) RummyArgentino
                    3) Recuperar una Partida
                """);
    }

    public static int getOpcionElegidaPorJugador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el juego que quieres jugar");

        int opcion = sc.nextInt();
        return opcion;
    }

//    private static GuardarPartidaJson leerCopiaSeguridad(ArrayList<Jugador> listaJugadores){
//        // Tengo que generar el nombre de la ruta para poder acceder a esa copia
//        String nombresUnindos = "RummyKub_";
//        for (Jugador jugador: listaJugadores) {
//            nombresUnindos = nombresUnindos + jugador.getNombre();
//        }
//
//        Gson gson = new Gson();
//        // Nota: Nombre_Juego lo tengo declarado como una constante (final) para saber que
//        // como tiene que empezar la ruta
//        String ubicacionArchivo = construirRutaArchivoJson(NOMBRE_JUEGO ,nombresUnindos);
//        String partidaGuardada = "";
//        try {
//            // Lo que hacemos es coger la ruta donde tengo guardado el archivo JSON
//            // y luego me guarda toda esa informcion en una cadena de texto (String)
//            // el posible error es que la ruta este mal, otro error es que el archivo
//            // que esta leyendo tenga errores de sintaxis, por eso lo metemos dentro de un Try and Catch
//            partidaGuardada = JsonReader.readFileAsString(ubicacionArchivo);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        // crear un objeto Gson e invocar a su método fromJson para
//        // conseguir pasar de Json a un Objeto. En este caso me devolvera
//        // un objeto de la clase GuardarPartidaJson donde lo podre usar
//        // para recuperar la partida. Este método lo tengo que poner en el main
//        // y tendria que hacer un nuevo constructor para introducir las variables
//        // que he recuperado.
//        // mirar info de esta pagina https://adictosaltrabajo.com/2012/09/17/gson-java-json/
//        // apartado: 3.10. Leyendo JSON desde un fichero.
//        GuardarPartidaJson GuardarPartidaJsonCopia;
//        return GuardarPartidaJsonCopia = gson.fromJson(partidaGuardada, GuardarPartidaJson.class);
//    }
}
