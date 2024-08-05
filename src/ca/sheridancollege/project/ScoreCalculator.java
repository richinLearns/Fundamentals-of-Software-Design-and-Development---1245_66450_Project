/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author richi
 */
public class ScoreCalculator {
    
    public int calculateScore(APlayer player) {

        return player.getHand().size() / 4; 
    }
    
}
