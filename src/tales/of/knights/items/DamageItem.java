/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;
import tales.of.knights.characters.Character;
import tales.of.knights.interfaces.Consumable;

/**
 * DamageItem Class - Consumable Damage Boost Item
 * 
 * Extends Item and implements Consumable. When used, temporarily increases
 * a character's power/damage stat for their next attack.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Item
 * @see Consumable
 * @see HealingItem
 */
public class DamageItem extends Item implements Consumable {
    
    /** Power boost value - amount to increase character's power */
    private int power;
    
    /**
     * Creates a new DamageItem
     * 
     * @param description the item's name/description
     * @param power the amount to boost damage (must be non-negative)
     * @param value the item's price in gold
     * 
     * @throws IllegalArgumentException if power is negative
     */
    public DamageItem(String description, int power, int value) {
        super(description, value);
        try {
            if (power < 0) {
                throw new IllegalArgumentException("Power cannot be negative");
            }
            
            this.power = power;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating damage item: " + e.getMessage());
            this.power = 0;
        }
    }
    
    /**
     * Gets the power boost value
     * 
     * @return how much this item increases damage
     */
    public int getPower() {
        try {
            return this.power >= 0 ? this.power : 0;
        } catch (Exception e) {
            System.out.println("Error getting power: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Uses the damage item to boost character's power
     * 
     * Increases the character's attack power by this item's power value.
     * 
     * @param character the character to boost - must not be null
     */
    @Override
    public void use(Character character) {
        try {
            if (character == null) {
                System.out.println("Error: Character is null!");
                return;
            }
            
            int newPower = character.getPower() + this.power;
            if (newPower < 0) {
                newPower = character.getPower();
            }
            
            character.setPower(newPower);
            System.out.println("Your power increased by " + this.power + "!");
        } catch (Exception e) {
            System.out.println("Error using damage item: " + e.getMessage());
        }
    }
    
    /**
     * Gets the item's description including power value
     * 
     * @return description with power boost information
     */
    @Override
    public String getDescription() {
        try {
            return super.getDescription() + " (Power: " + this.power + ")";
        } catch (Exception e) {
            System.out.println("Error getting description: " + e.getMessage());
            return "Damage Item";
        }
    }
    
    /**
     * Displays damage item information
     * 
     * Shows description, power boost, and gold price.
     */
    @Override
    public void display() {
        try {
            System.out.println(this.description + " (Power: " + this.power + ", Value: " + this.value + " gold)");
        } catch (Exception e) {
            System.out.println("Error displaying damage item: " + e.getMessage());
        }
    }
}