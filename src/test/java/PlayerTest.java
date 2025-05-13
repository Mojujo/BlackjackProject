import org.junit.jupiter.api.Test;
import se.mojujo.projektarbete.card.Card;
import se.mojujo.projektarbete.card.Deck;
import se.mojujo.projektarbete.model.Player;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void addCardTest() {
        Deck deck = new Deck();
        Player player = new Player();
        player.addCard(deck.dealCard());

        assertEquals(1, player.getHand().size());
    }

    @Test
    void handValueTest() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Queen"));

        assertEquals(20, player.getHandValue());
    }

    @Test
    void handAceValueTest() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Queen"));
        player.addCard(new Card("Diamonds", "Ace"));

        assertEquals(21, player.getHandValue());
    }

    @Test
    void isBustedTest() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Queen"));
        player.addCard(new Card("Diamonds", "King"));

        assertTrue(player.isBusted());
    }

    @Test
    void hasBlackJack() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Ace"));

        assertTrue(player.hasBlackJack());
    }
}
