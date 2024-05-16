package Modelo;

public enum CardSymbol {
    // como es una constante siempre va en mayuscula
    CORAZON_ROJO("CORAZON_ROJO", '\u2665', "rojo"),
    DIAMANTE("DIAMANTE", '\u2666', "rojo"),
    TREBOL("TREBOL", '\u2663', "negro"),
    PICAS("PICAS", '\u2660', "negro"),
    COMODIN("COMODIN",'\u263A', "verde");

    // se pone los atributos del enum
    private String nombre;
    private char numeroChar;
    private String color;


    // se crea el constructor del enum.
    // este contructor siempre es private

    private CardSymbol(String nombre, char numeroChar, String color){
        this.nombre = nombre;
        this.numeroChar = numeroChar;
        this.color = color;
    }

    // se crea los getter y setter del constructor
    public String getColor(){
        return this.color;
    }

    public String getNombre(){
        return this.nombre;
    }

    public char getNumeroChar(){
        return (char)(this.numeroChar);
    }

}
