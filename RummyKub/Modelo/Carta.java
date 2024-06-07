package RummyKub.Modelo;

import java.util.Objects;

public class Carta {
    private CardNumber cardNumber;
    private CardSymbol cardSymbol;

    public Carta(CardSymbol cardSymbol, CardNumber cardNumber){
        this.cardNumber = cardNumber;
        this.cardSymbol = cardSymbol;
    }

    public CardNumber getCardNumber(){
        return this.cardNumber;
    }

    public CardSymbol getCardSymbol(){
        return this.cardSymbol;
    }

    public String toStringRepresentacion() {

        return "["+ cardNumber.getValor() + " " + cardSymbol.getNumeroChar() + "]";
    }

    public void setCardNumberAndCardSymbol(CardNumber cardNumber, CardSymbol cardSymbol) {
        this.cardNumber = cardNumber;
        this.cardSymbol = cardSymbol;
    }

    public void setCardSymbol(CardSymbol cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "cardNumber=" + cardNumber +
                ", cardSymbol=" + cardSymbol +
                '}';
    }

    // Para comprobar si 2 cartas son iguales

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return cardNumber == carta.cardNumber && cardSymbol == carta.cardSymbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardSymbol);
    }
}
