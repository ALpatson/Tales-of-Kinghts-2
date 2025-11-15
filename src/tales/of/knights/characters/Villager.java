/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

/**
 * Abstract Villager class - represents NPC characters
 * Extends Character for common properties
 */
public abstract class Villager extends Character {
    
    protected String role;
    
    /**
     * Constructor for Villager
     * @param name villager name
     * @param title villager title
     * @param role villager role/occupation
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
     * Get the villager's role
     * @return role string
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
     * Set the villager's role
     * @param role new role
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
     * Greet the player
     */
    public void greet() {
        try {
            System.out.println("\nHello! I'm " + this.name + ", a " + this.role + ".");
        } catch (Exception e) {
            System.out.println("Error greeting: " + e.getMessage());
        }
    }
}