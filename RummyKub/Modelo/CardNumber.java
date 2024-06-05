package RummyKub.Modelo;

public enum CardNumber {
    // NO SE PUEDE PONER NUMEROS
    UNO(1),
    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    OCHO(8),
    NUEVE(9),
    DIEZ(10),
    J(11),
    Q(12),
    K(13),
    COMODIN(0);

    private int valor;
    private CardNumber(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return this.valor;
    }


    public void setValorComodin(int newValor){
        this.valor = newValor;
    }

    public void resetValorComodin(){
        // se podria hacer de alguna manera Para que las otras Cartas que no sean Comodin
        // no se vean afectadas por este método?
        this.valor = 0;
    }

    public String toJson() {
        return String.valueOf(valor);
    }


}
