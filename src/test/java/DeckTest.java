import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.mojujo.projektarbete.card.Card;
import se.mojujo.projektarbete.card.CardProvider;
import se.mojujo.projektarbete.card.Deck;

public class DeckTest {

    @Test
    public void testDeck() {
        Deck deck = new Deck();

        assertEquals(52, deck.remainingCards());
    }

    @Test
    public void testShuffle() {
        CardProvider deck = new Deck();
        Card card = deck.dealCard();

        assertNotEquals("Ace of Clubs", card.toString());
    }
}
