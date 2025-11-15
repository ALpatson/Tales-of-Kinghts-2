/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

import java.util.Random;

/**
 * Gambler class - offers gambling games
 * Extends Villager
 */
public class Gambler extends Villager {
    
    private Random random;
    
    /**
     * Constructor for Gambler
     * @param name gambler name
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
     * Play a gamble with the hero
     * @param hero the player
     * @param bet amount to bet
     * @return true if hero wins
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
     * Display gambling options
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