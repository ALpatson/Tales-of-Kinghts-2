/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

/**
 * Armor class - represents armor that reduces damage
 * Extends Item
 */
public class Armor extends Item {
    
    private int protection;
    
    /**
     * Constructor for Armor
     * @param description armor description
     * @param protection protection value
     * @param value value in gold
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
     * Get armor protection value
     * @return protection value
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
     * Display armor info
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