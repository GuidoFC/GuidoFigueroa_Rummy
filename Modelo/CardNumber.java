package Modelo;

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

}
