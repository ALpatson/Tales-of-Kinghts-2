/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;

/**
 * Abstract Place class - represents locations in the game
 */
public abstract class Place {
    
    protected String name;
    protected String description;
    
    /**
     * Constructor for Place
     * @param name place name
     * @param description place description
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
     * Get place name
     * @return name
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
     * Get place description
     * @return description
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
     * Display the place
     */
    public abstract void display();
}
