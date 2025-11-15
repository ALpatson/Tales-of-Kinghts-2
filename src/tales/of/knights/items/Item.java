/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

/**
 * Abstract Item class - represents all items in the game
 */
public abstract class Item {
    
    protected String description;
    protected int value;
    
    /**
     * Constructor for Item
     * @param description item description
     * @param value item value in gold
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
     * Get item description
     * @return description
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
     * Get item value
     * @return value in gold
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
     * Abstract display method
     */
    public abstract void display();
}