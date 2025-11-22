/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;
import tales.of.knights.characters.Character;
import tales.of.knights.interfaces.Consumable;

/**
 * HealingItem Class - Consumable Health Restoration Item
 * 
 * Extends Item and implements Consumable. When used, restores a character's
 * health by a specified amount. Each potion has a quality rating.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Item
 * @see Consumable
 * @see DamageItem
 */
public class HealingItem extends Item implements Consumable {
    
    /** Quality rating of the potion (higher = better) */
    private int quality;
    
    /** Amount of health this item restores */
    private int healAmount;
    
    /**
     * Creates a new HealingItem
     * 
     * @param description the item's name/description
     * @param healAmount how much health to restore (must be non-negative)
     * @param quality the potion's quality rating (must be non-negative)
     * @param value the item's price in gold
     * 
     * @throws IllegalArgumentException if healAmount or quality is negative
     */
    public HealingItem(String description, int healAmount, int quality, int value) {
        super(description, value);
        try {
            if (healAmount < 0) {
                throw new IllegalArgumentException("Heal amount cannot be negative");
            }
            if (quality < 0) {
                throw new IllegalArgumentException("Quality cannot be negative");
            }
            
            this.healAmount = healAmount;
            this.quality = quality;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating healing item: " + e.getMessage());
            this.healAmount = 0;
            this.quality = 0;
        }
    }
    
    /**
     * Gets the healing amount this item provides
     * 
     * @return how much health this item restores
     */
    public int getHealAmount() {
        try {
            return this.healAmount >= 0 ? this.healAmount : 0;
        } catch (Exception e) {
            System.out.println("Error getting heal amount: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Gets the quality rating of this potion
     * 
     * @return the quality value
     */
    public int getQuality() {
        try {
            return this.quality >= 0 ? this.quality : 0;
        } catch (Exception e) {
            System.out.println("Error getting quality: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Uses the healing item to restore character's health
     * 
     * @param character the character to heal - must not be null
     */
    @Override
    public void use(Character character) {
        try {
            if (character == null) {
                System.out.println("Error: Character is null!");
                return;
            }
            
            character.heal(this.healAmount);
        } catch (Exception e) {
            System.out.println("Error using healing item: " + e.getMessage());
        }
    }
    
    /**
     * Gets the item's description including healing and quality info
     * 
     * @return description with healing and quality information
     */
    @Override
    public String getDescription() {
        try {
            return super.getDescription() + " (Healing: " + this.healAmount + ", Quality: " + this.quality + ")";
        } catch (Exception e) {
            System.out.println("Error getting description: " + e.getMessage());
            return "Healing Item";
        }
    }
    
    /**
     * Displays healing item information
     * 
     * Shows description, quality, and gold price.
     */
    @Override
    public void display() {
        try {
            System.out.println(this.description + " (Quality: " + this.quality + ", Value: " + this.value + " gold)");
        } catch (Exception e) {
            System.out.println("Error displaying healing item: " + e.getMessage());
        }
    }
}