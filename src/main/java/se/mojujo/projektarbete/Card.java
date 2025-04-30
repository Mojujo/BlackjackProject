package se.mojujo.projektarbete;

public class Card {
    private final String cardSuit;
    private final String cardValue;

    public Card(String cardSuit, String cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return cardValue + " of " + cardSuit;
    }
}
