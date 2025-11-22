/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;
import java.util.Random;

/**
 * Gambler NPC - Offers gambling games to the player
 * 
 * Extends Villager to provide gambling services. Players can bet gold for a 50/50
 * chance to double their money and gain fame, or lose their bet.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Villager
 * @see Hero
 */
public class Gambler extends Villager {
    
    /** Random number generator for 50/50 gambling odds */
    private Random random;
    
    /**
     * Creates a new Gambler NPC
     * 
     * @param name the gambler's name
     */
    public Gambler(String name) {
        super(name, "Gambler", "Gambler");
        try {
            this.random = new Random();
        } catch (Exception e) {
            System.out.println("Error creating gambler: " + e.getMessage());
            this.random = new Random();
        }
    }
    
    /**
     * Play a gambling game with the hero
     * 
     * 50/50 chance to win. If hero wins, receives bet * 2 gold and 5 fame.
     * If hero loses, loses the bet. Validates hero has enough money before betting.
     * 
     * @param hero the player - must not be null
     * @param bet amount of gold to wager - must be positive and available
     * @return true if hero won the gamble, false if lost or error occurred
     * 
     * @see #displayGamblingOptions()
     */
    public boolean gamble(Hero hero, int bet) {
        try {
            if (hero == null) {
                System.out.println("Error: Hero is null!");
                return false;
            }
            
            if (bet < 0) {
                System.out.println("Error: Bet cannot be negative!");
                return false;
            }
            
            if (bet == 0) {
                System.out.println("Error: Bet must be greater than 0!");
                return false;
            }
            
            if (hero.getMoney() < bet) {
                System.out.println("Error: Not enough money to bet!");
                return false;
            }
            
            System.out.println("\n" + this.name + " says: 'Let's gamble! You bet " + bet + " gold!'");
            
            // 50% chance to win
            boolean heroWins = this.random.nextBoolean();
            
            if (heroWins) {
                int winnings = bet * 2;
                hero.addMoney(winnings);
                hero.addFame(5);
                System.out.println("You won! You gain " + winnings + " gold and 5 fame!");
                return true;
            } else {
                hero.removeMoney(bet);
                System.out.println("You lost! You lost " + bet + " gold.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error during gamble: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Displays available gambling betting options to the player
     * 
     * Shows welcome message and betting amounts (10, 50, 100 gold).
     * 
     * @see #gamble(Hero, int)
     */
    public void displayGamblingOptions() {
        try {
            System.out.println("\n========== GAMBLING ==========");
            System.out.println("Welcome to the gambling table!");
            System.out.println("Risk your gold for a chance to double it!");
            System.out.println("1. Bet 10 gold");
            System.out.println("2. Bet 50 gold");
            System.out.println("3. Bet 100 gold");
            System.out.println("4. Leave");
            System.out.println("==============================\n");
        } catch (Exception e) {
            System.out.println("Error displaying gambling options: " + e.getMessage());
        }
    }
}