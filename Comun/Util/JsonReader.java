package Comun.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    public static String readFileAsString(String filePath) throws IOException {
        // Explicacion de como leer un un Formato Json
        // https://www.youtube.com/watch?v=CW5I1umbPvM&ab_channel=DiscoDurodeRoer
        // https://codegym.cc/es/groups/posts/es.219.archivos-java-ruta


        // Explicacion más util
        // https://www.arold.es/java-nio2-ejemplos/ --> Lee el contenido de un fichero de texto a una cadena
        return new String(Files.readAllBytes(Paths.get(filePath)));
        /* Clase: Paths
            Método: get(String filePath)
            Propósito: Convierte la cadena que representa la ruta del archivo (filePath) en un objeto Path.
            Los objetos Path son más versátiles que las cadenas para manejar rutas de archivos porque proporcionan métodos para realizar operaciones más complejas sobre las rutas de manera eficiente.
            Uso: Usado aquí para especificar la ubicación del archivo que deseas leer.

            Files.readAllBytes(Path path)
            Clase: Files
            Método: readAllBytes(Path path)
            Propósito: Lee todos los bytes del archivo especificado por el objeto Path y los devuelve como un arreglo de bytes (byte[]). Este método es útil para cargar rápidamente el contenido de un archivo en memoria.

            Constructor de String
            Propósito: Crea una nueva cadena (String) a partir de un arreglo de bytes.
            Este constructor interpreta los bytes como caracteres según la codificación
            predeterminada del sistema si no se especifica otra.
        * */

    }
}
