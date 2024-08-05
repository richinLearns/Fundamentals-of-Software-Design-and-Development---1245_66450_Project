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
public class APlayer extends Player {
    private ArrayList<ACard> hand;

    public APlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    @Override
    public ArrayList<ACard> getHand() {
        return hand;
    }

    @Override
    public void addCardToHand(ACard card) {
        hand.add(card);
    }

    @Override
    public void removeCardFromHand(ACard card) {
        hand.remove(card);
    }

    @Override
    public boolean hasCard(String rank) {
        for (ACard card : hand) {
            if (card.getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<ACard> giveCards(String rank) {
        ArrayList<ACard> cardsToGive = new ArrayList<>();
        for (ACard card : hand) {
            if (card.getRank().equals(rank)) {
                cardsToGive.add(card);
            }
        }
        hand.removeAll(cardsToGive);
        return cardsToGive;
    }

    @Override
    public void play() {
        System.out.println(getName() + "'s turn. Hand: " + hand);
      
    }
    
}
