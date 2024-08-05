/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;



/**
 *
 * @author richi
 */
public class Main {
    public static void main(String[] args) {
        // Create a new game
        
        AGame game = new AGame("Go Fish");
        
        


        APlayer player1 = new APlayer("Player 1");
        APlayer player2 = new APlayer("Player 2");
        game.registerPlayer(player1);
        game.registerPlayer(player2);

   
        System.out.println("Shuffling and dealing cards...");
        game.shuffleAndDeal();


        System.out.println("Starting the game...");
        game.play();
       
    }
    
}
