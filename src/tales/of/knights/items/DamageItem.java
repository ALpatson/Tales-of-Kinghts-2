/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

import tales.of.knights.characters.Character;
import tales.of.knights.interfaces.Consumable;

/**
 * DamageItem class - consumable items that increase damage
 * Extends Item, implements Consumable
 */
public class DamageItem extends Item implements Consumable {
    
    private int power;
    
    /**
     * Constructor for DamageItem
     * @param description item description
     * @param power power boost value
     * @param value value in gold
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
     * Get power value
     * @return power value
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
     * Use the damage item (increases character power)
     * @param character character to boost
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
     * Get description
     * @return description
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
     * Display damage item info
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
