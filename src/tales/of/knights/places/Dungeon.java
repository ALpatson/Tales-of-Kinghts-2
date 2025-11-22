/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;

/**
 * Dungeon Class - Dangerous Combat Location with Multiple Levels
 * 
 * Extends Place to represent a dungeon with 5 progressively harder levels.
 * Each level contains a Room with enemies. Players progress through levels
 * by defeating enemies and advancing.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Place
 * @see Room
 * @see Town
 */
public class Dungeon extends Place {
    
    /** The current room/chamber the player is in */
    private Room currentRoom;
    
    /** Current dungeon level (1-5, capped at 5) */
    private int currentLevel;
    
    /**
     * Creates a new Dungeon
     * 
     * Initializes dungeon starting at level 1 with the first room.
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
     * Gets the current room the player is in
     * 
     * @return the current Room object with enemies for this level
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
     * Advances to the next dungeon level
     * 
     * Increases current level by 1 (capped at level 5).
     * Creates a new room with increased difficulty.
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
     * Gets the current dungeon level
     * 
     * @return the current level (1-5)
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
     * Displays the dungeon and current level information
     * 
     * Shows dungeon name, description, and current chamber/level.
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