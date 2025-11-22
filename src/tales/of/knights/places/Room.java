/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;
import tales.of.knights.characters.Monster;

/**
 * Room Class - Dungeon Chamber with Enemy
 * 
 * Extends Place to represent a single dungeon chamber containing one enemy monster.
 * Each room has a difficulty level (1-5) that determines the enemy's strength.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Place
 * @see Dungeon
 * @see Monster
 */
public class Room extends Place {
    
    /** The enemy monster in this room */
    private Monster monster;
    
    /** Difficulty level (1-5) - affects enemy strength and type */
    private int level;
    
    /**
     * Creates a new Room with an enemy
     * 
     * Generates a monster based on difficulty level. Higher levels spawn
     * stronger enemies with more health and power.
     * 
     * @param level the room's difficulty (1-5)
     * 
     * @throws IllegalArgumentException if level is not positive
     */
    public Room(int level) {
        super("Dungeon Room", "A dark, damp dungeon chamber");
        try {
            if (level < 1) {
                throw new IllegalArgumentException("Level must be positive");
            }
            
            this.level = level;
            createMonster(level);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating room: " + e.getMessage());
            this.level = 1;
            createMonster(1);
        }
    }
    
    /**
     * Creates a monster appropriate for the room level
     * 
     * Spawns different monster types (Goblin, Orc, Troll, Dragon, Demon)
     * based on level. Monster stats scale with difficulty.
     * 
     * @param level the difficulty level for the monster
     */
    private void createMonster(int level) {
        try {
            if (level < 1) {
                level = 1;
            }
            
            String[] monsterNames = {"Goblin", "Orc", "Troll", "Dragon", "Demon"};
            String name = monsterNames[(level - 1) % monsterNames.length];
            
            int health = 30 + (level * 10);
            int power = 10 + (level * 2);
            
            this.monster = new Monster(name, health, power, level);
        } catch (Exception e) {
            System.out.println("Error creating monster: " + e.getMessage());
            this.monster = new Monster("Goblin", 30, 10, 1);
        }
    }
    
    /**
     * Gets the enemy monster in this room
     * 
     * @return the Monster the player must defeat
     */
    public Monster getMonster() {
        try {
            if (this.monster == null) {
                createMonster(this.level);
            }
            return this.monster;
        } catch (Exception e) {
            System.out.println("Error getting monster: " + e.getMessage());
            return new Monster("Goblin", 30, 10, 1);
        }
    }
    
    /**
     * Gets the room's difficulty level
     * 
     * @return the level (1-5)
     */
    public int getLevel() {
        try {
            return this.level > 0 ? this.level : 1;
        } catch (Exception e) {
            System.out.println("Error getting level: " + e.getMessage());
            return 1;
        }
    }
    
    /**
     * Displays the room and monster encounter
     * 
     * Shows room description and the enemy that appears.
     */
    @Override
    public void display() {
        try {
            System.out.println("\n========== DUNGEON ROOM (Level " + this.level + ") ==========");
            System.out.println(this.description);
            if (this.monster != null) {
                System.out.println("A wild " + this.monster.getName() + " appears!");
            }
            System.out.println("================================================\n");
        } catch (Exception e) {
            System.out.println("Error displaying room: " + e.getMessage());
        }
    }
}