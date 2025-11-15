/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;

/**
 * Dungeon class - represents the dungeon location
 * Extends Place
 */
public class Dungeon extends Place {
    
    private Room currentRoom;
    private int currentLevel;
    
    /**
     * Constructor for Dungeon
     */
    public Dungeon() {
        super("Dungeon", "A dark and dangerous dungeon");
        try {
            this.currentLevel = 1;
            this.currentRoom = new Room(1);
        } catch (Exception e) {
            System.out.println("Error creating dungeon: " + e.getMessage());
            this.currentLevel = 1;
            this.currentRoom = new Room(1);
        }
    }
    
    /**
     * Get current room
     * @return current room
     */
    public Room getCurrentRoom() {
        try {
            if (this.currentRoom == null) {
                this.currentRoom = new Room(this.currentLevel);
            }
            return this.currentRoom;
        } catch (Exception e) {
            System.out.println("Error getting current room: " + e.getMessage());
            return new Room(1);
        }
    }
    
    /**
     * Move to next room
     */
    public void nextRoom() {
        try {
            this.currentLevel++;
            if (this.currentLevel > 5) {
                this.currentLevel = 5; // Cap at level 5
            }
            this.currentRoom = new Room(this.currentLevel);
        } catch (Exception e) {
            System.out.println("Error moving to next room: " + e.getMessage());
        }
    }
    
    /**
     * Get current level
     * @return level
     */
    public int getCurrentLevel() {
        try {
            return this.currentLevel > 0 ? this.currentLevel : 1;
        } catch (Exception e) {
            System.out.println("Error getting current level: " + e.getMessage());
            return 1;
        }
    }
    
    /**
     * Display the dungeon
     */
    @Override
    public void display() {
        try {
            System.out.println("\n========== DUNGEON (Level " + this.currentLevel + ") ==========");
            System.out.println(this.description);
            if (this.currentRoom != null) {
                System.out.println("You enter Chamber " + this.currentLevel);
            }
            System.out.println("================================================\n");
        } catch (Exception e) {
            System.out.println("Error displaying dungeon: " + e.getMessage());
        }
    }
}
