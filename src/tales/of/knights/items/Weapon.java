/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

/**
 * Weapon Class - Offensive Equipment Item
 * 
 * Extends Item to represent weapons that increase attack damage when equipped.
 * Each weapon has a damage value that is added to attacks in combat.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Item
 * @see Armor
 * @see tales.of.knights.characters.Fighter
 */
public class Weapon extends Item {
    
    /** Damage value - how much damage this weapon adds to attacks */
    private int damage;
    
    /**
     * Creates a new Weapon item
     * 
     * @param description the weapon's name/description
     * @param damage how much damage this weapon deals (must be non-negative)
     * @param value the weapon's price in gold
     * 
     * @throws IllegalArgumentException if damage is negative
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
     * Gets the weapon's damage value
     * 
     * @return how much damage this weapon adds to attacks
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
     * Displays weapon information
     * 
     * Shows description, damage value, and gold price.
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