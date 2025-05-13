package se.mojujo.projektarbete.model;

import se.mojujo.projektarbete.card.Card;
import se.mojujo.projektarbete.card.CardProvider;

public class Dealer extends Player {

    private final CardProvider deck;

    public Dealer(CardProvider deck) {
        this.deck = deck;
    }

    public void dealToPlayer(Player player) {
        player.addCard(deck.dealCard());

    }

    public void dealToDealer () {
        while (getHandValue() < 17) {
            addCard(deck.dealCard());
            System.out.println("Dealer got: " + getHand().getLast());
        }
    }

    public boolean shouldHit() {
        return (getHandValue() < 17);
    }

    public Card showFirstCard() {
        return getHand().getFirst();
    }
}
