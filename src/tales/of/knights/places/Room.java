/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;

import tales.of.knights.characters.Monster;

/**
 * Room class - represents a dungeon room
 * Extends Place
 */
public class Room extends Place {
    
    private Monster monster;
    private int level;
    
    /**
     * Constructor for Room
     * @param level room level/difficulty
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
     * Create a monster for this room
     * @param level room level
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
     * Get the monster in this room
     * @return monster
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
     * Get room level
     * @return level
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
     * Display the room
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
