/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;
import java.util.Random;

/**
 * Monster Class - Enemy Character
 * 
 * Extends Fighter to represent enemies in the dungeon. Each monster has a challenge
 * level that determines difficulty, and rewards gold/fame based on difficulty.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Fighter
 * @see Hero
 */
public class Monster extends Fighter {
    
    /** Difficulty level (1-5) - affects rewards and damage variation */
    private int challenge;
    
    /** Random number generator for damage variation */
    private Random random;
    
    /**
     * Creates a new Monster enemy
     * 
     * Initializes monster with name, health, power, and challenge level.
     * Rewards (gold and fame) are calculated based on challenge level.
     * Challenge level must be positive (typically 1-5).
     * 
     * @param name the monster's name
     * @param health the monster's health points
     * @param power the monster's attack power
     * @param challenge the difficulty level (must be > 0)
     * 
     * @throws IllegalArgumentException if challenge level is not positive
     */
    public Monster(String name, int health, int power, int challenge) {
        super(name, "Monster", health, power);
        try {
            if (challenge < 1) {
                throw new IllegalArgumentException("Challenge level must be positive");
            }
            
            this.challenge = challenge;
            this.random = new Random();
            this.money = challenge * 50;
            this.fame = challenge * 10;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating monster: " + e.getMessage());
            this.challenge = 1;
            this.random = new Random();
        }
    }
    
    /**
     * Attacks with randomized damage variation
     * 
     * Damage varies between (power - 3) and (power + 3) for unpredictability.
     * Minimum damage is always 1.
     * 
     * @return the damage dealt by this attack
     */
    @Override
    public int attack() {
        try {
            int minDamage = Math.max(1, this.power - 3);
            int maxDamage = this.power + 3;
            
            if (minDamage < 0) minDamage = 1;
            if (maxDamage < minDamage) maxDamage = minDamage + 1;
            
            int damage = minDamage + this.random.nextInt(maxDamage - minDamage + 1);
            
            if (damage < 0) damage = 1;
            
            System.out.println(this.name + " attacks for " + damage + " damage!");
            return damage;
        } catch (IllegalArgumentException e) {
            System.out.println("Error calculating attack damage: " + e.getMessage());
            return this.power;
        } catch (Exception e) {
            System.out.println("Error during monster attack: " + e.getMessage());
            return this.power;
        }
    }
    
    /**
     * Gets the monster's challenge level
     * 
     * Challenge level determines difficulty and rewards.
     * Levels 1-5: Easy to Extreme difficulty.
     * 
     * @return the challenge level (1-5 or higher)
     */
    public int getChallenge() {
        try {
            return this.challenge > 0 ? this.challenge : 1;
        } catch (Exception e) {
            System.out.println("Error getting challenge: " + e.getMessage());
            return 1;
        }
    }
    
    /**
     * Sets the maximum health for this monster
     * 
     * Used for scaling monsters in New Game+ mode.
     * 
     * @param maxHealth the new maximum health value
     */
    public void setMaxHealth(int maxHealth) {
        try {
            if (maxHealth < 1) {
                maxHealth = 1;
            }
            this.maxHealth = maxHealth;
        } catch (Exception e) {
            System.out.println("Error setting max health: " + e.getMessage());
        }
    }
    
    /**
     * Sets the current health for this monster
     * 
     * Used for scaling and resetting monsters.
     * 
     * @param health the new health value
     */
    public void setHealth(int health) {
        try {
            if (health < 0) {
                health = 0;
            }
            if (health > this.maxHealth) {
                health = this.maxHealth;
            }
            this.health = health;
        } catch (Exception e) {
            System.out.println("Error setting health: " + e.getMessage());
        }
    }
    
    /**
     * Sets the power/damage for this monster
     * 
     * Used for scaling monsters in New Game+ mode.
     * 
     * @param power the new attack power value
     */
    public void setPower(int power) {
        try {
            if (power < 1) {
                power = 1;
            }
            this.power = power;
        } catch (Exception e) {
            System.out.println("Error setting power: " + e.getMessage());
        }
    }
    
    /**
     * Display the monster's combat statistics
     * 
     * Shows name, health, power, and challenge level.
     * Called when player encounters a monster.
     */
    public void display() {
        try {
            System.out.println("\n========== MONSTER STATS ==========");
            System.out.println("Name: " + this.name);
            System.out.println("Health: " + this.health + "/" + this.maxHealth);
            System.out.println("Power: " + this.power);
            System.out.println("Challenge: " + this.challenge);
            System.out.println("===================================\n");
        } catch (Exception e) {
            System.out.println("Error displaying monster stats: " + e.getMessage());
        }
    }
}