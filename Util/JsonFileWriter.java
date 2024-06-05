package Util;

import RummyKub.Modelo.GuardarPartidaJson;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class JsonFileWriter {

    public static String construirRutaArchivoJson(String nombreJuego, String nombresJugadores) {
        // Gracias el método format() del String podemos hacer lo siguiente:
        // Esta %s lo que hace es sustituir el String nombreJuego --> %s: Este es un especificador que indica que el valor que se insertará en ese lugar será tratado como una cadena (String). Cada %s se sustituirá por los argumentos proporcionados después de la cadena de formato, en el mismo orden que aparecen.
        // es decir, quedaria --> "RummyKub.Recursos/partida_GuidoMaria.json"
        // De esta forma obtenemos la ruta donde se guardara y el nombre del archivo
        return String.format("%s/Recursos/partida_%s.json", nombreJuego, nombresJugadores);
        // Lo que le estoy indicando es la ruta donde me tiene que guardar el archivo.
        // Ejemplo: RummyKub/Recursos/partida_RummyKubGuidoMaria.json
    }

    // throws IOException: Indica que el método puede lanzar una excepción de tipo IOException, la cual debe ser manejada por el método que lo llama. Esto ocurre generalmente cuando hay un problema de entrada/salida, como un error al escribir el archivo.
    public static void crearArchivoJson(String datosFormatojson, String rutaArchivoJson) throws IOException {
        // Experimento


        // crea un archivo.Json con datos en forma de Json
        // todos los datos son Bytes
        // Explicacion detallada
        // Paths.get(rutaArchivoJson): Convierte la ruta del archivo en un objeto Path, que representa la ubicación en el sistema de archivos.
        Files.write(Paths.get(rutaArchivoJson), datosFormatojson.getBytes());
        // Mas info:
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html
    }
}



//    public static void main(String[] args) {
//        // TODO: 02/06/2024 Lo unico que tengo
//        // Es una prueba rapida para ver si funciona bien el método
//        // Nosotros usamos la libreria gson para obtener los datos
//        // en formato Json
//        // primero creamos un objeto para poder guardar las cartas del juego
//        // porque hay voy a guardar los datos de mi partida mediante los setters
//        GuardarPartidaJson guardarPartidaJson = new GuardarPartidaJson();
//
//        // aqui un ejemplo de poner todos los setters
//        guardarPartidaJson.setMazoCartasJugador(null);
//        // 2n) transoformar los datos de la clase guardarPartidaJson a formato JSON
//        // para ello usaremos la libreria gson
//        // para ello hacemos una instacion de gson
//        Gson gson = new Gson();
//
//        // Transforma un objeto a un formato Json, para ello usamos el metodo toJson
//        // para pasar los datos de JSON a String
//        String guardarCartasJugador = gson.toJson(guardarPartidaJson);
//
//        // 3r paso, guadar el archivo. Pero antes tenemos obtener la ruta mediante el
//        // metodo construirRutaArchivoJson
//        String rutaArchivoJson = construirRutaArchivoJson("RummyArgentino","GuidoPrueba");
//
//
//        // Aqui guardamos el nombre del juego, y el nombre del jugador
//
//
//
//
//        // String datosFormatoJson = "{\"nombreSimbolo\": \"Corazones\", \"valor\": 10}";
//        // para esto voy a la carpeta recurso que he creado y hago click derecho
//        // para coger Path/Reference
//
//        // Aqui hacemos la prueba poniendo el nombre del juego: RummyKub o RummyArgentino
//        // para ver si realmente se guarda en la carpeta del juego
//
//
//
//        try {
//            crearArchivoJson(guardarCartasJugador, rutaArchivoJson);
//            System.out.println("JSON guardado en " + rutaArchivoJson);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}