import RummyArgentino.Controlador.Juego;
import RummyKub.Modelo.Carta;
import RummyKub.Modelo.GuardarPartidaJson;
import Comun.Util.FileUtil;
import Comun.Util.JsonReader;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Nota: Consejo de Joan -> Crear objetos y luego cada metodo que devuelva algo y ponerlo dentro del objeto que hemos creado
        mostrarJuegos();
        int opcionElegida = getOpcionElegidaPorJugador();
        // TODO: 05/06/2024 Este if lo tengo que cambiar por un swicht

        if (opcionElegida == 1){

            RummyKub.Controlador.Juego juegoRummuKub = new RummyKub.Controlador.Juego();

        }  else if (opcionElegida == 2) {
            Juego.pintarArgentino();

            // Crear una Clase de PartidasGuardas
        }  else if (opcionElegida == 3) {
            int eleccion = selecionarJuegoRecuperar();

            String RECURSOS_PATH = "RummyKub/Recursos";


            switch (eleccion){
                case 1:
                    // Aqui ya he puesto el nombre del juego
                    RECURSOS_PATH = "RummyKub/Recursos";

                    break;
                case 2:
                    // Para obtener la ruta hacer click derecho y Copy Path Reference
                    RECURSOS_PATH = "RummyArgentino/Recursos";

                    break;
            }

            ArrayList<String> archivos = FileUtil.listarArchivosEnCarpeta(RECURSOS_PATH);
            System.out.println("Archivos en la carpeta 'Recursos': " + archivos);
            int nunIndiceArchivo = getArchivo(archivos);


            GuardarPartidaJson guardarPartidaJson = getPartidaGuardad(RECURSOS_PATH, archivos, nunIndiceArchivo);
            ArrayList<Carta> todasCartasJugador = guardarPartidaJson.getTodasCartasJugador();

            System.out.println(todasCartasJugador);


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

        String nombreArchivoJson = archivos.get(nunIndiceArchivo);

        String ubicacionJson = String.format("%s/%s", ubicacionArchivo, nombreArchivoJson);

        Gson gson = new Gson();

        String partidaGuardada = "";
        try {
            // Lo que hacemos es coger la ruta donde tengo guardado el archivo JSON
            // y luego me guarda toda esa informcion en una cadena de texto (String)
            // el posible error es que la ruta este mal, otro error es que el archivo
            // que esta leyendo tenga errores de sintaxis, por eso lo metemos dentro de un Try and Catch
            partidaGuardada = JsonReader.readFileAsString(ubicacionJson);
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
