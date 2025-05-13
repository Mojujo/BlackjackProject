package se.mojujo.projektarbete.game;

import se.mojujo.projektarbete.model.Dealer;
import se.mojujo.projektarbete.model.Player;

public class GameUI {

    private final InputProvider input;
    private final GameLogic logic;

    public GameUI(InputProvider input, GameLogic logic) {
        this.input = input;
        this.logic = logic;
    }

    public void start() {
        Player player = logic.getPlayer();

        System.out.println("Dealer's card: " + logic.getDealer().showFirstCard());

        while (!player.hasBlackJack() && !player.isBusted()) {
            System.out.println("Your hand: " + player);
            System.out.println("Hit or stand? ");
            String choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("hit")) {
                logic.playerHits();
                System.out.println("You got: " + player.getHand().getLast());
            } else if (choice.equals("stand")) {
                System.out.println("You have chosen to stand");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        if (!player.isBusted()) {
            logic.dealerTurn();
        }
        displayResults();
    }

    public void printRules() {

    }

    public void displayResults() {
        System.out.println("Game over");
        System.out.println("Final hands:");
        System.out.println("player: " + logic.getPlayer());
        System.out.println("dealer: " + logic.getDealer());
        System.out.println(logic.determineWinner());
    }
}
