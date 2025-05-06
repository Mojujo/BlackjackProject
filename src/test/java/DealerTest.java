import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.mojujo.projektarbete.*;

import static org.junit.jupiter.api.Assertions.*;


public class DealerTest {

    private Dealer dealer;
    private Player player;
    private CardProvider deck;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player();
    }

    @Test
    void DealerDealCardsTest () {

        dealer.dealToPlayer(player);

        assertEquals(1, player.getHand().size());
        assertEquals(51, deck.remainingCards());

        dealer.dealToPlayer(dealer);


    }

    @Test
    void DealToDealerTest () {
        dealer.dealToDealer();

        assertTrue(dealer.getHandValue() >= 17);

    }

    @Test
    void shouldHitTest () {


        dealer.addCard(new Card("Spades", "Queen"));
        dealer.addCard(new Card("Hearts", "7"));





        assertFalse(dealer.shouldHit());
    }
}

