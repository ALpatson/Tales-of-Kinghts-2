/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

import java.util.Random;

/**
 * Monster class - represents enemy characters
 * Extends Fighter for combat abilities
 */
public class Monster extends Fighter {
    
    private int challenge; // Difficulty level
    private Random random;
    
    /**
     * Constructor for Monster
     * @param name monster name
     * @param health monster health
     * @param power monster power
     * @param challenge difficulty level
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
     * Attack with randomized damage
     * @return damage dealt
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
     * Get challenge level
     * @return challenge level
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
     * Display monster stats
     */
    public void displayStats() {
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