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
        if (!hand.isEmpty()) {
            Card cardToPlay = hand.remove(0); // Play the first card in hand
            playedCards.add(cardToPlay); // Add the card to played cards
            System.out.println(getName() + " plays " + cardToPlay);
            checkForBook(cardToPlay.getRank());
        }
    }

    private void checkForBook(String rank) {
        int count = 0;
        for (Card card : playedCards) {
            if (card.getRank().equals(rank)) {
                count++;
            }
        }
        if (count == 4) {
            books.put(rank, books.getOrDefault(rank, 0) + 1);
            playedCards.removeIf(card -> card.getRank().equals(rank));
            System.out.println(getName() + " has formed a book of " + rank + "s");
        }
    }

    @Override
    public void removeCardFromHand(ACard card) {
        hand.remove(card);
    }
}