/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author richi
 */
public class AGameTest {
    
    private APlayer player1;
    private APlayer player2;
    private GroupOfCards groupOfCards;
    private AGame game;
    
    public AGameTest(){
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {

    player1 = new APlayer("Player 1");
    player2 = new APlayer("Player 2");
    groupOfCards = new GroupOfCards();
    game = new AGame("Go Fish", player1, player2, groupOfCards); 
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of play method, of class AGame.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        game.play();
        assertFalse(groupOfCards.isEmpty());
        assertFalse(player1.getHand().isEmpty());
        assertFalse(player2.getHand().isEmpty());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @Test
    public void testDealInitialCards() {
    System.out.println("testDealInitialCards");

    // Act
    game.play(); 

    assertEquals(7, player1.getHand().size());
    assertEquals(7, player2.getHand().size());
}


    
}
