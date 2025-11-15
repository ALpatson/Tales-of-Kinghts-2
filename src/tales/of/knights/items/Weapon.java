/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

/**
 * Weapon class - represents weapons that increase damage
 * Extends Item
 */
public class Weapon extends Item {
    
    private int damage;
    
    /**
     * Constructor for Weapon
     * @param description weapon description
     * @param damage damage value
     * @param value value in gold
     */
    public Weapon(String description, int damage, int value) {
        super(description, value);
        try {
            if (damage < 0) {
                throw new IllegalArgumentException("Damage cannot be negative");
            }
            
            this.damage = damage;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating weapon: " + e.getMessage());
            this.damage = 0;
        }
    }
    
    /**
     * Get weapon damage
     * @return damage value
     */
    public int getDamage() {
        try {
            return this.damage >= 0 ? this.damage : 0;
        } catch (Exception e) {
            System.out.println("Error getting damage: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Display weapon info
     */
    @Override
    public void display() {
        try {
            System.out.println(this.description + " (Damage: " + this.damage + ", Value: " + this.value + " gold)");
        } catch (Exception e) {
            System.out.println("Error displaying weapon: " + e.getMessage());
        }
    }
}
