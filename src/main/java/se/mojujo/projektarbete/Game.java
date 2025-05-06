package se.mojujo.projektarbete;

import java.util.Scanner;

public class Game {


    private final Deck deck;
    private final Player player;
    private final Dealer dealer;

    public Game() {
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Dealer(deck);
    }


    public void start() {

        dealer.dealToPlayer(player);
        dealer.dealToPlayer(player);

        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        playTurn();


    }

    public void playTurn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dealer's card: " + dealer.showFirstCard());

        while (!player.hasBlackJack() && !player.isBusted()) {
            System.out.println("Your hand: " + player);
            System.out.println("Hit or stand? ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("hit")) {
                dealer.dealToPlayer(player);
                System.out.println("You got: " + player.getHand().getLast());
            } else if (choice.equals("stand")) {
                System.out.println("You have chosen to stand");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        if (!player.isBusted()) {
            dealerTurn();
        }

        displayResult();

    }

    public void dealerTurn() {
        System.out.println("Dealer's turn");
        dealer.dealToDealer();
        System.out.println("Dealer's hand: " + dealer);


    }

    public void displayResult() {
        System.out.println("Game over");
        System.out.println("Final hands:");
        System.out.println("player: " + player);
        System.out.println("dealer: " + dealer);
        if (player.isBusted() || dealer.hasBlackJack()) {
            System.out.println("Dealer wins!");
        } else if (player.hasBlackJack() || dealer.isBusted() ) {
            System.out.println("Player wins!");
        } else if (dealer.getHandValue() < player.getHandValue()) {
            System.out.println("Player wins!");
        } else if (dealer.getHandValue() > player.getHandValue()) {
            System.out.println("Dealer wins!");
        }       else {
            System.out.println("It's a tie!");
        }



    }

}
