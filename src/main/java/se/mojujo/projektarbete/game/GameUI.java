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
        logic.initialDeal();
        Player player = logic.getPlayer();
        Dealer dealer = logic.getDealer();

        System.out.println("Dealer's card: " + dealer.showFirstCard());

        while (!player.hasBlackJack() && !player.isBusted()) {
            System.out.println("Your hand: " + player);
            System.out.println("Hit or stand? ");
            String choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("hit")) {
                logic.playerHits();
                System.out.println("You got: " + player.getHand().getLast());
            } else if (choice.equals("stand")) {
                System.out.println("You have chosen to stand" + "\n");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        if (!player.isBusted()) {
            System.out.println("The dealer shows both cards");
            System.out.println("Dealer's cards: " + dealer + "\n");
            while (dealer.shouldHit()) {
                dealerTurnDelay();
            }
        }
        displayResults();
    }

    public void dealerTurnDelay() {
        try {
            Thread.sleep(1000);
            logic.dealerTurn();
            System.out.println("Dealer got: " + logic.getDealer().getHand().getLast());
            System.out.println("Dealer's cards: " + logic.getDealer());
            System.out.println();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printRules() {

    }

    public void displayResults() {
        System.out.println("-------------------------");
        System.out.println("Game over");
        System.out.println("Final hands:");
        System.out.println("Player: " + logic.getPlayer());
        System.out.println("Dealer: " + logic.getDealer());
        System.out.println(logic.determineWinner());
        System.out.println("-------------------------");
    }
}
