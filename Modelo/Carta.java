package Modelo;

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


}
