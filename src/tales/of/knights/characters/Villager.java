/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

/**
 * Villager Abstract Class - Base for NPC Characters
 * 
 * Extends Character to represent non-player characters like shopkeepers and gamblers.
 * All villagers have a role/occupation. This is an abstract class that must be
 * extended by concrete NPC types.
 * 
 * @author cobbina
 * @version 1.0
 * @abstract Cannot instantiate directly - extend with concrete NPC classes
 * 
 * @see Character
 * @see Shopkeeper
 * @see Gambler
 */
public abstract class Villager extends Character {
    
    /** The villager's role or occupation (e.g., "Shopkeeper", "Gambler") */
    protected String role;
    
    /**
     * Creates a new Villager NPC
     * 
     * All villagers start with 50 health and 5 power. Role must not be empty.
     * 
     * @param name the villager's name
     * @param title the villager's title
     * @param role the villager's occupation/role (e.g., "Merchant")
     * 
     * @throws IllegalArgumentException if role is null or empty
     */
    public Villager(String name, String title, String role) {
        super(name, title, 50, 5);
        try {
            if (role == null || role.trim().isEmpty()) {
                throw new IllegalArgumentException("Role cannot be empty");
            }
            this.role = role;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating villager: " + e.getMessage());
            this.role = "Unknown";
        }
    }
    
    /**
     * Gets the villager's role/occupation
     * 
     * @return the villager's role string
     */
    public String getRole() {
        try {
            return this.role != null ? this.role : "Unknown";
        } catch (Exception e) {
            System.out.println("Error getting role: " + e.getMessage());
            return "Unknown";
        }
    }
    
    /**
     * Sets the villager's role/occupation
     * 
     * @param role the new role - must not be null or empty
     * 
     * @throws IllegalArgumentException if role is null or empty
     */
    public void setRole(String role) {
        try {
            if (role == null || role.trim().isEmpty()) {
                throw new IllegalArgumentException("Role cannot be empty");
            }
            this.role = role;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting role: " + e.getMessage());
        }
    }
    
    /**
     * Villager greets the player
     * 
     * Displays a greeting message with the villager's name and role.
     */
    public void greet() {
        try {
            System.out.println("\nHello! I'm " + this.name + ", a " + this.role + ".");
        } catch (Exception e) {
            System.out.println("Error greeting: " + e.getMessage());
        }
    }
}