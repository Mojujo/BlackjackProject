import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.mojujo.projektarbete.Card;
import se.mojujo.projektarbete.Deck;

public class DeckTest {

    @Test
    public void testDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.remainingCards());
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        Card card = deck.dealCard();
        assertNotEquals("Ace of Clubs", card.toString());

    }
}
