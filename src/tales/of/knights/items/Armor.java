/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

/**
 * Armor Class - Protective Equipment Item
 * 
 * Extends Item to represent armor that reduces incoming damage when equipped.
 * Each armor has a protection value that decreases damage taken in combat.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Item
 * @see Weapon
 * @see tales.of.knights.characters.Fighter
 */
public class Armor extends Item {
    
    /** Protection value - how much damage this armor reduces */
    private int protection;
    
    /**
     * Creates a new Armor item
     * 
     * @param description the armor's name/description
     * @param protection how much damage this armor blocks (must be non-negative)
     * @param value the armor's price in gold
     * 
     * @throws IllegalArgumentException if protection is negative
     */
    public Armor(String description, int protection, int value) {
        super(description, value);
        try {
            if (protection < 0) {
                throw new IllegalArgumentException("Protection cannot be negative");
            }
            
            this.protection = protection;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating armor: " + e.getMessage());
            this.protection = 0;
        }
    }
    
    /**
     * Gets the armor's protection value
     * 
     * @return how much damage this armor reduces when equipped
     */
    public int getProtection() {
        try {
            return this.protection >= 0 ? this.protection : 0;
        } catch (Exception e) {
            System.out.println("Error getting protection: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Displays armor information
     * 
     * Shows description, protection value, and gold price.
     */
    @Override
    public void display() {
        try {
            System.out.println(this.description + " (Protection: " + this.protection + ", Value: " + this.value + " gold)");
        } catch (Exception e) {
            System.out.println("Error displaying armor: " + e.getMessage());
        }
    }
}