package Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final String RECURSOS_PATH = "RummyKub/Recursos/";

    /**
     * Devuelve una lista de nombres de todos los archivos en la carpeta "Recursos".
     *
     * @return Lista de nombres de archivos.
     */
    public static List<String> listarArchivosEnCarpeta() {
        List<String> nombresArchivos = new ArrayList<>();
        File carpeta = new File(RECURSOS_PATH);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        nombresArchivos.add(archivo.getName());
                    }
                }
            }
        }
        return nombresArchivos;
    }

    /**
     * Devuelve el contenido de un archivo específico en la carpeta "Recursos".
     *
     * // @param nombreArchivo Nombre del archivo a leer.
     * @return Contenido del archivo como String.
     * @throws IOException Si ocurre un error al leer el archivo.
     */

    // Este metodo no me hace falta, lo dejare comentado por si en un futuro me arrepiento
    // y lo quiero ver el contenido que hay dentro de cada archivo

//    public static String leerArchivo(String nombreArchivo) throws IOException {
//        String filePath = RECURSOS_PATH + File.separator + nombreArchivo;
//        return new String(Files.readAllBytes(Paths.get(filePath)));
//    }

    public static void main(String[] args) {
        // Listar los archivos en la carpeta "Recursos"
        List<String> archivos = listarArchivosEnCarpeta();
        System.out.println("Archivos en la carpeta 'Recursos': " + archivos);

        // Dejo comentado lo de abajo porque no me interesa ver que hay en cada carpeta
        // Leer un archivo específico
//        try {
//            String contenido = leerArchivo("partida_GuidoMaria.json");
//            System.out.println("Contenido del archivo: " + contenido);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
