/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author richi
 */
import java.util.ArrayList;
public class AGame extends Game {
     private GroupOfCards deck;
    private ArrayList<APlayer> players;

    public AGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        players = new ArrayList<>();
    }

    public void shuffleAndDeal() {
        deck.shuffle();
        for (APlayer player : players) {
            player.getHand().addAll(deck.deal(7)); // Deal 7 cards to each player
        }
    }

    public void registerPlayer(APlayer player) {
        players.add(player);
    }

    @Override
    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            for (APlayer player : players) {
                player.play();
                if (isGameOver()) {
                    gameOver = true;
                    break;
                }
            }
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        APlayer winner = null;
        int highestScore = 0;
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        for (APlayer player : players) {
            int score = scoreCalculator.calculateScore(player);
            System.out.println(player.getName() + "'s score: " + score);
            if (score > highestScore) {
                highestScore = score;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with a score of " + highestScore);
        }
    }

    private boolean isGameOver() {
        boolean deckEmpty = deck.getCards().isEmpty();
        boolean playerHandEmpty = players.stream().anyMatch(player -> player.getHand().isEmpty());

        // Debugging print statements
        System.out.println("Deck empty: " + deckEmpty);
        System.out.println("Any player's hand empty: " + playerHandEmpty);

        return deckEmpty || playerHandEmpty;
    }
}
