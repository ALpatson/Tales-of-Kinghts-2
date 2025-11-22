/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

/**
 * Item Abstract Class - Base for All Game Items
 * 
 * Abstract base class representing all items in the game. All items have a
 * description and a gold value. Concrete item types (Weapon, Armor, etc.)
 * extend this class.
 * 
 * @author cobbina
 * @version 1.0
 * @abstract Cannot instantiate directly - extend with concrete item classes
 * 
 * @see Weapon
 * @see Armor
 * @see HealingItem
 * @see DamageItem
 */
public abstract class Item {
    
    /** The item's name or description */
    protected String description;
    
    /** The item's value in gold currency */
    protected int value;
    
    /**
     * Creates a new Item
     * 
     * All items must have a description and value. Description cannot be empty,
     * and value cannot be negative.
     * 
     * @param description the item's name/description - must not be null or empty
     * @param value the item's price in gold - must be non-negative
     * 
     * @throws IllegalArgumentException if description is empty or value is negative
     */
    public Item(String description, int value) {
        try {
            if (description == null || description.trim().isEmpty()) {
                throw new IllegalArgumentException("Description cannot be empty");
            }
            if (value < 0) {
                throw new IllegalArgumentException("Value cannot be negative");
            }
            
            this.description = description;
            this.value = value;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating item: " + e.getMessage());
            this.description = "Unknown Item";
            this.value = 0;
        }
    }
    
    /**
     * Gets the item's description
     * 
     * @return the item's name or description string
     */
    public String getDescription() {
        try {
            return this.description != null ? this.description : "Unknown Item";
        } catch (Exception e) {
            System.out.println("Error getting description: " + e.getMessage());
            return "Unknown Item";
        }
    }
    
    /**
     * Gets the item's value in gold
     * 
     * @return the item's price/value
     */
    public int getValue() {
        try {
            return this.value >= 0 ? this.value : 0;
        } catch (Exception e) {
            System.out.println("Error getting value: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Abstract method for displaying item information
     * 
     * Subclasses must implement this to show item details.
     */
    public abstract void display();
}