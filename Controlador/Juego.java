package Controlador;

import Modelo.*;
import Vista.Print;

import java.util.ArrayList;

public class Juego {

    Print presentacion = new Print();
    private static int turno;

    private ArrayList<Carta> arrayListComprobarJugada = new ArrayList<>();

    ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public Juego(Jugador player1, Jugador player2){

        turno = 0;

        // primero creamos un objeto de la clase BarajaCarta que es donde guardaremos las cartas
        MazoCartas mazoCartas1 = new MazoCartas();
        // segundo vamos a crear las cartas y las guardamos en el objeto que hemos creado
        createAllCard(mazoCartas1);

        // Vemos las cartas
        // this.presentacion.verTodasLasCartas(mazoCartas1);

        // barajamos las cartas
        mazoCartas1.barajarCartas();
        // vemos las cartas barajadas
        this.presentacion.verTodasLasCartas(mazoCartas1);

        // añadimos los jugadores en el arraylist
        this.listaJugadores.add(player1);
        this.listaJugadores.add(player2);

        // ahora quiero hacer un método para repartir las cartas para cada jugador
        repartirCartas(mazoCartas1);

        // ahora quiero ver las cartas que tiene cada jugador
        presentacion.verCartaJugador(player1);
        presentacion.verCartaJugador(player2);

        // Vemos las cartas del jugador que le toca ahora
        System.out.println();
        System.out.println("Vemos las cartas del turno " + turno);
        Jugador jugadorRef = listaJugadores.get(turno);




        // ahora quiero poner la logica entre si el jugador
        // tiene una jugada o tiene que coger carta
        // primer comit
        int eleccion = 0;
        do {
            eleccion = presentacion.chooseDecisionPlayer(jugadorRef);
        }while (eleccion == 0);
        System.out.println(eleccion);

//        Elija una de las siguientes opciones:
//        1) Coger Carta del Deck
//        2) Tengo una jugada
        switch (eleccion){
            case 1: //        1) Coger Carta del Deck
                obtenerCartaAdicional(mazoCartas1, jugadorRef);
                presentacion.verCartaJugador(jugadorRef);
                turno = changeTurno(turno);
                break;
            case 2: //        2) Tengo una jugada
                // vamos a elaborar la logica del juego
                // para ver si el jugador tiene una tupla o escalera
                // crearme un método para añadir de forma artificial una Tupla
                crearJugadaTupla(mazoCartas1, jugadorRef);
                // crearme un método para añadir de forma artificial una Escalera
                // tener en cuenta el Joker

                // vemos si se ha añadido correctamente las cartas
                presentacion.verCartaJugador(jugadorRef);


                int Elegir_Escalera_Tupla = 0;
                do {
                    Elegir_Escalera_Tupla  = presentacion.chooseBetweenTuplaOrEscalera();
                }while (Elegir_Escalera_Tupla == 0);

                switch (Elegir_Escalera_Tupla){
                    case 1:
                        // primero comprobar y luego crear el objeto
                        // entonces solo me centraria si el nuevo elemento que se quiere
                        // introducir pertenece a la misma tupla
                        comprobarJugadaTupla(jugadorRef);



                        break;
                    case 2: // jugada escalera
                        break;
                }

                // le toca al siguiente jugador
                turno = changeTurno(turno);
                break;
        }


    }

    private void comprobarJugadaTupla(Jugador jugadorRef){
        // El jugador tiene que seleccionar que cartas quiere presentar para hacer la jugada Tupla
        elegirCartasToPlay(jugadorRef);


        // vemos que cartas se han introducido en el ArrayList --> arrayListComprobarJugada
        for (int i = 0; i < arrayListComprobarJugada.size(); i++) {
            Carta cartaRef = arrayListComprobarJugada.get(i);

            System.out.println(cartaRef.getCardNumber().getValor() + " " + cartaRef.getCardSymbol().getNombre());
        }

        // hacer la logica para comprobarJugadaTupla
        boolean jugadaValida = logicaJugadaTupla();

        // control de si la jugada es valida
        if (jugadaValida){
            System.out.println();
            System.out.println("La jugada es correcta");
        }else{
            System.out.println();
            System.out.println("Jugada no correcta");
        }

        // creamos el objeto JugadaTupla

        // finalmente eliminar todas las cartas  que tengo guardada en el arrayListComprobarJugada

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
        // ahora borramos de esta forma no modificamos el orden de las cartas que tiene guardado el jugador en el mazo
        for (int i = 0; i < indiceCarta.length ; i++) {
            // ponemos menos 1 porque una cosa es la longitud del array y otra la posicion
            getIndice = indiceCarta[i] -1 ;
            jugadorRef.getMazoCartas().remove(getIndice);
        }



    }

    private int[] obtenerIndiceCarta(Jugador jugadorRef, int indiceCarta){
        int[] numeroIndiceCarta = new int[indiceCarta];

        for (int i = 0; i < indiceCarta; i++) {
            numeroIndiceCarta[i] = presentacion.askIndiceCarta(jugadorRef, i, indiceCarta );
        }
        return numeroIndiceCarta;
    }

    private void crearJugadaTupla(MazoCartas mazoCartas1, Jugador jugadorRef){
        for (CardSymbol simbolo: CardSymbol.values()) {
            Carta newCardTupla = new Carta(simbolo, CardNumber.CINCO);
            // añadir la carta al mazo es innecesario
            mazoCartas1.addCarta(newCardTupla);
            jugadorRef.addCardMazo(newCardTupla);
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

}
