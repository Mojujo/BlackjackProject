package se.mojujo.projektarbete;

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
        }
    }

    public boolean shouldHit() {
        return (getHandValue() < 17);
    }

    public Card showFirstCard() {
        return getHand().getFirst();
    }


}
