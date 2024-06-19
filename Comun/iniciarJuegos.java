package Comun;

import Comun.Util.FileUtil;
import RummyArgentino.Controlador.Juego;
import RummyKub.Modelo.Carta;
import RummyKub.Modelo.GuardarPartidaJson;

import java.util.ArrayList;
import java.util.Scanner;

import static Comun.Util.FileUtil.getPartidaGuardad;

public class iniciarJuegos {

    public iniciarJuegos(){

    }

    public void iniciarJuegos(){
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

}
