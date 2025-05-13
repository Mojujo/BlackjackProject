package se.mojujo.projektarbete.game;

import se.mojujo.projektarbete.card.CardProvider;
import se.mojujo.projektarbete.model.Dealer;
import se.mojujo.projektarbete.model.Player;

import java.util.Scanner;

public class GameLogic {


    private final CardProvider deck;
    private final Player player;
    private final Dealer dealer;

    public GameLogic(CardProvider deck, Player player, Dealer dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    public void initialDeal() {
        dealer.dealToPlayer(player);
        dealer.dealToPlayer(player);

        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    public void playerHits() {
        dealer.dealToPlayer(player);
    }

    public boolean isPlayerTurnOver(String choice) {
        return choice.equals("stand") || player.hasBlackJack() || player.isBusted();
    }

    public void dealerTurn() {
        System.out.println("Dealer's turn");
        dealer.dealToDealer();
        System.out.println("Dealer's hand: " + dealer);
    }

    public String determineWinner() {
        if (player.isBusted() || dealer.hasBlackJack()) {
            return ("Dealer Wins!");
        } else if (player.hasBlackJack() || dealer.isBusted() ) {
            return ("Player Wins!");
        } else if (dealer.getHandValue() < player.getHandValue()) {
            return ("Player Wins");
        } else if (dealer.getHandValue() > player.getHandValue()) {
            return ("Dealer Wins");
        }       else {
            return ("Its a tie!");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }
}
