package Modelo;

public enum CardSymbol {
    // como es una constante siempre va en mayuscula
    CORAZON_ROJO("CORAZON_ROJO"),
    ROMBO("ROMBO"),
    CORAZON_NEGRO("CORAZON_NEGRO"),
    PICAS("PICAS"),
    COMODIN("COMODIN");

    private String nombre;

    private CardSymbol(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

}
