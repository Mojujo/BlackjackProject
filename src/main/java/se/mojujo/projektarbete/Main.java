package se.mojujo.projektarbete;

import se.mojujo.projektarbete.card.CardProvider;
import se.mojujo.projektarbete.card.Deck;
import se.mojujo.projektarbete.game.GameLogic;
import se.mojujo.projektarbete.game.GameUI;
import se.mojujo.projektarbete.game.InputProvider;
import se.mojujo.projektarbete.game.TerminalInputProvider;
import se.mojujo.projektarbete.model.Dealer;
import se.mojujo.projektarbete.model.Player;

public class Main {
    public static void main(String[] args) {
        CardProvider deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer(deck);

        GameLogic logic = new GameLogic(deck, player, dealer);
        InputProvider input = new TerminalInputProvider();

        GameUI game = new GameUI(input, logic);
        game.start();
    }
}