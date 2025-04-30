import org.junit.jupiter.api.Test;
import se.mojujo.projektarbete.Card;
import se.mojujo.projektarbete.Deck;
import se.mojujo.projektarbete.Player;
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
    void cardFaceValueTest() {
       Card Jack = new Card("Spades", "Jack");
       Card Queen = new Card("Clubs", "Queen");
       Card King = new Card("Diamonds", "King");

       assertEquals(10, Jack.getFaceValue());
       assertEquals(10, Queen.getFaceValue());
       assertEquals(10, King.getFaceValue());
    }

    @Test
    void cardAceValueTest() {
        Card Ace = new Card("Spades", "Ace");

        assertEquals(11, Ace.getFaceValue());
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



}
