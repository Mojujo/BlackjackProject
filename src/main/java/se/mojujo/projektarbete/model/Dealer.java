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
        addCard(deck.dealCard());
    }

    public boolean shouldHit() {
        return (getHandValue() < 17);
    }

    public Card showFirstCard() {
        return getHand().getFirst();
    }
}
