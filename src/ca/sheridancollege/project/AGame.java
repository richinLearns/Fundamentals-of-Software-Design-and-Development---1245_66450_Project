/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author richi
 */
public class AGame extends Game {
    private APlayer player1;
    private APlayer player2;
    private GroupOfCards groupOfCards;
    private ScoreCalculator scoreCalculator;

    public AGame(String name, APlayer player1, APlayer player2, GroupOfCards groupOfCards) {
        super(name);
        this.player1 = player1;
        this.player2 = player2;
        this.groupOfCards = groupOfCards;
        this.scoreCalculator = new ScoreCalculator();
    }

    @Override
    public void play() {
        groupOfCards.shuffle();
        dealInitialCards();
        System.out.println("Starting the game...");

        while (!groupOfCards.isEmpty() && !anyPlayerHandEmpty()) {
            takeTurn(player1);
            takeTurn(player2);
        }

        int player1Score = scoreCalculator.calculateScore(player1);
        int player2Score = scoreCalculator.calculateScore(player2);

        System.out.println(player1.getName() + "'s score: " + player1Score);
        System.out.println(player2.getName() + "'s score: " + player2Score);

        declareWinner();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 7; i++) {
            player1.getHand().add(groupOfCards.drawCard());
            player2.getHand().add(groupOfCards.drawCard());
        }
    }

    private void takeTurn(APlayer player) {
        System.out.println(player.getName() + "'s turn. Hand: " + player.getHand());
        player.play();
    }

    private boolean anyPlayerHandEmpty() {
        return player1.getHand().isEmpty() || player2.getHand().isEmpty();
    }

    @Override
    public void declareWinner() {
        int player1Score = scoreCalculator.calculateScore(player1);
        int player2Score = scoreCalculator.calculateScore(player2);

        if (player1Score > player2Score) {
            System.out.println(player1.getName() + " wins!");
        } else if (player2Score > player1Score) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}