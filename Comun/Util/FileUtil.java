package Comun.Util;

import RummyKub.Modelo.GuardarPartidaJson;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

    // private static final String RECURSOS_PATH = "RummyKub/Recursos/";

    /**
     * Devuelve una lista de nombres de todos los archivos en la carpeta "Recursos".
     *
     * @return Lista de nombres de archivos.
     */
    public static ArrayList<String> listarArchivosEnCarpeta(String RECURSOS_PATH) {
        ArrayList<String> nombresArchivos = new ArrayList<>();
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

    public static GuardarPartidaJson getPartidaGuardad(String ubicacionArchivo, ArrayList<String> archivos, int nunIndiceArchivo){

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

//    public static void main(String[] args) {
//        // Listar los archivos en la carpeta "Recursos"
//        ArrayList<String> archivos = listarArchivosEnCarpeta(RECURSOS_PATH);
//        System.out.println("Archivos en la carpeta 'Recursos': " + archivos);
//
//        // Dejo comentado lo de abajo porque no me interesa ver que hay en cada carpeta
//        // Leer un archivo específico
////        try {
////            String contenido = leerArchivo("partida_GuidoMaria.json");
////            System.out.println("Contenido del archivo: " + contenido);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
}
