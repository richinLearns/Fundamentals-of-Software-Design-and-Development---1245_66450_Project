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
import java.util.HashMap;
import java.util.Scanner;

public class APlayer extends Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> playedCards;
    private HashMap<String, Integer> books;

    public APlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        playedCards = new ArrayList<>();
        books = new HashMap<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getPlayedCards() {
        return playedCards;
    }

    public HashMap<String, Integer> getBooks() {
        return books;
    }

    @Override
    public void play() {
        // This method can be empty or contain some default behavior
        // Since playTurn will handle the actual gameplay logic
    }

    public void playTurn(Scanner scanner, APlayer opponent, GroupOfCards groupOfCards) {
        System.out.println("Your hand: " + hand);
        System.out.print("Enter the rank you want to ask for: ");
        String rank = scanner.nextLine();

        ArrayList<Card> opponentCards = opponent.askForRank(rank);
        if (opponentCards.isEmpty()) {
            System.out.println(opponent.getName() + " says: Go Fish!");
            if (!groupOfCards.isEmpty()) {
                Card drawnCard = groupOfCards.drawCard();
                hand.add(drawnCard);
                System.out.println("You drew: " + drawnCard);
                checkForBook(drawnCard.getRank());
            }
        } else {
            hand.addAll(opponentCards);
            System.out.println("You got " + opponentCards.size() + " cards from " + opponent.getName());
            checkForBook(rank);
        }
    }

    public ArrayList<Card> askForRank(String rank) {
        ArrayList<Card> matchingCards = new ArrayList<>();
        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                matchingCards.add(card);
            }
        }
        hand.removeAll(matchingCards);
        return matchingCards;
    }

    private void checkForBook(String rank) {
        int count = 0;
        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                count++;
            }
        }
        if (count == 4) {
            books.put(rank, books.getOrDefault(rank, 0) + 1);
            hand.removeIf(card -> card.getRank().equals(rank));
            System.out.println(getName() + " has formed a book of " + rank + "s");
        }
    }

    @Override
    public void removeCardFromHand(ACard card) {
        hand.remove(card);
    }
}