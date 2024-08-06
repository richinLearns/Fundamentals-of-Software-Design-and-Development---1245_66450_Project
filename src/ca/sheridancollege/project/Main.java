/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;



/**
 *
 * @author richi
 */
//final version 2.0
public class Main {
    public static void main(String[] args) {
        // Create a new game
        APlayer player1 = new APlayer("Player 1");
        APlayer player2 = new APlayer("Player 2");
        GroupOfCards groupOfCards = new GroupOfCards();
        AGame game = new AGame("Go Fish", player1, player2, groupOfCards);

        System.out.println("Shuffling and dealing cards...");
        game.play();
    }
}
