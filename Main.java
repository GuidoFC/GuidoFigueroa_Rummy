import RummyArgentino.Prueba;
import RummyKub.Controlador.Juego;
import RummyKub.Modelo.GuardarPartidaJson;
import RummyKub.Modelo.Jugador;
import Util.FileUtil;
import Util.JsonReader;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

import static Util.JsonFileWriter.construirRutaArchivoJson;

public class Main {
    public static void main(String[] args) {

        mostrarJuegos();
        int opcionElegida = getOpcionElegidaPorJugador();
        // TODO: 05/06/2024 Este if lo tengo que cambiar por un swicht

        if (opcionElegida == 1){
            Jugador player1 =new Jugador("Guido");
            Jugador player2 =new Jugador("Maria");
            Juego juego = new Juego(player1, player2);

        }  else if (opcionElegida == 2) {
            Prueba.pintarArgentino();

        }  else if (opcionElegida == 3) {
            int eleccion = selecionarJuegoRecuperar();

            String RECURSOS_PATH = "RummyKub/Recursos/";

            switch (eleccion){
                case 1:
                    RECURSOS_PATH = "RummyKub/Recursos/";

                    break;
                case 2:
                    // Para obtener la ruta hacer click derecho y Copy Path Reference
                    RECURSOS_PATH = "RummyArgentino/Recursos";

                    break;
            }


            ArrayList<String> archivos = FileUtil.listarArchivosEnCarpeta(RECURSOS_PATH);
            System.out.println("Archivos en la carpeta 'Recursos': " + archivos);
            int nunIndiceArchivo = getArchivo(archivos);



            getPartidaGuardad(RECURSOS_PATH, archivos, nunIndiceArchivo);

        }

    }

    public static int getArchivo(ArrayList<String> archivos){
        int opcion = 0;

        int numeroMax = archivos.size();
        String mensaje = """
                De la posicion del array, que archivo quiere recuperar
                """;
        System.out.println();
        System.out.println(mensaje);
        do {
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
        }while (opcion < 0 || opcion > numeroMax);

        return opcion;

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
        System.out.println("Introduce un numero para elegir una de las siguientes opciones: ");

        int opcion = sc.nextInt();
        return opcion;
    }

    public static int selecionarJuegoRecuperar(){
        int eleccion = 0;
        String juego = """
                 Que juego quiere recuperar:
                    1) RummyKub
                    2) RummyArgentino
                """;
        System.out.println();
        System.out.println(juego);

        Scanner sc = new Scanner(System.in);

        do {
            eleccion =  sc.nextInt();
            if (eleccion == 1){
                break;
            }
            if (eleccion == 2){
                break;
            }
        }while (true);

        return eleccion;
    }

    private static GuardarPartidaJson getPartidaGuardad(String ubicacionArchivo, ArrayList<String> archivos, int nunIndiceArchivo){

        System.out.println();
        System.out.println("Tengo estos 3 parametros");
        System.out.println(ubicacionArchivo);
        System.out.println(archivos);
        System.out.println(nunIndiceArchivo);
        System.out.println("Fin ");
        System.out.println();
        Gson gson = new Gson();

        String partidaGuardada = "";
        try {
            // Lo que hacemos es coger la ruta donde tengo guardado el archivo JSON
            // y luego me guarda toda esa informcion en una cadena de texto (String)
            // el posible error es que la ruta este mal, otro error es que el archivo
            // que esta leyendo tenga errores de sintaxis, por eso lo metemos dentro de un Try and Catch
            partidaGuardada = JsonReader.readFileAsString(ubicacionArchivo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // crear un objeto Gson e invocar a su método fromJson para
        // conseguir pasar de Json a un Objeto. En este caso me devolvera
        // un objeto de la clase GuardarPartidaJson donde lo podre usar
        // para recuperar la partida. Este método lo tengo que poner en el main
        // y tendria que hacer un nuevo constructor para introducir las variables
        // que he recuperado.
        // mirar info de esta pagina https://adictosaltrabajo.com/2012/09/17/gson-java-json/
        // apartado: 3.10. Leyendo JSON desde un fichero.
        GuardarPartidaJson GuardarPartidaJsonCopia;
        return GuardarPartidaJsonCopia = gson.fromJson(partidaGuardada, GuardarPartidaJson.class);
    }
}
