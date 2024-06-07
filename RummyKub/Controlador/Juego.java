package RummyKub.Controlador;

import RummyKub.Modelo.*;
import Util.JsonFileWriter;
import Util.JsonReader;
import RummyKub.Vista.Print;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static Util.JsonFileWriter.construirRutaArchivoJson;

public class Juego {

    // nombre del juego para poder usarlo cuando creemos la copia de Seguridad
    private static final String NOMBRE_JUEGO = "RummyKub";

    // Esto son las cosas que necesito guardar
    ArrayList<Jugadas> jugadasArrayList = new ArrayList<>();
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    Print presentacion = new Print();
    private static int turno;

    private ArrayList<Carta> arrayListComprobarJugada = new ArrayList<>();




    public Juego(){
        // TODO: 07/06/2024 Tengo que hacer un metodo para crear a los jugadores
        //  por ahora lo hago asi para ir más rapido cada vez inicio el juego

        Jugador player1 =new Jugador("Guido");
        Jugador player2 =new Jugador("Maria");
        turno = 0;

        // primero creamos un objeto de la clase BarajaCarta que es donde guardaremos las cartas
        MazoCartas mazoCartas1 = new MazoCartas();
        // segundo vamos a crear las cartas y las guardamos en el objeto que hemos creado
        createAllCard(mazoCartas1);

        // Vemos todas las cartas del mazo
        // this.presentacion.verTodasLasCartas(mazoCartas1);

        // barajamos las cartas
        mazoCartas1.barajarCartas();
        // vemos las cartas barajadas
        this.presentacion.verTodasLasCartas(mazoCartas1);

        // añadimos los jugadores en el arraylist
        addPlayertolistJugadore(player1, player2);

        // ahora quiero hacer un método para repartir las cartas para cada jugador
        repartirCartas(mazoCartas1);

        // ahora quiero ver las cartas que tiene cada jugador
        presentacion.verCartaJugador(player1);
        presentacion.verCartaJugador(player2);


        Jugador jugadorRef = listaJugadores.get(turno);
        // ahora quiero poner la logica entre si el jugador
        // tiene una jugada o tiene que coger carta
        logicGame(jugadorRef, mazoCartas1);

    }




    private void logicGame(Jugador jugadorRef, MazoCartas mazoCartas1){
        // Vemos las cartas del jugador que le toca ahora
        presentacion.mensajeVisualizarNombreJugadorTurno(listaJugadores, turno);
        int eleccion1  = getFirstEleccionPlayer(jugadorRef);
        presentacion.mensajeEleccionJugador(eleccion1);
// Del método getFirstEleccionPlayer()
//        Elija una de las siguientes opciones:
//        1) Coger Carta del Deck
//        2) Tengo una jugada
//        3) Coger una carta de la mesa
        ejecutarFirstEleccionPlayer(jugadorRef, mazoCartas1, eleccion1);

        // Segunda parte
        // eleccion = getEleccionPlayer(jugadorRef);
        // TODO: 31/05/2024 Tengo pendiente refactorizar los metodos getEleccionPlayer()
        //  y getEleccion2Player pq son muy similares

        int eleccion2;
        final int ELECCION_FIN_TURNO = 3;
        // TODO: 07/06/2024 Puedo hacer que el metodo ejecutarFirstEleccionPlayer() se pueda usar
        //  para la primera eleccion y las otras creando variables de control y return si no lo cumple
        do {
            System.out.println();
            System.out.println("Empieza el bucle de segunda eleccion");
            System.out.println();
            eleccion2 = getSegundaEleccionPlayer(jugadorRef);

            presentacion.mensajeEleccionJugador(eleccion2);
            // método para añadir de forma artificial una Tupla [Luego Borrar]
            crearJugadaTupla(mazoCartas1, jugadorRef);


            // método para añadir de forma artificial una Escalera [Luego Borrar]
            // tener en cuenta el Joker
            crearJugadaEscalera(mazoCartas1, jugadorRef);
            // Para ver las cartas que tiene y el jugador pueda tomar una mejor decision
            System.out.println("Se han añadido las cartas? ");
            presentacion.verCartaJugador(jugadorRef);
            switch (eleccion2){
                case 1:
                    int eleccionJugador = getEleccionEscaleraTuplaPonerCartaMesa();

                    ejecutarEleccionJugador(jugadorRef, eleccionJugador);
                    break;
                case 2:
                    // TODO: 07/06/2024 No implementare esto de segunda jugada lo hare
                    //  todo en un mismo bucle y hare variables de control
                    // Creamos una copia de Seguridad



                    // Recuperar la copia de Seguridad
                    GuardarPartidaJson guardarPartidaJson= leerCopiaSeguridad(listaJugadores);
                    break;
                case 3:
                    // le toca al siguiente jugador
                    turno = changeTurno(turno);
                    break;
            }
        }while (eleccion2 != ELECCION_FIN_TURNO);


        // segundo ver todas las jugadas de Escalera

        // llamar al método









        // todo en el metodo logicaJugadaEscalera()
        //  modifico el valorNumerico del Comodin,
        //  tengo que volver a restablecer el valor cuando se terminen
        //  las cartas del Stock y tengo que
        //  volver a barajar. Tendria que tener un metodo para
        //  comprobar si hay que barajar

        restablecerValorYSymboloComodin();
    }

    private void ejecutarFirstEleccionPlayer(Jugador jugadorRef, MazoCartas mazoCartas1, int eleccion) {
        switch (eleccion){
            case 1: //        1) Coger Carta del Deck
                obtenerCartaAdicional(mazoCartas1, jugadorRef);
                presentacion.verCartaJugador(jugadorRef);
                // turno = changeTurno(turno); // No tiene sentido cambiar de turno porque puede realizar una jugada despues de coger una carta
                break;
            case 2: //        2) Tengo una jugada
                // vamos a elaborar la logica del juego
                // para ver si el jugador tiene una tupla o escalera

                // método para añadir de forma artificial una Tupla [Luego Borrar]
                crearJugadaTupla(mazoCartas1, jugadorRef);


                // método para añadir de forma artificial una Escalera [Luego Borrar]
                // tener en cuenta el Joker
                crearJugadaEscalera(mazoCartas1, jugadorRef);


                int eleccionJugador = getEleccionEscaleraTuplaPonerCartaMesa();

                // vemos si se ha añadido correctamente las cartas que he introducido de forma artificial

                presentacion.verCartaJugador(jugadorRef);
                ejecutarEleccionJugador(jugadorRef, eleccionJugador);



                // ambos jugadores tendrian que ver todas las jugadas que se han puesto en la mesa
                // primero ver todas las jugadas de Tuplas
                Jugadas jugadas;
                int tamanoArray;
                // tener en cuenta que dentro del jugadasArrayList hay objetos.
                // y dentro de cada objeto tiene guardado su propio ArrayList de Cartas
                for (int i = 0; i < jugadasArrayList.size(); i++) {

                    presentacion.seeAllCardPlayed(jugadasArrayList, i);
                }

        }
        System.out.println();
        System.out.println("Fin del codigo Primera Eleccion");
        System.out.println();
    }

    private void ejecutarEleccionJugador(Jugador jugadorRef, int eleccionJugador) {
        switch (eleccionJugador){
            case 1: // jugada Tupla
                // primero comprobar que es un Tupla y luego crear el objeto
                // control de si la jugada es valida
                boolean jugadaTuplaValida = comprobarJugadaTupla(jugadorRef);
                if (jugadaTuplaValida){
                    presentacion.mensajeJugadaCorrecta(jugadaTuplaValida);
                    // creamos el objeto JugadaTupla
                    createClassTuplaAndResetArrayListComprobarJugada();
                }else {
                    presentacion.mensajeJugadaCorrecta(jugadaTuplaValida);
                    // devolver las cartas al jugador
                    returnCardToPlayerAndResetArrayListComprobarJugada(jugadorRef);
                }
                break;
            case 2: // jugada escalera
                // primero comprobar que es un Escalera y luego crear el objeto
                // control de si la jugada es valida
                boolean jugadaEscaleraValida = comprobarJugadaEscalera(jugadorRef);
                if (jugadaEscaleraValida){
                    presentacion.mensajeJugadaCorrecta(jugadaEscaleraValida);
                    // creamos el objeto JugadaEscalera
                    // TODO: 30/05/2024 Pendiente hacer el siguiente método
                    createClassEscaleraAndResetArrayListComprbarJugada();
                }else {
                    presentacion.mensajeJugadaCorrecta(jugadaEscaleraValida);
                    // devolver las cartas al jugador
                    returnCardToPlayerAndResetArrayListComprobarJugada(jugadorRef);

                }
                break;
            case 3:
                // Primero creamos una Tupla de forma artificial
                JugadaTupla jugadaTuplaArtificialCinco =  crearJugadaTuplaArtificialCardNumberCinco();

                JugadaTupla jugadaTuplaArtificialTRECEConJoker =  crearJugadaTuplaArtificialJokerNumero13();
                // Segundo añadimos este Objeto de jugadaTuplaArtificial en el jugadasArrayList
                jugadasArrayList.add(jugadaTuplaArtificialCinco);
                jugadasArrayList.add(jugadaTuplaArtificialTRECEConJoker);

                // Segundo B) Tengo que enseñar las cartas que hay en la jugada
//                for (int i = 0; i < jugadasArrayList.size(); i++) {
//                    for (int j = 0; j < jugadasArrayList.get(i).putSizeArray(); j++) {
//                        System.out.println(jugadasArrayList.get(i).getCard(j).toString());
//                    }
//                    System.out.println();
//
//                }

                for (int i = 0; i < jugadasArrayList.size(); i++) {

                    presentacion.seeAllCardPlayed(jugadasArrayList, i);
                }
                // Tercero Creamos una copia de Seguridad
                    // Necesitamos guardar las cartas del jugador y el arraylist que esta previo
                    // antes de hacer la jugada
                        // Este metodo se tiene que ejecutar si despues de hacer la validacion,
                        // la jugada no es correcta. De este metodo tengo un objeto que tendre
                        // que usar los getters para poder restablecer los valores.
                copiaDeSeguridadMomentanea(jugadasArrayList, jugadorRef);

                // Cuarto Permitir al jugador poner una carta

                System.out.println();
                System.out.println("Fin prueba");


                // Cuarto permitimos al usuario

                // Poner una carta en la mesa. Tengo que preguntar al usuario lo siguiente:

                    // añadir una carta a la JugadaEscalera
                    // añadir una carta a la JugadaTupla
                break;
            case 4:
                // Coger una carta en la mesa de juego

                break;

        }
    }

    private JugadaTupla crearJugadaTuplaArtificialCardNumberCinco(){
        Carta carta5C = new Carta(CardSymbol.CORAZON_ROJO, CardNumber.CINCO);
        Carta carta5D = new Carta(CardSymbol.DIAMANTE, CardNumber.CINCO);
        Carta carta5T = new Carta(CardSymbol.TREBOL, CardNumber.CINCO);

        // añadimos las cartas en la jugadaTupla

         JugadaTupla jugadaTupla = new JugadaTupla(carta5C.getCardNumber().getValor());

         jugadaTupla.addCard(carta5C);
        jugadaTupla.addCard(carta5D);
        jugadaTupla.addCard(carta5T);

        return jugadaTupla;

    }

    private JugadaTupla crearJugadaTuplaArtificialJokerNumero13(){
        Carta carta13C = new Carta(CardSymbol.COMODIN, CardNumber.COMODIN);
        Carta carta13D = new Carta(CardSymbol.DIAMANTE, CardNumber.K);
        Carta carta13P = new Carta(CardSymbol.PICAS, CardNumber.K);

        // añadimos las cartas en la jugadaTupla

        JugadaTupla jugadaTupla = new JugadaTupla(carta13D.getCardNumber().getValor());

        jugadaTupla.addCard(carta13C);
        jugadaTupla.addCard(carta13D);
        jugadaTupla.addCard(carta13P);

        return jugadaTupla;

    }

    private void copiaDeSeguridadMomentanea(ArrayList<Jugadas> jugadasArrayList, Jugador jugadorRef) {
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
        GuardarRestablecerJson guardarPartidaJson = new GuardarRestablecerJson();

        // vamos a guardar las cartas del jugador que tiene en sus manos usando los setters
        guardarPartidaJson.setTodasCartasJugador(jugadorRef.getMazoCartas());
        // vamos a guardar las todas las cartas que hay presentadas en las jugadas
        guardarPartidaJson.setJugadasArrayList(jugadasArrayList);

//        guardarPartidaJson.setListaJugadores(listaJugadores);
//        guardarPartidaJson.setJugadasArrayList(jugadasArrayList);


        // 2n paso
        // Se crea un objeto de la clase Gson, que es una biblioteca de Google utilizada
        // para convertir objetos Java en su representación JSON y viceversa.

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        // Explicado como usar el Prretty para que se vea mejor --> // https://adictosaltrabajo.com/2012/09/17/gson-java-json/
        // Otro ejemplo de como usar la clase gson --> https://casderoso.com/2015/04/05/utilizar-libreria-gson-en-java/

        // Siguiente paso:
        // Transforma un objeto a un formato Json y te lo devuelve como un String
        // Ahora tengo guardado todos los 3 datos en el objeto guardarPartidaJson gracias a los setter
            //  El método toJson de la clase Gson se utiliza para convertir el objeto "guardarPartidaJson" a una cadena String JSON.
            //  El resultado de esta conversión se almacena en la variable PrettyguardarCartasJugador

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

    private static GuardarPartidaJson leerCopiaSeguridad(ArrayList<Jugador> listaJugadores){
        // Tengo que generar el nombre de la ruta para poder acceder a esa copia
        String nombresUnindos = "RummyKub_";
        for (Jugador jugador: listaJugadores) {
            nombresUnindos = nombresUnindos + jugador.getNombre();
        }

        Gson gson = new Gson();
        // Nota: Nombre_Juego lo tengo declarado como una constante (final) para saber que
        // como tiene que empezar la ruta
        String ubicacionArchivo = construirRutaArchivoJson(NOMBRE_JUEGO ,nombresUnindos);
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




    private int getEleccionEscaleraTuplaPonerCartaMesa() {
        int opcionJugador;
        do {
            opcionJugador  = presentacion.mensajeChooseTuplaEscaleraPutCardTable();
        }while (opcionJugador == 0);
        return opcionJugador;
    }

    private int getSegundaEleccionPlayer(Jugador jugadorRef) {
        int eleccion;
        do {
            eleccion = presentacion.continueChoosingPlayer(jugadorRef, jugadasArrayList);
        }while (eleccion == 0);
        return eleccion;
    }

    private int getFirstEleccionPlayer(Jugador jugadorRef) {
        int eleccion;
        do {
            eleccion = presentacion.chooseDecisionPlayer(jugadorRef, jugadasArrayList);
        }while (eleccion == 0);
        return eleccion;
    }


    private boolean comprobarJugadaEscalera(Jugador jugadorRef){
        // El jugador tiene que seleccionar que cartas quiere presentar para hacer la jugada Escalera
        elegirCartasToPlay(jugadorRef);

        // vemos que cartas se han introducido en el ArrayList --> arrayListComprobarJugada
        // luego borrar este FOR
        verCartasArrayListComprobarJugada();

        boolean jugadaValida = logicaJugadaEscalera();
        return jugadaValida;
    }

    private boolean logicaJugadaEscalera(){
        boolean jugadaValida = true;
        // primero tengo que mirar si hay un Comodin,
        boolean isComodin = IsThereComodin();

        // si hay comodin tengo que descubrir que Valor y Symbolo de la escalera representa
        establecerValorYSymboloComodin(isComodin);

        // luego tengo que ordenar las cartas
        // Puedo ordenar de 2 formas.
        // 1r) Si tengo cartas de 13 y 1 me lo ordena de la siguiente forma [ej: 11, 12, 13, 1, 2]
        // 2n) si no tengo cartas de 13 y 1 me lo ordena de forma ascendiente [ej: 5,6,7,8]
        sortCardsByValue();

                // Enseñar las cartas que ha presentado para el juego
        System.out.println();
        System.out.println("Estas son las cartas que has presentado de forma ordenada");
        System.out.println();
        verCartasArrayListComprobarJugada();


        // TODO: 29/05/2024 tengo que modificarlo para que tenga en cuenta si es una Jugada Escalera Valida
        //  Recuerda que el comodin ya tiene symbolo y valor. Tenemos que tener en
        //  cuenta si la escalera contiene 13 y 1
        //  Si es correcto, creamos el objeto

        //  necesito coger el numero de referencia por donde empezara la
        //  Escalera para luego crear el objeto JugadaEscalera
        int empiezaEscaleraNumero = arrayListComprobarJugada.get(0).getCardNumber().getValor();

        // obtengo la primera Carta para extraer en la siguiente linea el Symbolo de referencia de la Escalera
        // Tengo que mirar que la primera carta no sea un Comodin, si la carta es un comodin
        // cogeremos la siguiente carta hasta que no sea comodin

        Carta firstCardWithSymbol = getSymbolCartaWithNoComodin(isComodin);

        // si hay comodin tengo que asignar un valor para  la escalera representa
        // establecerSymboloComodin(isComodin, firstCardWithSymbol);
        // obtengo el symbolo de referencia
        String CardSymboloRef = firstCardWithSymbol.getCardSymbol().getNombreSymbolo();

        Carta cartaRef;
        // Crearemos este arrayAuxiliar para comparar si tiene la misma longitud que arrayListComprobarJugada
        // si tiene la misma longitud implica que la jugada Escalera es valida.
        ArrayList<Carta> arrayAuxiliar = new ArrayList<>();
        // si introduce [1,2,3,4,5,6,7,8,9,10,11,12,13] se mira el orden de forma ASCENDENTE
        final int TOTAL_CARDS = 13;

        if (isNumber13And1() && (TOTAL_CARDS != arrayListComprobarJugada.size())){
            // si introduce 12 cartas [2,3,4,5,6,7,8,9,10,11,12,13,1] se mira el orden de forma ASCENDENTE Dando una vuelta
            // en el ej de arriba si hubiera un 2 implica que no hay un 3

            int[] numeroEscalera1rVuelta = new int[] {3,4,5,6,7,8,9,10,11,12,13};

            int indiceNumeroEscalera1rVuelta = 0;


            // primero tengo que ver en que indice empiezo a hacer la comparacion
            // es decir, si mi escalera empieza con el numero 10, tengo que coger
            // el indice 7 del Array numeroEscalera1rVuelta
            indiceNumeroEscalera1rVuelta = getIndiceNumeroEscalera1rVuelta(numeroEscalera1rVuelta, empiezaEscaleraNumero, indiceNumeroEscalera1rVuelta);

            for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
                cartaRef = arrayListComprobarJugada.get(i);
                // comprobamos que todas las Cartas tengan el mismo Symbolo
                if (!isSameSymbol(cartaRef, CardSymboloRef)) {
                    // si no tiene el mismo Symbolo y en esta Jugada habia un comodin
                    // tengo que restablecer el valor del Comodin.
                    if (isComodin) {
                        //  Si la jugada no es valida,
                        //  tengo que restablecer que el valor del comodin sea Cero y El Symbolo = Comodin
                        restablecerValorYSymboloComodin();
                    }
                    // como las cartas presentadas no tienen el mismo Symbolo
                    // tendre que indicar que la jugada no es validad y por lo tanto
                    // no se creara el objeto JugadaTupla
                    return jugadaValida = false;
                }

                // Aqui verifico que si la jugada de la escalera empieza con una carta de valor 10
                // tengo que verificar que hay las siguientes cartas: 10,11,12,13
                // TODO: 30/05/2024 AUN TENGO QUE MIRAR QUE ME ORDENE BIEN
                // System.out.println("Lo de abajo funciona ? "); // parece que funciona
                if (isSameNumber(cartaRef, numeroEscalera1rVuelta[indiceNumeroEscalera1rVuelta])) {
                    // implica que tienen el mismo valor y añado la carta a un arrayAuxiliar
                    // que lo usare mas adelante para comparar si el arrayAuxiliar y arrayListComprobarJugada
                    // tienen el mismo tamaño
                    arrayAuxiliar.add(cartaRef);
                    // incremento en uno para pasar del valor 10 al 11
                    indiceNumeroEscalera1rVuelta++;

                    if (isFinish1rVuelta(indiceNumeroEscalera1rVuelta, numeroEscalera1rVuelta)) {
                        // cuando pase del 13 al 14
                        // implica que empezamos a hacer la comparativa con el numeroEscalera2nVuelta
                        break;
                    }
                } else {
                    if (isComodin) {
                        //  Si la jugada no es valida,
                        //  tengo que restablecer que el valor del comodin sea Cero
                        restablecerValorYSymboloComodin();
                    }
                    return jugadaValida = false;

                }

            }

            int[] numeroEscalera2nVuelta = new int[] {1,2,3,4,5,6,7,8,9,10,11};
            int indice2nVuelta = 0;
            //  método para saber donde esta el elemento que tiene valor 1 en el arrayListComprobarJugada
            int indiceArrayListComprobarJugadaConValorUno = getIndiceArrayListComprobarJugadaConValorUno();

            for (int i = indiceArrayListComprobarJugadaConValorUno; i < numeroEscalera2nVuelta.length; i++) {
                if (isOutSideArrayList(i)){
                    break;
                }
                cartaRef = arrayListComprobarJugada.get(i);
                // comprobamos que todas las Cartas tengan el mismo Symbolo
                if (!isSameSymbol(cartaRef, CardSymboloRef)){
                    // si no tiene el mismo Symbolo y en esta Jugada habia un comodin
                    // tengo que restablecer el valor del Comodin.
                    if (isComodin){
                        //  Si la jugada no es valida,
                        //  tengo que restablecer que el valor del comodin sea Cero y El Symbolo = Comodin
                        restablecerValorYSymboloComodin();
                    }
                    // como las cartas presentadas no tienen el mismo Symbolo
                    // tendre que indicar que la jugada no es validad y por lo tanto
                    // no se creara el objeto JugadaTupla
                    return jugadaValida = false;
                }

                if (isSameNumber(cartaRef, numeroEscalera2nVuelta[indice2nVuelta])){
                    arrayAuxiliar.add(cartaRef);
                    indice2nVuelta++;
                }
                else {
                    break;
                }

            }


            if (arrayAuxiliar.size() != arrayListComprobarJugada.size()){
                // Has introducido una escalera de 1,2,4 se te ha olvidado el elemento 3
                if (isComodin){
                    //  Si la jugada no es valida,
                    //  tengo que restablecer que el valor del comodin sea Cero
                    restablecerValorYSymboloComodin();
                }
                return jugadaValida = false;

            }else {
                return jugadaValida;
            }

        }


        // poner la logica si la escalera no tuviera las cartas 13 y 1 para comprobar si dicha jugada es valida.

        int[] numeroEscalera = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13};

        // necesito obtener un metodo para saber en que posisicion del array numeroEscalera tengo que empezar
        int indiceNumeroEscalera = getIndiceNumeroEscalera(numeroEscalera);

        //  En teoria el arrayListComprobarJugada esta ordenado
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaRef = arrayListComprobarJugada.get(i);
            // comprobamos que todas las Cartas tengan el mismo Symbolo
            if (!isSameSymbol(cartaRef, CardSymboloRef)){
                // si no tiene el mismo Symbolo y en esta Jugada habia un comodin
                // tengo que restablecer el valor del Comodin.
                if (isComodin){
                    //  Si la jugada no es valida,
                    //  tengo que restablecer que el valor del comodin sea Cero y El Symbolo = Comodin
                    restablecerValorYSymboloComodin();
                }
                // como las cartas presentadas no tienen el mismo Symbolo
                // tendre que indicar que la jugada no es validad y por lo tanto
                // no se creara el objeto JugadaTupla
                return jugadaValida = false;
            }

            if (isSameNumber(cartaRef, numeroEscalera[indiceNumeroEscalera])){
                arrayAuxiliar.add(cartaRef);
                indiceNumeroEscalera++;
            }
            else {
                break;
            }

        }

        System.out.println("Comprobacion");

        if (arrayAuxiliar.size() != arrayListComprobarJugada.size()){
            // se actica cuando por ejemplo Has introducido una escalera de 1,2,4 se te ha olvidado el elemento 3
            if (isComodin){
                //  Si la jugada no es valida,
                //  tengo que restablecer que el valor del comodin sea Cero
                restablecerValorYSymboloComodin();
            }
            return jugadaValida = false;

        }else {
            return jugadaValida;
        }






    }



    private static boolean isFinish1rVuelta(int indiceNumeroEscalera1rVuelta, int[] numeroEscalera1rVuelta) {
        return indiceNumeroEscalera1rVuelta > numeroEscalera1rVuelta.length - 1;
    }

    private int getIndiceNumeroEscalera(int[] numeroEscalera) {
        int indiceNumeroEscalera = 0;
        int numeroEmpiezaEscalera = arrayListComprobarJugada.get(0).getCardNumber().getValor();

        for (int i = 0; i < numeroEscalera.length; i++) {
            if (numeroEmpiezaEscalera == numeroEscalera[i]){
                indiceNumeroEscalera = i;
                break;
            }
        }
        return indiceNumeroEscalera;
    }

    private static boolean isSameNumber(Carta cartaRef, int numeroEscalera) {
        // si 5 = 5 la igualda es TRUE
        // si 3 = 3 esta es FALSE
        // comparo la carta de referencia con el numero de la escalera
        return numeroEscalera == cartaRef.getCardNumber().getValor();

    }



    private static boolean isSameSymbol(Carta cartaRef, String CardSymboloRef) {
        return cartaRef.getCardSymbol().getNombreSymbolo().equals(CardSymboloRef);
    }

    private boolean isOutSideArrayList(int i) {
        return i == arrayListComprobarJugada.size();
    }

    private int getIndiceArrayListComprobarJugadaConValorUno( ) {
        int indiceArrayListComprobarJugadaConValorUno = 0;
        final int BUSCAMOS_CARTA_VALOR_1 = 1;
        int auxiliarCardValue;
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            auxiliarCardValue = arrayListComprobarJugada.get(i).getCardNumber().getValor();
            if ( BUSCAMOS_CARTA_VALOR_1 == auxiliarCardValue){
                indiceArrayListComprobarJugadaConValorUno = i;
                break;
            }
        }
        return indiceArrayListComprobarJugadaConValorUno;
    }

    private static int getIndiceNumeroEscalera1rVuelta(int[] numeroEscalera1rVuelta, int empiezaEscaleraNumero, int indiceNumeroEscalera1rVuelta) {
        for (int i = 0; i < numeroEscalera1rVuelta.length; i++) {
            if (numeroEscalera1rVuelta[i] == empiezaEscaleraNumero){
                indiceNumeroEscalera1rVuelta = i;
                // System.out.println("He cogido bien el indice?"); // funciona
                break;
            }
        }
        return indiceNumeroEscalera1rVuelta;
    }

    private void establecerSymboloComodin(int numComodines, int[] arrayPosicionComodin){

        // Primero tengo que buscar una carta que no sea Comodin para coger la Ref del Symbolo
        String cartaSymboloRef;
        final String SYMBOLO_COMODIN = "COMODIN";
        int posicionCartaNoComodin = 0;
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaSymboloRef = arrayListComprobarJugada.get(i).getCardSymbol().getNombreSymbolo();
            if (SYMBOLO_COMODIN.equals(cartaSymboloRef)){
                // Si la carta es un comodin continua;
                continue;
            }else {
                // Cuando obtenga la primera carta que no sea comodin sal del bucle, guardando el indice de dicha carta
                posicionCartaNoComodin = i;
                break;
            }
        }

        // Segundo cogemos el symbolo de la carta
        CardSymbol symboloRef = arrayListComprobarJugada.get(posicionCartaNoComodin).getCardSymbol();

        // Tercero establecer a cada Comodin el Symbolo de Referenciua
        Carta cartaComodin;
        for (int indiceComodin = 0; indiceComodin < numComodines; indiceComodin++) {
            arrayListComprobarJugada.get(arrayPosicionComodin[indiceComodin]).setCardSymbol(symboloRef);
        }

        // Borrar lo siguiente, solo quiero ver si se han puesto el Symbolo correctmente al comodin
        System.out.println();
        System.out.println("solo quiero ver si se han puesto el Symbolo correctmente al comodin");
        verCartasArrayListComprobarJugada();
        System.out.println();

    }
    private Carta getSymbolCartaWithNoComodin(boolean isComodin) {
        Carta firstCardWithSymbol;
        int posicion;

        if (isComodin){
            // que pasa si el comodin esta en la posicion cero --> Resuelto
            // que pasa si el comodin esta en segunda posicion --> Resuelto
            posicion = obtenerSymboloJugadaEscaleraDescartandoComodin();
            firstCardWithSymbol = arrayListComprobarJugada.get(posicion);

        }else {
            firstCardWithSymbol = arrayListComprobarJugada.get(0);
        }
        return firstCardWithSymbol;
    }

    public int obtenerSymboloJugadaEscaleraDescartandoComodin(){
        // recuerda que solo hay 2 comodines y se tienen que pasar de forma obligatoria 3 cartas
        int posicion = 1;
        Carta cartaWithSymbol;
        final String BUSCAR_COMODIN = "COMODIN";

        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaWithSymbol = arrayListComprobarJugada.get(i);
            if (!isSameSymbol(cartaWithSymbol, BUSCAR_COMODIN)){
                 posicion = i;
                 break;
            }
        }
        return posicion;
    }

    private void establecerValorYSymboloComodin(boolean isComodin) {
        if (isComodin){
            // tengo que comprobar cuantos comodines ha metido
            int numeroComodines = numComodinesIntroducidos();

            // mirar en que posicion estan los comodines
            int [] arrayPosicionComodin  = posicionComodin(numeroComodines);
            // Enseñar las cartas que ha presentado
            System.out.println();
            System.out.println("Estas son las cartas que has presentado");
            verCartasArrayListComprobarJugada();
            // preguntar que valor tiene Cada comodin
            System.out.println();
            System.out.println("Dime que valor le quieres dar a cada Comodin");


            // preguntar al Usuario que valor quiere darle a las cartas
            int [] valoresComodinA = presentacion.preguntarUsuarioValoresComodin(numeroComodines, arrayPosicionComodin);

            //asignar esos valores que ha dado el usuario al comodin


            // TODO: 06/06/2024 PROBLEMA: Si más de 1 comodin me asigna el mismo valor, por que?
            asginarValoresComodin(numeroComodines, arrayPosicionComodin, valoresComodinA);

            establecerSymboloComodin(numeroComodines, arrayPosicionComodin);

        }
    }

    private void restablecerValorYSymboloComodin(){
        String colorCarta;
        final String BUCAR_COMODIN_COLOR = "verde";

        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            colorCarta = arrayListComprobarJugada.get(i).getCardSymbol().getColor();
            if (BUCAR_COMODIN_COLOR.equals(colorCarta)){
                arrayListComprobarJugada.get(i).getCardNumber().resetValorComodin();
                arrayListComprobarJugada.get(i).getCardSymbol().resetSymboloComodin();
            }
        }
        // Borrar, solo quiero ver que valor le ha dado a las cartas
        verCartasArrayListComprobarJugada();
        System.out.println("Se acabaja de resetear el valor del comodin a cero");
        System.out.println("Se acabaja de resetear el Symbolo del comodin a COMODIN");
    }

    private void asginarValoresComodin(int numeroComodines, int [] arrayPosicionComodin, int [] valoresComodinA){
        Carta cartaRef;

        int numeroIntCardNumber;
        int indiceDondeEstaComodin;
        // Con este foreach soluciono el problema para el método asginarValoresComodin
        for (CardNumber numeroParaPonerSet : CardNumber.values()) {
            numeroIntCardNumber = numeroParaPonerSet.getValor();
            for (int i = 0; i <valoresComodinA.length ; i++) {
                if (numeroIntCardNumber == valoresComodinA[i]){
                    // Cogemos el numeroParaPonerSet
                    indiceDondeEstaComodin = arrayPosicionComodin[i];
                    arrayListComprobarJugada.get(indiceDondeEstaComodin).setCardNumber(numeroParaPonerSet);
                    System.out.println(numeroIntCardNumber);
                }
            }
        }

        // Borrar lo siguiente, solo quiero ver si se han puesto los valores correctmente al comodin
        System.out.println();
        System.out.println("solo quiero ver si se han puesto los valores correctmente al comodin");
        verCartasArrayListComprobarJugada();
        System.out.println();

    }

    private void verCartasArrayListComprobarJugada() {
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            Carta cartaRef = arrayListComprobarJugada.get(i);

            System.out.println(cartaRef.getCardNumber().getValor() + " " + cartaRef.getCardSymbol().getNombreSymbolo());
        }
    }

    private int[] posicionComodin(int numeroComodines){
        int [] posicion =  new int[numeroComodines];
        int contadorArray = 0;

        final int VALOR_COMODIN = 0;
        int valorCarta;
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            valorCarta = arrayListComprobarJugada.get(i).getCardNumber().getValor();
            if (VALOR_COMODIN == valorCarta){
                posicion[contadorArray] = i;
                contadorArray ++;
            }
        }
        return posicion;
    }

    private int numComodinesIntroducidos(){
        int numeroComodines = 0;
        final int VALOR_COMODIN = 0;
        int valorCarta;
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            valorCarta = arrayListComprobarJugada.get(i).getCardNumber().getValor();
            if (VALOR_COMODIN == valorCarta){
                numeroComodines++;
            }
        }
        return numeroComodines;
    }

    public void sortCardsByValue(){
        final int NUM_MIN_ESCALERA = 1;
        final int NUM_MAX_ESCALERA = 13;

        // tenemos que crear un ArrayList auxiliar donde pondremos las cartas ordenadas
        ArrayList<Carta> arrayListToSortCard = new ArrayList<>();

        int valorCarta;

        Carta cartaOrdenada;

        //  se puede poner las Cartas J, K, UNO
            // En teoria si, si quiero hacer la logica de dar la vuelta lo que tengo que mirar si hay las siguientes combinanciones
                // hay un 13 y un 1
        //  Crear un metodo booleano para ver si hay la carta 13 y 1
        boolean ordenarDandoVuelta = isNumber13And1();
        if (ordenarDandoVuelta){
            //  Ordenar de forma especial si hay la carta 13 y 1
            // Coger el 13 y ver el ultimo elemento que que continua
            int escaleraEmpieza = encontrarInicioEscalera();

            // Otra opcion de ordenarlo es con 2 FOR. Uno que mire el elemento actual y otro
            //  mirando el elemento mas grande

            for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
                valorCarta = arrayListComprobarJugada.get(i).getCardNumber().getValor();
                if (escaleraEmpieza == valorCarta){
                    cartaOrdenada = arrayListComprobarJugada.get(i);
                    arrayListToSortCard.add(cartaOrdenada);
                    escaleraEmpieza ++;
                    arrayListComprobarJugada.remove(i);
                    i=-1;
                    if (escaleraEmpieza == 14){
                        break;
                    }
                }
            }


            // ordenar las cartas cartas del 1 hacia adelante
            ordenarCartas1al13(NUM_MIN_ESCALERA, NUM_MAX_ESCALERA, arrayListToSortCard);
            System.out.println("Lo ordena bien?"); // NOOOOOO
            return;
        }

                // Recuerda que al comodin previamente ya le he asignado un valor
            // si no hay un 13 y 1 entonces se ordenena de la siguiente manera:
        ordenarCartas1al13(NUM_MIN_ESCALERA, NUM_MAX_ESCALERA, arrayListToSortCard);


    }

    private void ordenarCartas1al13(int NUM_MIN_ESCALERA, int NUM_MAX_ESCALERA, ArrayList<Carta> arrayListToSortCard) {
        int valorCarta;
        Carta cartaOrdenada;
        final int RESET = -1;
        for (int contadorEscalera = NUM_MIN_ESCALERA; contadorEscalera <= NUM_MAX_ESCALERA; contadorEscalera++) {
            for (int j = 0; j < arrayListComprobarJugada.size(); j++) {
                valorCarta = arrayListComprobarJugada.get(j).getCardNumber().getValor();
                if (contadorEscalera == valorCarta){
                    cartaOrdenada = arrayListComprobarJugada.get(j);
                    arrayListToSortCard.add(cartaOrdenada);
                    arrayListComprobarJugada.remove(j);
                    j = RESET ;

                }
            }
            if (arrayListComprobarJugada.isEmpty()){
                break;
            }
        }

        // finalmente pasamos las Cartas de foroma ordenada
        arrayListComprobarJugada = arrayListToSortCard;
    }

    private int encontrarInicioEscalera() {
        int escaleraEmpieza = 13;
        int cardValue;
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cardValue = arrayListComprobarJugada.get(i).getCardNumber().getValor();
            if (escaleraEmpieza == cardValue){
                escaleraEmpieza--;
                i = -1;
            }
        }
        // Si ha introducido mal la escalera, aqui ya habra un desajuste
        // que luego saltara la alarma en la comprobacion y dira que esta jugada no es valida
        escaleraEmpieza++;
        return escaleraEmpieza;
    }

    private boolean isNumber13And1(){
        boolean carta13 = false;
        boolean carta1 = false;
        int valorCarta = 0;

        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            valorCarta = arrayListComprobarJugada.get(i).getCardNumber().getValor();
            switch (valorCarta){
                case 1:
                    carta1 = true;
                    break;
                case 13:
                    carta13 = true;
                default:
                    continue;
            }

        }

        if (carta13 && carta1){
            return true;
        }

        return false;
    }

    private boolean IsThereComodin(){
        // Creo una carta Comodin
        Carta comodin = new Carta(CardSymbol.COMODIN, CardNumber.COMODIN);

        // como se puede borrar un objeto que he creado?
            // creo que se elimina de forma automatica.

        int valorComodin = comodin.getCardNumber().getValor();
        // Creo esta variable para ver las cartas que hay guardadas en el arrayListComprobarJugada
        Carta cartaRef;
        int cartaRefValor;

        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaRef = arrayListComprobarJugada.get(i);
            cartaRefValor = cartaRef.getCardNumber().getValor();
            if (valorComodin == cartaRefValor){

                return true;
            }
        }
        return false;

    }



    private boolean comprobarJugadaTupla(Jugador jugadorRef){
        // El jugador tiene que seleccionar que cartas quiere presentar para hacer la jugada Tupla
        elegirCartasToPlay(jugadorRef);


        // vemos que cartas se han introducido en el ArrayList --> arrayListComprobarJugada
            // luego borrar este FOR
        verCartasArrayListComprobarJugada();

        // hacer la logica para comprobarJugadaTupla
        boolean jugadaValida = logicaJugadaTupla();
        return jugadaValida;

    }

    private void returnCardToPlayerAndResetArrayListComprobarJugada(Jugador jugadorRef){
        Carta cartaRef;
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaRef = arrayListComprobarJugada.get(i);
            jugadorRef.addCardMazo(cartaRef);
        }
        // finalmente eliminar todas las cartas que tengo guardada en el arrayListComprobarJugada
        resetArrayListComprobarJugada();
    }

    private void createClassTuplaAndResetArrayListComprobarJugada(){
        int numeroTupla = arrayListComprobarJugada.get(0).getCardNumber().getValor();
        Carta cartaRef;
        JugadaTupla jugadaTupla = new JugadaTupla(numeroTupla);
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaRef = arrayListComprobarJugada.get(i);
            jugadaTupla.addCard(cartaRef);
        }
        // añadir este objeto creado Tupla a un ArrayList que sea padre de la clase Tupla
        jugadasArrayList.add(jugadaTupla);
        // finalmente eliminar todas las cartas que tengo guardada en el arrayListComprobarJugada
        resetArrayListComprobarJugada();
    }

    private void createClassEscaleraAndResetArrayListComprbarJugada(){
        String symbolo = arrayListComprobarJugada.get(0).getCardSymbol().getNombreSymbolo();
        Carta cartaRef;
        JugadaEscalera jugadaEscalera = new JugadaEscalera();

        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaRef = arrayListComprobarJugada.get(i);
            jugadaEscalera.addCard(cartaRef);
        }
        // añadir este objeto creado Tupla a un ArrayList que sea padre de la clase Tupla
        jugadasArrayList.add(jugadaEscalera);
        // finalmente eliminar todas las cartas que tengo guardada en el arrayListComprobarJugada
        resetArrayListComprobarJugada();
    }

    private void resetArrayListComprobarJugada() {
        for (int i = arrayListComprobarJugada.size() -1 ; i >= 0; i--) {
            arrayListComprobarJugada.remove(i);
        }
    }

    private boolean logicaJugadaTupla(){
        boolean jugadaValida = true;
        Carta cartaTupla = arrayListComprobarJugada.get(0);
        Carta cartaRef;
        int CardNumberRef = cartaTupla.getCardNumber().getValor();

        final int VALORCOMODIN = 0;

        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            cartaRef = arrayListComprobarJugada.get(i);
            if (VALORCOMODIN == cartaRef.getCardNumber().getValor()){
                continue;
            }
            if (cartaRef.getCardNumber().getValor() != CardNumberRef){
                return jugadaValida = false;
            }
        }
        return jugadaValida;


    }

    private void elegirCartasToPlay(Jugador jugadorRef){

        int numeroCarta = presentacion.numberCardToPlay(jugadorRef);
        // creamos un Array para guardar las posiciones de las cartas que el jugador quiere presentar
        int[] indiceCarta = new int[numeroCarta];
        indiceCarta = obtenerIndiceCarta(jugadorRef, numeroCarta);

        // Recorrer el Array indiceCarta para obtener las cartas que necesito del Jugador
        // y añadirlo al arrayListComprobarJugada
        int getIndice;
        // primero copiamos y luego borramos
            // copiar
        for (int i = 0; i < indiceCarta.length ; i++) {
            // ponemos menos 1 porque una cosa es la longitud del array y otra la posicion
            getIndice = indiceCarta[i] -1 ;

            Carta cartaRef = jugadorRef.getMazoCartas().get(getIndice);
            arrayListComprobarJugada.add(cartaRef);
        }

        // antes de eliminar tengo que ordenar indiceCarta de forma DESCENDIENTE
        // si no lo hago, cuando si mi array tiene una longitud de 30 y borro el elemento 5
        // y luego quiero borrar el elemento 30 no podre porque ahora el array tiene
        // una longitud de 29
         int [] indiceCartaOrdenadoDescendiente = ordenarFormaDescendiente(indiceCarta);


        // ahora borramos de esta forma no modificamos el orden de las cartas que tiene guardado el jugador en el mazo
        for (int i = 0; i < indiceCartaOrdenadoDescendiente.length ; i++) {

            // ponemos menos 1 porque una cosa es la longitud del array y otra la posicion
            getIndice = indiceCartaOrdenadoDescendiente[i] -1 ;
            jugadorRef.getMazoCartas().remove(getIndice);
        }

    }

    private int[] ordenarFormaDescendiente(int [] indiceCarta){
        int elementoActual;
        int numComparar;
        int auxiliar;

        for (int i = 0; i < indiceCarta.length; i++) {
            for (int j = i + 1 ; j < indiceCarta.length; j++) {
                elementoActual = indiceCarta[i];
                numComparar = indiceCarta[j];
                if (elementoActual < numComparar){
                    auxiliar = elementoActual;
                    indiceCarta[i] = numComparar;
                    indiceCarta[j] = auxiliar;

                }
            }
        }

        return indiceCarta;
    }


    private int[] obtenerIndiceCarta(Jugador jugadorRef, int numCartas){
        int[] numeroIndiceCarta = new int[numCartas];

        for (int i = 0; i < numCartas; i++) {
            presentacion.verCartaJugador(jugadorRef);
            numeroIndiceCarta[i] = presentacion.askIndiceCarta(jugadorRef, i, numCartas );
        }
        return numeroIndiceCarta;
    }

    private void crearJugadaEscalera(MazoCartas mazoCartas1, Jugador jugadorRef){

        int contador = 0;
        int total = CardNumber.values().length;
        for (CardNumber numero: CardNumber.values()) {
            // Con este if evitamos que se añada el Comodin
            if ( contador == total -1 ){
                break;
            }
            Carta newCardEscalera = new Carta(CardSymbol.PICAS, numero);
            // añadir la carta al mazo es innecesario
            mazoCartas1.addCarta(newCardEscalera);
            jugadorRef.addCardMazo(newCardEscalera);
            contador ++;
        }

    }

    private void crearJugadaTupla(MazoCartas mazoCartas1, Jugador jugadorRef){
        int contador = 0;
        int total = CardSymbol.values().length;

        for (CardSymbol simbolo: CardSymbol.values()) {
            if (contador < total - 1){
                // añadir la carta al mazo es innecesario
                Carta newCardTupla = new Carta(simbolo, CardNumber.CINCO);
                mazoCartas1.addCarta(newCardTupla);
                jugadorRef.addCardMazo(newCardTupla);
                contador ++;
            }else {
                // Tengo que crear el comodin con Valor 0
                Carta newCardTupla = new Carta(simbolo, CardNumber.COMODIN);
                // añadir la carta al mazo es innecesario
                mazoCartas1.addCarta(newCardTupla);
                jugadorRef.addCardMazo(newCardTupla);
            }



        }

    }

    private void obtenerCartaAdicional(MazoCartas mazoCartasRef, Jugador jugadorRef){
        Carta cartaRef = mazoCartasRef.getCogerUltimaCarta();
        jugadorRef.addCardMazo(cartaRef);
    }

    public int changeTurno(int anteriorTurno){
        // Cuantos jugadores tenemos
        int totalJugadores = numJugadores();

        int turno = anteriorTurno;

        if (turno == totalJugadores){
            turno = turno % totalJugadores;
        }

        turno ++;
        return turno;


    }



    public void repartirCartas(MazoCartas mazoCartasRef ) {

        // Cuantos jugadores tenemos
        int totalJugadores = numJugadores();
        // Cartas a repartir 14 * jugador
        final int CARTAS_REPARTIR = 14;
        int cartaTotalRepartir = totalJugadores * CARTAS_REPARTIR;

        // piensa que todas las variables que estan dentro del for se reinician cuando termnina el bucle
        // por lo tanto si pongo turno = 0 dentro del bucle, siempre turno valdra cero.
        // por eso hay que sacarlo fuera del bucle
        int turno = 0;

        for (int i = 0; i < cartaTotalRepartir; i++) {
            Carta cartaRef = mazoCartasRef.getCogerUltimaCarta();
            // definimos el turno

            if (turno == totalJugadores){
                 turno = turno % totalJugadores;
            }

             Jugador jugadorRef = listaJugadores.get(turno);
             jugadorRef.addCardMazo(cartaRef);
             turno ++;

        }

    }

    private void createAllCard(MazoCartas mazoCartasRef){
        final int MAX_COMODIN = 2;
        final int CREAR_2_MAZOS = 2;
        // Crear las cartas sin Comodin
        crearCards1to13(mazoCartasRef, CREAR_2_MAZOS);

        createAllComodinCard(mazoCartasRef, MAX_COMODIN);

    }

    private void crearCards1to13(MazoCartas mazoCartasRef, int CREAR_2_MAZOS) {
        for (int i = 0; i < CREAR_2_MAZOS; i++) {
            // FOR para recorrer un ENUM
            for (CardSymbol symbol : CardSymbol.values()) {
                for (CardNumber number : CardNumber.values()) {
                    if (isComodinCard(symbol, number)) {
                        continue;
                    }
                    Carta carta1al13 = new Carta(symbol, number);
                    mazoCartasRef.addCarta(carta1al13);
                }
            }
        }
    }

    private void createAllComodinCard(MazoCartas mazoCartasRef, int MAX_COMODIN) {
        for (int j = 0; j < MAX_COMODIN; j++) {
            Carta cartaComodin = new Carta(CardSymbol.COMODIN, CardNumber.COMODIN);
            mazoCartasRef.addCarta(cartaComodin);
        }

    }

    private static boolean isComodinCard(CardSymbol symbol, CardNumber number) {
        return (symbol == CardSymbol.COMODIN) || (number == CardNumber.COMODIN);
    }


    public int numJugadores(){
        // Cuantos jugadores tenemos
        return listaJugadores.size();
    }

    private void addPlayertolistJugadore(Jugador player1, Jugador player2) {
        // cuando creemos los jugadores hare un for que introduzca el jugador en este arrayList
        this.listaJugadores.add(player1);
        this.listaJugadores.add(player2);
    }

}
