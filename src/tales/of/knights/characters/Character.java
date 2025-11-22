/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

/**
 * Character Abstract Base Class - Foundation for all character types in Tales of Knights
 * 
 * This abstract class serves as the foundation for all character types in the game, including
 * players (Hero), enemies (Monster), and non-player characters (Villager and its subclasses).
 * It provides common properties and methods that all characters share, such as name, health,
 * power, fame, and money attributes.
 * 
 * The Character class implements the core attributes system and provides common functionality
 * including taking damage, healing, gaining/losing money and fame, and displaying character
 * information. All characters maintain their current and maximum health, power level for combat,
 * and resources (money and fame) for progression.
 * 
 * This class uses the Template Method pattern - it defines the structure and common behavior
 * that all characters share, while specific character types (Hero, Monster, etc.) override or
 * extend this behavior for their unique implementations.
 * 
 * All methods include comprehensive exception handling to ensure robust error management
 * throughout character operations. Invalid parameters are caught and appropriate error messages
 * are displayed without crashing the application.
 * 
 * @author cobbina
 * @version 1.3
 * 
 */
public abstract class Character {
    
    /** The character's name - unique identifier for the character */
    protected String name;
    
    /** The character's title or class (e.g., "Knight", "Goblin", "Shopkeeper") */
    protected String title;
    
    /** Current health points - decreases when damaged, increases when healed */
    protected int health;
    
    /** Maximum health points - the upper limit for health that character can have */
    protected int maxHealth;
    
    /** Character's power/strength stat - affects damage dealt in combat */
    protected int power;
    
    /** Character's fame/reputation - gained by winning battles and other achievements */
    protected int fame;
    
    /** Character's money/gold - currency used for buying items and transactions */
    protected int money;
    
    /**
     * Constructor for creating a new Character
     * 
     * Initializes a new character with the specified name, title, health, and power.
     * Validates all input parameters to ensure they are valid before creation.
     * Sets initial fame to 0 and money to 100 gold. Maximum health is set equal to
     * the starting health value.
     * 
     * Validation rules:
     * - Name cannot be null or empty 
     * - Title cannot be null or empty 
     * - Health must be a positive integer 
     * - Power must be a positive integer 
     * 
     * If any validation fails, an IllegalArgumentException is thrown with a descriptive
     * error message explaining what went wrong.
     * 
     * @param name the character's name - must not be null or empty
     * @param title the character's title or class - must not be null or empty
     * @param health the starting health points - must be positive (> 0)
     * @param power the character's combat power/damage - must be positive (> 0)
     * 
     * @throws IllegalArgumentException if name or title is null/empty, or if health/power is not positive
     * 
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
     * Displays the character's complete profile information
     * 
     * Prints a formatted character profile displaying all current character statistics
     * including name, title, current and maximum health, power, fame, and money.
     * Output includes a formatted box for visual clarity.
     * 
     * Example output:
     * ========== CHARACTER PROFILE ==========
     * Name: Hero
     * Title: Knight
     * Health: 100/100
     * Power: 15
     * Fame: 0
     * Money: 100 gold
     * ========================================
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
     * Reduces character's health by the specified damage amount
     * 
     * Processes incoming damage during combat, reducing the character's current health.
     * The damage value is validated - negative damage is rejected. If the resulting health
     * would be negative, it is clamped to 0 (minimum value). The character can be killed
     * by damage that reduces health to 0 or below.
     * 
     * * Displays a message showing:
     * 1. Character name
     * 2. Amount of damage taken
     * 3. Current health after damage
     * 
     * Note: This method does not account for armor protection. Subclasses may override
     * this method to apply armor reduction to damage. Use after armor has been calculated.
     * 
     * @param damage the amount of damage to inflict on the character. Must be non-negative.
     *               If negative, an error message is displayed and nothing happens.
     * 
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
     * Restores the character's health by the specified amount
     * 
     * Increases the character's current health during or outside of combat. The heal amount
     * is validated - negative healing amounts are rejected. If the resulting health would
     * exceed maximum health, it is clamped to the maximum (no overheal).
     * 
     * @param amount the amount of health to restore. Must be non-negative.
     *               If negative, an error message is displayed and nothing happens.
     * 
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
     * Checks if the character is still alive
     * 
     * Returns whether the character can continue to participate in the game.
     * A character is alive if and only if their current health is greater than 0.
     * A character is dead if health is 0 or less.
     * 
     * This method is used to:
     * - Continue or end battle loops
     * - Display death messages
     * - Control game flow based on character status
     * 
     * @return true if health > 0 and character can continue fighting; 
     *         false if health <= 0 and character is dead
     * 
     */
    public boolean isAlive() {
        return this.health > 0;
    }
    
   
    // GETTERS AND SETTERS WITH COMPREHENSIVE EXCEPTION HANDLING

    
    /**
     * Gets the character's name
     * 
     * Returns the character's name string. If the name is null (shouldn't happen normally),
     * returns "Unknown" as a default value for safety.
     * 
     * @return the character's name, or "Unknown" if name is null
     * 
     */
    public String getName() {
        try {
            return this.name != null ? this.name : "Unknown";
        } catch (Exception e) {
            System.out.println("Error getting name: " + e.getMessage());
            return "Unknown";
        }
    }
    
    /**
     * Sets the character's name
     * 
     * Updates the character's name with validation. The name must not be null or empty
     * after trimming whitespace. If the name is invalid, an error message is displayed
     * and the name is not changed.
     * 
     * @param name the new name for the character - must not be null or empty
     * 
     * @throws IllegalArgumentException if name is null or empty
     * 
     */
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
    
    /**
     * Gets the character's title
     * 
     * Returns the character's title/class (e.g., "Knight", "Goblin"). If the title is null,
     * returns "Unknown" as a default value for safety.
     * 
     * @return the character's title, or "Unknown" if title is null
     * 
     */
    public String getTitle() {
        try {
            return this.title != null ? this.title : "Unknown";
        } catch (Exception e) {
            System.out.println("Error getting title: " + e.getMessage());
            return "Unknown";
        }
    }
    
    /**
     * Sets the character's title
     * 
     * Updates the character's title with validation. The title must not be null or empty
     * after trimming whitespace. If the title is invalid, an error message is displayed
     * and the title is not changed.
     * 
     * @param title the new title for the character - must not be null or empty
     * 
     * @throws IllegalArgumentException if title is null or empty
     * 
     */
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
    
    /**
     * Gets the character's current health
     * 
     * Returns the character's current health points. If health is negative (shouldn't happen),
     * returns 0 as a minimum value for safety.
     * 
     * @return the character's current health, or 0 if health is negative
     * 
     */
    public int getHealth() {
        try {
            return this.health >= 0 ? this.health : 0;
        } catch (Exception e) {
            System.out.println("Error getting health: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Gets the character's maximum health
     * 
     * Returns the maximum health points the character can have. This is set to the
     * starting health value when the character is created.
     * 
     * @return the character's maximum health points
     * 
     */
    public int getMaxHealth() {
        try {
            return this.maxHealth > 0 ? this.maxHealth : 1;
        } catch (Exception e) {
            System.out.println("Error getting max health: " + e.getMessage());
            return 1;
        }
    }
    
    /**
     * Gets the character's power/damage stat
     * 
     * Returns the character's power level which affects damage dealt in combat.
     * If power is invalid, returns 1 as a minimum value for safety.
     * 
     * @return the character's power stat, or 1 if power is invalid
     * 
     */
    public int getPower() {
        try {
            return this.power > 0 ? this.power : 1;
        } catch (Exception e) {
            System.out.println("Error getting power: " + e.getMessage());
            return 1;
        }
    }
    
    /**
     * Sets the character's power/damage stat
     * 
     * Updates the character's power with validation. Power must be positive (greater than 0).
     * If the power is invalid, an error message is displayed and the power is not changed.
     * 
     * @param power the new power stat - must be positive (> 0)
     * 
     * @throws IllegalArgumentException if power is not positive
     * 
     */
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
    
    /**
     * Gets the character's fame/reputation
     * 
     * Returns the character's current fame points. If fame is negative, returns 0.
     * Fame is gained by winning battles and other achievements.
     * 
     * @return the character's fame points (always non-negative)
     * 
     */
    public int getFame() {
        try {
            return this.fame >= 0 ? this.fame : 0;
        } catch (Exception e) {
            System.out.println("Error getting fame: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Sets the character's fame to a specific value
     * 
     * Directly sets the character's fame. If the value is negative, fame is set to 0
     * (fame cannot be negative). Otherwise, fame is set to the specified value.
     * 
     * @param fame the new fame value. Negative values are clamped to 0.
     * 
     */
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
    
    /**
     * Increases the character's fame by a specified amount
     * 
     * Adds the specified amount to the character's current fame. The amount must be
     * non-negative. Negative amounts are rejected with an error message.
     * 
     * Called when character:
     * - Wins a battle
     * - Buys drinks at the inn
     * - Completes achievements
     * 
     * @param amount the amount to add to fame - must be non-negative. 
     *               If negative, an error message is displayed and nothing happens.
     * 
     */
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
    
    /**
     * Gets the character's money/gold
     * 
     * Returns the character's current money amount. If money is negative, returns 0.
     * Money is used for buying items and transactions.
     * 
     * @return the character's money (always non-negative)
     *
     */
    public int getMoney() {
        try {
            return this.money >= 0 ? this.money : 0;
        } catch (Exception e) {
            System.out.println("Error getting money: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Sets the character's money to a specific value
     * 
     * Directly sets the character's money. If the value is negative, money is set to 0
     * (money cannot be negative). Otherwise, money is set to the specified value.
     * 
     * @param money the new money value. Negative values are clamped to 0.
     * 
     */
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
    
    /**
     * Increases the character's money by a specified amount
     * 
     * Adds the specified amount to the character's current money. The amount must be
     * non-negative. Negative amounts are rejected with an error message.
     * 
     * Called when character:
     * - Wins a battle and receives gold reward
     * - Sells items
     * - Wins a gambling game
     * 
     * @param amount the amount to add to money - must be non-negative.
     *               If negative, an error message is displayed and nothing happens.
     * 
     */
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
    
    /**
     * Decreases the character's money by a specified amount
     * 
     * Removes the specified amount from the character's current money. The amount must be
     * non-negative. If the character doesn't have enough money, nothing happens and an
     * error message is displayed. Negative amounts are rejected with an error message.
     * 
     * Called when character:
     * - Buys items from the shop
     * - Places a bet
     * - Performs transactions
     * 
     * Conditions checked:
     * - Amount must not be negative
     * - Character must have at least the specified amount of money
     * 
     * @param amount the amount to remove from money - must be non-negative and available.
     *               If negative, or if character doesn't have enough money, 
     *               an error message is displayed and nothing happens.
     *
     */
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