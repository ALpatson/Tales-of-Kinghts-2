/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

import tales.of.knights.characters.Character;
import tales.of.knights.interfaces.Consumable;

/**
 * HealingItem class - consumable items that restore health
 * Extends Item, implements Consumable
 */
public class HealingItem extends Item implements Consumable {
    
    private int quality;
    private int healAmount;
    
    /**
     * Constructor for HealingItem
     * @param description item description
     * @param healAmount amount of health to restore
     * @param quality quality rating
     * @param value value in gold
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
     * Get heal amount
     * @return healing value
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
     * Get quality
     * @return quality value
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
     * Use the healing item
     * @param character character to heal
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
     * Get description
     * @return description
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
     * Display healing item info
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
