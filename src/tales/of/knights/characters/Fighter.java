/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

import tales.of.knights.interfaces.Aggression;
import tales.of.knights.items.Weapon;
import tales.of.knights.items.Armor;

/**
 * Fighter Abstract Class - Adds Combat Abilities to Characters
 * 
 * The Fighter class represents any character that can engage in combat. It extends the Character
 * class with combat-specific functionality and implements the Aggression interface to enforce
 * combat behavior.
 * 
 * Think of Fighter as a step up from a basic Character - while all creatures in the world have
 * names, health, and basic stats, Fighters are those who can actively engage in battle. A Fighter
 * can equip weapons to increase their damage and armor to reduce incoming damage.
 * 
 * Key Capabilities:
 * - Attack enemies with optional weapon bonuses
 * - Defend with armor that reduces damage taken
 * - Analyze enemies before fighting them
 * - Equip and unequip weapons and armor dynamically during gameplay
 * 
 * Both the Hero (player) and Monster (enemies) extend this class, making them both combat-capable.
 * This design demonstrates polymorphism - the same attack() and takeDamage() methods work differently
 * for Heroes and Monsters, but through this class they share a common interface.
 * 
 * Equipment System:
 * - Weapons increase attack damage
 * - Armor reduces incoming damage
 * - Equipment can be changed anytime
 * - Null checks prevent crashes from missing equipment
 * 
 * Combat Flow:
 * 1. Fighter analyzes opponent (optional, to see their stats)
 * 2. Fighter attacks (damage = power + weapon bonus)
 * 3. Opponent takes damage (reduced by their armor)
 * 4. Repeat until someone dies
 * 
 * This is an abstract class and cannot be instantiated directly. You must create a concrete
 * subclass like Hero or Monster. The abstract methods are implemented by those subclasses.
 * 
 * @author cobbina
 * @version 1.3
 *
 * 
 */
public abstract class Fighter extends Character implements Aggression {
    
    /** The weapon currently equipped by this fighter - null if no weapon equipped */
    protected Weapon weapon;
    
    /** The armor currently equipped by this fighter - null if no armor equipped */
    protected Armor armor;
    
    /**
     * Creates a new Fighter character
     * 
     * Initializes a Fighter with the specified characteristics. The Fighter starts with no
     * equipment (weapon and armor are set to null). All other stats are inherited from the
     * Character constructor.
     * 
     * Think of this as: "I'm creating a warrior with a specific name, title, health, and power,
     * but they don't start with any equipment - they'll find that during the game."
     * 
     * The constructor validates all input through the parent Character class constructor,
     * ensuring that:
     * - Name and title are not empty
     * - Health and power are positive values
     * 
     * Example Usage:
     * This constructor is called by Hero and Monster classes:
     * - Hero("Aragorn", "Ranger", 100, 15) creates a hero ready for adventure
     * - Monster("Goblin", "Scout", 30, 8) creates an enemy to fight
     * 
     * @param name the fighter's name - who they are
     * @param title the fighter's title/class - what they are (e.g., "Knight", "Ogre")
     * @param health how many health points the fighter starts with
     * @param power how much base damage the fighter deals per attack
     * 
     * @throws IllegalArgumentException if name or title is empty, or health/power is invalid
     * 
     */
    public Fighter(String name, String title, int health, int power) {
        super(name, title, health, power);
        try {
            this.weapon = null;
            this.armor = null;
        } catch (Exception e) {
            System.out.println("Error initializing fighter: " + e.getMessage());
        }
    }
    
    /**
     * Performs an attack with optional weapon damage bonus
     * 
     * When a Fighter attacks, they deal damage equal to their base power plus any weapon damage
     * bonus. If no weapon is equipped, they deal just their base power as damage.
     * 
     * Damage Calculation:
     * - Base damage = Character's power stat
     * - Final damage = Base damage + (weapon damage if equipped)
     * 
     *  
     * Minimum Damage:
     * The method guarantees a minimum of 1 damage is always dealt, even if calculations
     * somehow result in 0 or negative values (which shouldn't happen normally).
     * 
     * Implementation Notes:
     * - Weapon null check prevents NullPointerException
     * - If weapon fails to load, falls back to power damage
     * - Catches all exceptions to ensure combat continues
     * 
     * @return the total damage this attack deals to the opponent. Always at least 1.
     * 
     * @throws NullPointerException caught and handled - returns base power if weapon null
     * 
     * @see #equipWeapon(Weapon)
     * @see #getWeapon()
     * @see tales.of.knights.characters.Monster#attack()
     * @see tales.of.knights.characters.Hero#attack()
     */
    @Override
    public int attack() {
        try {
            int baseDamage = this.power;
            int totalDamage = baseDamage;
            
            if (this.weapon != null) {
                totalDamage += this.weapon.getDamage();
                System.out.println(this.name + " attacks with " + this.weapon.getDescription() + " for " + totalDamage + " damage!");
            } else {
                System.out.println(this.name + " attacks for " + baseDamage + " damage!");
            }
            
            return totalDamage > 0 ? totalDamage : 1;
        } catch (NullPointerException e) {
            System.out.println("Error during attack: weapon is null");
            return this.power;
        } catch (Exception e) {
            System.out.println("Error during attack: " + e.getMessage());
            return this.power;
        }
    }
    
    /**
     * Takes damage while accounting for armor protection
     * 
     * When a Fighter takes damage, their armor reduces the incoming damage. The actual damage
     * taken is the incoming damage minus the armor's protection value.
     * 
     * Damage Reduction System:
     * - Incoming damage: What the attacker intended to deal
     * - Armor protection: How much the armor reduces (blocks)
     * - Actual damage: What really gets through (incoming - armor)
     * 
     * Example Scenarios:
     * - Fighter takes 30 damage with 5 armor → actual damage = 25
     * - Fighter takes 30 damage with no armor → actual damage = 30
     * - Fighter takes 30 damage with 50 armor → actual damage = 1 (minimum)
     * 
     * Minimum Damage:
     * Even with strong armor, at least 1 damage always gets through (unless armor is extremely
     * powerful). This prevents fighters from becoming completely invincible.
     * 
     * Display Messages:
     * If the fighter is wearing armor, a message shows how much damage was blocked:
     * - "Leather Armor reduces damage by 5!"
     * Then the standard damage message from the parent takeDamage() shows:
     * - "Hero takes 25 damage! (Health: 75)"
     * 
     * Implementation Notes:
     * - Armor null check prevents crashes
     * - Validates incoming damage is not negative
     * - Falls back to parent takeDamage if armor calculation fails
     * - Uses Math.max(1, ...) to ensure minimum 1 damage always
     * 
     * @param damage the incoming damage from the opponent - should be positive
     * 
     */
    @Override
    public void takeDamage(int damage) {
        try {
            if (damage < 0) {
                System.out.println("Error: Damage cannot be negative!");
                return;
            }
            
            int actualDamage = damage;
            
            if (this.armor != null) {
                int reduction = this.armor.getProtection();
                actualDamage = Math.max(1, damage - reduction);
                System.out.println(this.armor.getDescription() + " reduces damage by " + reduction + "!");
            }
            
            super.takeDamage(actualDamage);
        } catch (Exception e) {
            System.out.println("Error taking damage: " + e.getMessage());
            super.takeDamage(damage);
        }
    }
    
    /**
     * Equips a weapon to increase attack damage
     * 
     * Allows the Fighter to equip a new weapon. Once equipped, the weapon's damage bonus is
     * added to every attack this Fighter makes. Fighters can equip different weapons during
     * gameplay to switch tactics or use better equipment as they progress.
     * 
     * What Happens When You Equip:
     * 1. The weapon is validated (must not be null)
     * 2. The weapon is set as the active weapon
     * 3. A message displays the successful equipping
     * 
     * Example Messages:
     * - "Hero equipped Iron Sword (Damage: 20)"
     * - "Monster equipped Wooden Club (Damage: 5)"
     * 
     * Practical Usage:
     * - Pick up weapons during dungeon exploration
     * - Buy better weapons from the shop
     * - Switch weapons for different strategies
     * - Start with no weapon, gain weapon, get better weapon
     * 
     * Error Handling:
     * - If weapon is null, nothing happens and error message is displayed
     * - Null check prevents crashes
     * 
     * Multiple Equipments:
     * - Only ONE weapon can be equipped at a time
     * - Equipping a new weapon replaces the old one
     * - Dropped weapon is lost (not stored in inventory)
     * 
     * @param weapon the weapon to equip - must not be null
     *               Once equipped, this weapon's damage is added to attacks
     *
     */
    public void equipWeapon(Weapon weapon) {
        try {
            if (weapon == null) {
                System.out.println("Error: Cannot equip null weapon!");
                return;
            }
            
            this.weapon = weapon;
            System.out.println(this.name + " equipped " + weapon.getDescription());
        } catch (Exception e) {
            System.out.println("Error equipping weapon: " + e.getMessage());
        }
    }
    
    /**
     * Equips armor to reduce incoming damage
     * 
     * Allows the Fighter to equip armor for protection. Once equipped, the armor's protection
     * value reduces all incoming damage. Fighters can change armor during gameplay to adjust
     * their defensive strategy as they face tougher enemies.
     * 
     * What Happens When You Equip:
     * 1. The armor is validated (must not be null)
     * 2. The armor is set as the active armor
     * 3. A message displays the successful equipping
     * 
     * Example Messages:
     * - "Hero equipped Steel Armor (Protection: 10)"
     * - "Orc equipped Leather Armor (Protection: 5)"
     * 
     * Practical Usage:
     * - Equip light armor early game for basic protection
     * - Upgrade to heavy armor for dangerous dungeons
     * - Switch armor based on enemy types
     * - Balance offense and defense
     * 
     * How It Works In Combat:
     * - Incoming damage 30, armor protection 5 → actual damage 25
     * - Incoming damage 50, armor protection 10 → actual damage 40
     * - Incoming damage 20, armor protection 5 → actual damage 15
     * 
     * Error Handling:
     * - If armor is null, nothing happens and error message is displayed
     * - Null check prevents crashes
     * 
     * Multiple Equipments:
     * - Only ONE armor can be equipped at a time
     * - Equipping new armor replaces the old one
     * - Dropped armor is lost (not stored in inventory)
     * 
     * @param armor the armor to equip - must not be null
     *              Once equipped, this armor protects from incoming damage
     * 
     */
    public void equipArmor(Armor armor) {
        try {
            if (armor == null) {
                System.out.println("Error: Cannot equip null armor!");
                return;
            }
            
            this.armor = armor;
            System.out.println(this.name + " equipped " + armor.getDescription());
        } catch (Exception e) {
            System.out.println("Error equipping armor: " + e.getMessage());
        }
    }
    
    /**
     * Gets the currently equipped weapon
     * 
     * Returns the weapon this Fighter currently has equipped, or null if no weapon is equipped.
     * This method is useful for checking what weapon is active without actually using it.
     * 
     * Usage Examples:
     * - Check if Fighter has a weapon before battle
     * - Display current equipment to player
     * - Determine attack strategy based on weapon
     * - Verify equipment before combat starts
     * 
     * Return Values:
     * - Returns a Weapon object if weapon is equipped
     * - Returns null if no weapon is equipped
     * 
     * Example:
     * if (hero.getWeapon() != null) {
     *     System.out.println("Hero is armed with: " + hero.getWeapon().getDescription());
     * } else {
     *     System.out.println("Hero is unarmed!");
     * }
     * 
     * @return the equipped Weapon, or null if none is equipped
     * 
     * @see #equipWeapon(Weapon)
     * @see #attack()
     */
    public Weapon getWeapon() {
        try {
            return this.weapon;
        } catch (Exception e) {
            System.out.println("Error getting weapon: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Gets the currently equipped armor
     * 
     * Returns the armor this Fighter currently has equipped, or null if no armor is equipped.
     * This method is useful for checking defensive equipment without modifying it.
     * 
     * Usage Examples:
     * - Check if Fighter has armor before battle
     * - Display current armor to player
     * - Calculate total protection
     * - Verify defenses before combat
     * 
     * Return Values:
     * - Returns an Armor object if armor is equipped
     * - Returns null if no armor is equipped
     * 
     * Example:
     * if (hero.getArmor() != null) {
     *     System.out.println("Hero is wearing: " + hero.getArmor().getDescription());
     * } else {
     *     System.out.println("Hero is unprotected!");
     * }
     * 
     * @return the equipped Armor, or null if none is equipped
     * 
     */
    public Armor getArmor() {
        try {
            return this.armor;
        } catch (Exception e) {
            System.out.println("Error getting armor: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Analyzes an opponent to view their combat statistics
     * 
     * Displays detailed information about an opponent fighter without engaging in combat.
     * This is a "look before you leap" feature that lets you scout an enemy before fighting.
     * 
     * Information Displayed:
     * - Enemy's name: Who/what you're facing
     * - Enemy's health: How much damage you need to deal to win
     * - Enemy's maximum health: Their full capacity (useful to estimate difficulty)
     * - Enemy's power: How much damage they can deal per attack
     * 
     * Example Display:
     * ========== ENEMY ANALYSIS ==========
     * Name: Goblin
     * Health: 30/30
     * Power: 10
     * ====================================
     * 
     * Strategic Uses:
     * - Decide if you're strong enough to fight this enemy
     * - Plan equipment upgrades before facing dangerous foes
     * - Learn enemy weaknesses (higher power = harder hits)
     * - Build tactics based on opponent strength
     * 
     * When to Use:
     * - During battle when you encounter a new enemy
     * - Before engaging a mysterious opponent
     * - To confirm you're ready for a challenge
     * 
     * Safe Combat Flow:
     * 1. Analyze the enemy (you're trying to defeat)
     * 2. Decide if you're ready
     * 3. If ready: Attack and fight
     * 4. If not ready: Escape or prepare better
     * 
     * Note: This is a passive action - the enemy doesn't attack while you analyze.
     * 
     * @param enemy the opponent Fighter to analyze - must not be null
     *              This should be the enemy you're about to fight
     * 
     */
    public void analyzeEnemy(Fighter enemy) {
        try {
            if (enemy == null) {
                System.out.println("Error: Enemy is null!");
                return;
            }
            
            System.out.println("\n========== ENEMY ANALYSIS ==========");
            System.out.println("Name: " + enemy.getName());
            System.out.println("Health: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
            System.out.println("Power: " + enemy.getPower());
            System.out.println("====================================\n");
        } catch (Exception e) {
            System.out.println("Error analyzing enemy: " + e.getMessage());
        }
    }
}