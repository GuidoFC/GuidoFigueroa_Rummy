package RummyKub.Modelo;

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

    @Override
    public String toString() {
        return "{" +
                "\"cardNumber\":" + cardNumber.toJson() +
                ", \"cardSymbol\":" + cardSymbol.toJson() +
                '}';
    }

    public void setCardNumberAndCardSymbol(CardNumber cardNumber, CardSymbol cardSymbol) {
        this.cardNumber = cardNumber;
        this.cardSymbol = cardSymbol;
    }

    public void setCardSymbol(CardSymbol cardSymbol) {
        this.cardSymbol = cardSymbol;
    }
}
