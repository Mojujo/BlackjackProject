package se.mojujo.projektarbete;

public class Dealer extends Player {

    private final CardProvider deck;

    public Dealer(CardProvider deck) {
        this.deck = deck;
    }

    public void dealToPlayer(Player player) {
        player.addCard(deck.dealCard());

    }


}
