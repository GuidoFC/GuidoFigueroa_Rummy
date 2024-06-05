package RummyKub.Modelo;

public enum CardSymbol {
    // como es una constante siempre va en mayuscula
    CORAZON_ROJO("CORAZON_ROJO", '\u2665', "rojo"),
    DIAMANTE("DIAMANTE", '\u2666', "rojo"),
    TREBOL("TREBOL", '\u2663', "negro"),
    PICAS("PICAS", '\u2660', "negro"),
    COMODIN("COMODIN",'\u263A', "verde");

    // se pone los atributos del enum
    private String nombreSymbolo;
    private char numeroChar;
    private String color;


    // se crea el constructor del enum.
    // este contructor siempre es private

    private CardSymbol(String nombreSymbolo, char numeroChar, String color){
        this.nombreSymbolo = nombreSymbolo;
        this.numeroChar = numeroChar;
        this.color = color;
    }
    // Creamos un constructor para hacer la clonacion
    private CardSymbol(CardSymbol other) {
        this.nombreSymbolo = other.nombreSymbolo;
        this.numeroChar = other.numeroChar;
        this.color = other.color;
    }

    // se crea los getter y setter del constructor
    public String getColor(){
        return this.color;
    }

    public String getNombreSymbolo(){
        return this.nombreSymbolo;
    }

    public char getNumeroChar(){
        return (char)(this.numeroChar);
    }

    public void setNombreSymbolo(String nombreSymbolo) {
        this.nombreSymbolo = nombreSymbolo;
    }
    public void resetSymboloComodin(){
        // se podria hacer de alguna manera Para que las otras Cartas que no sean Comodin
        // no se vean afectadas por este método?
        this.nombreSymbolo = "COMODIN";
    }

    // Método estático para obtener el CardSymbol a partir de un char
    public static CardSymbol valueOf(char numeroChar) {
        for (CardSymbol symbol : CardSymbol.values()) {
            if (symbol.numeroChar == numeroChar) {
                return symbol;
            }
        }
        throw new IllegalArgumentException("No se encontró el símbolo para el carácter: " + numeroChar);
    }

    public String toJson() {
        return "\"" + this.name() + "\"";
    }

}
