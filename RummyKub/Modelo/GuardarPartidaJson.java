package RummyKub.Modelo;

import Comun.Util.JsonFileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static Comun.Util.JsonFileWriter.construirRutaArchivoJson;

public class GuardarPartidaJson {
    private static final String NOMBRE_JUEGO = "RummyKub";
    // Quiero guardar todas las cartas del jugador
    ArrayList<Carta> mazoCartasJugador1;
    int turno;


//    private ArrayList<Carta> mazoCartasJugador;
//
//    private ArrayList<Jugadas> jugadasArrayList;

    // voy a hacer una rama para decidir que cosas voy a guardar en esta clase
    // creo que hare constructores. Uno para guardar toda la partida
    // y el otro constructor para guardar los elementos necesarios
    // o puedo guardarlo todo y luego decidir que cosas necesito
    // Empezamos
    public GuardarPartidaJson(){
    }

    public void setTodasCartasJugador(ArrayList<Jugador> listaJugadores){
        this.mazoCartasJugador1 = listaJugadores.get(0).getMazoCartas();
    }

    public ArrayList<Carta> getTodasCartasJugador() {
        return mazoCartasJugador1;
    }

    // toString sirve para visuarlizar el contenido que
    // tengo guardado dentro de los atributos

    @Override
    public String toString() {
        return "GuardarPartidaJson{" +
                "mazoCartasJugador1=" + mazoCartasJugador1 +
                '}';
    }

    // este metodo deberia estar en la Clase juego pero la pongo aqui porque voy hacer modificaciones
    // usar este metodo cuando quiera grabar la partida completa con toda la informacion
    private void copiaDeSeguridadCompleta(ArrayList<Jugadas> jugadasArrayList ,ArrayList<Jugador> listaJugadores, ArrayList<Carta> jugadorRefMazoCartas) {
        // info de como usar la libreria de Google Gson:
        // https://adictosaltrabajo.com/2012/09/17/gson-java-json/

        // donde descargarse la libreria, descargarlo en formato JAR
        // https://github.com/google/gson?tab=readme-ov-file
        // https://search.maven.org/artifact/com.google.code.gson/gson/2.11.0/jar?eh=


        // Como instalar la libreria
        // https://www.youtube.com/watch?v=jJ9i0Mi3Ryw&ab_channel=PrashantRana

        // Explicacion paso a paso de lo que hago en este método llamado: copiaDeSeguridadJugador
        // primero paso: creamos un objeto para poder guardar las cartas del juego
        // en la clase GuardarPartidaJson podemos poner todos los atributos que nos intresa guardar
        GuardarPartidaJson guardarPartidaJson = new GuardarPartidaJson();

        // vamos a guardar las cartas del jugador que tiene en sus manos usando los setters
        guardarPartidaJson.setTodasCartasJugador(listaJugadores);
//        guardarPartidaJson.setListaJugadores(listaJugadores);
//        guardarPartidaJson.setJugadasArrayList(jugadasArrayList);


        // 2n paso
        // Se crea un objeto de la clase Gson, que es una biblioteca de Google utilizada
        // para convertir objetos Java en su representación JSON y viceversa.
        Gson gson = new Gson();
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        // Explicado como usar el Prretty para que se vea mejor --> // https://adictosaltrabajo.com/2012/09/17/gson-java-json/
        // Otro ejemplo de como usar la clase gson --> https://casderoso.com/2015/04/05/utilizar-libreria-gson-en-java/

        // Siguiente paso:
        // Transforma un objeto a un formato Json y te lo devuelve como un String
        // Ahora tengo guardado todos los 3 datos en el objeto guardarPartidaJson gracias a los setter
        //  El método toJson de la clase Gson se utiliza para convertir el objeto "guardarPartidaJson" a una cadena String JSON.
        //  El resultado de esta conversión se almacena en la variable PrettyguardarCartasJugador

        // mejorando codigo con Pretty
        // String guardarCartasJugador = gson.toJson(guardarPartidaJson); // Luego borrare esta linea
        String PrettyguardarCartasJugador = prettyGson.toJson(guardarPartidaJson);


        // 3r paso. Primero creamos la ubicacion del archivo
        // para eso le pasamos el nombre del juego y el nombre del jugador
        // Aqui guardamos el nombre del juego, y el nombre del jugador

        String nombresJugadoresUnidos = "RummyKub_";
        for (Jugador jugador: listaJugadores) {
            nombresJugadoresUnidos = nombresJugadoresUnidos + jugador.getNombre();
        }

        // El método Static de construirRutaArchivoJson() lo que
        // hace es devolverte un String con la ruta donde pretendemos
        // guardar nuestra copia de seguridad
        String ubicacionArchivo = construirRutaArchivoJson(NOMBRE_JUEGO, nombresJugadoresUnidos);



        try {
            //  método Static de crear un archivo JsonFileWriter
            // En el primer parametro pasamos los datos que tenemos guardado en formato JSON como String
            // en el segundo parametro pasamos la ruta donde queremos crear el FORMATO Json
            JsonFileWriter.crearArchivoJson(PrettyguardarCartasJugador, ubicacionArchivo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

