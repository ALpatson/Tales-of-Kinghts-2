/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;

/**
 * Place Abstract Class - Base for All Game Locations
 * 
 * Abstract base class representing locations/areas in the game. All places have
 * a name and description. Concrete location types (Town, Dungeon) extend this class.
 * 
 * @author cobbina
 * @version 1.0
 * @abstract Cannot instantiate directly - extend with concrete location classes
 * 
 * @see Town
 * @see Dungeon
 * @see Room
 */
public abstract class Place {
    
    /** The location's name (e.g., "Town", "Dungeon") */
    protected String name;
    
    /** The location's description and atmosphere */
    protected String description;
    
    /**
     * Creates a new Place
     * 
     * All places must have a name and description. Both cannot be empty.
     * 
     * @param name the place's name - must not be null or empty
     * @param description the place's description - must not be null or empty
     * 
     * @throws IllegalArgumentException if name or description is empty
     */
    public Place(String name, String description) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (description == null || description.trim().isEmpty()) {
                throw new IllegalArgumentException("Description cannot be empty");
            }
            
            this.name = name;
            this.description = description;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating place: " + e.getMessage());
            this.name = "Unknown Place";
            this.description = "Unknown";
        }
    }
    
    /**
     * Gets the place's name
     * 
     * @return the location's name
     */
    public String getName() {
        try {
            return this.name != null ? this.name : "Unknown Place";
        } catch (Exception e) {
            System.out.println("Error getting name: " + e.getMessage());
            return "Unknown Place";
        }
    }
    
    /**
     * Gets the place's description
     * 
     * @return the location's description and atmosphere
     */
    public String getDescription() {
        try {
            return this.description != null ? this.description : "Unknown";
        } catch (Exception e) {
            System.out.println("Error getting description: " + e.getMessage());
            return "Unknown";
        }
    }
    
    /**
     * Abstract method for displaying place information
     * 
     * Subclasses must implement this to show location details.
     */
    public abstract void display();
}