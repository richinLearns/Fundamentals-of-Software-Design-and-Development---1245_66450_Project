/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;



/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */

public abstract class Game {
    private String name;

    public Game(String name) {
        this.name = name;
    }

    public abstract void play();
    public abstract void declareWinner();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}