import org.junit.jupiter.api.Test;
import se.mojujo.projektarbete.Deck;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    void testDealCard() {
        Deck deck = new Deck();
        deck.dealCard();
        assertEquals(51, deck.remainingCards());
    }
}
