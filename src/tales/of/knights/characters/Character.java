/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

/**
 * Abstract base class for all characters in the game
 * Provides common properties and methods
 * @author cobbi
 */
public abstract class Character {
    
    protected String name;
    protected String title;
    protected int health;
    protected int maxHealth;
    protected int power;
    protected int fame;
    protected int money;
    
    /**
     * Constructor for Character
     * @param name character name
     * @param title character title
     * @param health starting health
     * @param power character power/strength
     */
    public Character(String name, String title, int health, int power) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }
            if (health <= 0) {
                throw new IllegalArgumentException("Health must be positive");
            }
            if (power <= 0) {
                throw new IllegalArgumentException("Power must be positive");
            }
            
            this.name = name;
            this.title = title;
            this.health = health;
            this.maxHealth = health;
            this.power = power;
            this.fame = 0;
            this.money = 100;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating character: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Introduce the character
     */
    public void introduce() {
        try {
            System.out.println("\n========== CHARACTER PROFILE ==========");
            System.out.println("Name: " + this.name);
            System.out.println("Title: " + this.title);
            System.out.println("Health: " + this.health + "/" + this.maxHealth);
            System.out.println("Power: " + this.power);
            System.out.println("Fame: " + this.fame);
            System.out.println("Money: " + this.money + " gold");
            System.out.println("========================================\n");
        } catch (Exception e) {
            System.out.println("Error displaying character info: " + e.getMessage());
        }
    }
    
    /**
     * Take damage from an attack
     * @param damage amount of damage
     */
    public void takeDamage(int damage) {
        try {
            if (damage < 0) {
                System.out.println("Error: Damage cannot be negative!");
                return;
            }
            
            this.health -= damage;
            if (this.health < 0) {
                this.health = 0;
            }
            
            System.out.println(this.name + " takes " + damage + " damage! (Health: " + this.health + ")");
        } catch (Exception e) {
            System.out.println("Error taking damage: " + e.getMessage());
        }
    }
    
    /**
     * Heal the character
     * @param amount amount to heal
     */
    public void heal(int amount) {
        try {
            if (amount < 0) {
                System.out.println("Error: Heal amount cannot be negative!");
                return;
            }
            
            this.health += amount;
            if (this.health > this.maxHealth) {
                this.health = this.maxHealth;
            }
            
            System.out.println(this.name + " recovers " + amount + " health! (Health: " + this.health + ")");
        } catch (Exception e) {
            System.out.println("Error healing: " + e.getMessage());
        }
    }
    
    /**
     * Check if character is alive
     * @return true if alive
     */
    public boolean isAlive() {
        return this.health > 0;
    }
    
    // Getters and Setters with exception handling
    
    public String getName() {
        try {
            return this.name != null ? this.name : "Unknown";
        } catch (Exception e) {
            System.out.println("Error getting name: " + e.getMessage());
            return "Unknown";
        }
    }
    
    public void setName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting name: " + e.getMessage());
        }
    }
    
    public String getTitle() {
        try {
            return this.title != null ? this.title : "Unknown";
        } catch (Exception e) {
            System.out.println("Error getting title: " + e.getMessage());
            return "Unknown";
        }
    }
    
    public void setTitle(String title) {
        try {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty");
            }
            this.title = title;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting title: " + e.getMessage());
        }
    }
    
    public int getHealth() {
        try {
            return this.health >= 0 ? this.health : 0;
        } catch (Exception e) {
            System.out.println("Error getting health: " + e.getMessage());
            return 0;
        }
    }
    
    public int getMaxHealth() {
        try {
            return this.maxHealth > 0 ? this.maxHealth : 1;
        } catch (Exception e) {
            System.out.println("Error getting max health: " + e.getMessage());
            return 1;
        }
    }
    
    public int getPower() {
        try {
            return this.power > 0 ? this.power : 1;
        } catch (Exception e) {
            System.out.println("Error getting power: " + e.getMessage());
            return 1;
        }
    }
    
    public void setPower(int power) {
        try {
            if (power <= 0) {
                throw new IllegalArgumentException("Power must be positive");
            }
            this.power = power;
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting power: " + e.getMessage());
        }
    }
    
    public int getFame() {
        try {
            return this.fame >= 0 ? this.fame : 0;
        } catch (Exception e) {
            System.out.println("Error getting fame: " + e.getMessage());
            return 0;
        }
    }
    
    public void setFame(int fame) {
        try {
            if (fame < 0) {
                this.fame = 0;
            } else {
                this.fame = fame;
            }
        } catch (Exception e) {
            System.out.println("Error setting fame: " + e.getMessage());
        }
    }
    
    public void addFame(int amount) {
        try {
            if (amount < 0) {
                System.out.println("Error: Fame amount cannot be negative!");
                return;
            }
            this.fame += amount;
        } catch (Exception e) {
            System.out.println("Error adding fame: " + e.getMessage());
        }
    }
    
    public int getMoney() {
        try {
            return this.money >= 0 ? this.money : 0;
        } catch (Exception e) {
            System.out.println("Error getting money: " + e.getMessage());
            return 0;
        }
    }
    
    public void setMoney(int money) {
        try {
            if (money < 0) {
                this.money = 0;
            } else {
                this.money = money;
            }
        } catch (Exception e) {
            System.out.println("Error setting money: " + e.getMessage());
        }
    }
    
    public void addMoney(int amount) {
        try {
            if (amount < 0) {
                System.out.println("Error: Money amount cannot be negative!");
                return;
            }
            this.money += amount;
        } catch (Exception e) {
            System.out.println("Error adding money: " + e.getMessage());
        }
    }
    
    public void removeMoney(int amount) {
        try {
            if (amount < 0) {
                System.out.println("Error: Money amount cannot be negative!");
                return;
            }
            if (amount > this.money) {
                System.out.println("Error: Not enough money!");
                return;
            }
            this.money -= amount;
        } catch (Exception e) {
            System.out.println("Error removing money: " + e.getMessage());
        }
    }
}
