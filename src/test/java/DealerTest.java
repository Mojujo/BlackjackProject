import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.mojujo.projektarbete.CardProvider;
import se.mojujo.projektarbete.Dealer;
import se.mojujo.projektarbete.Deck;
import se.mojujo.projektarbete.Player;

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
    void DealerDealCardsTest() {
        dealer.dealToPlayer(player);

        assertEquals(1, player.getHand().size());
        assertEquals(51, deck.remainingCards());
    }
}
