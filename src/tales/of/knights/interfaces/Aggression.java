/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tales.of.knights.interfaces;

/**
 * Aggression Interface - Defines combat behaviour for all fighting characters
 * This interface establishes a contract for any character class that participates in combat.
 * It enforces the implementation of three essential combat methods: attack, takeDamage, and isAlive.
 * 
 * Classes implementing this interface (Hero and Monster) must provide their own implementations
 * of these methods, allowing for different combat behaviors while maintaining a consistent interface.
 * 
 * The Aggression interface is central to the combat system in Tales of Knights, enabling
 * polymorphic behaviour where different character types can be treated uniformly during battle.
 * 
 * @author cobbina
 * @version 1.3
 * 
 */
public interface Aggression {
    
    /**
     * Performs an attack action during combat
     * 
     * This method calculates and returns the damage dealt to an opponent based on the
     * character's power attribute and any equipment bonuses (such as weapons). 
     * The implementing class determines how damage is calculated, allowing different 
     * character types to have different attack mechanics.
     * 
     * For Hero: Calculates damage based on power + weapon bonus + random variance (0-10)
     * For Monster: Calculates damage based on power + random variance (0-10)
     * 
     * @return the total damage dealt to the target, always a positive integer
     */
    int attack();
    
    /**
     * Receives and processes damage during combat
     * 
     * This method represents a character taking damage from an opponent's attack.
     * The character's health is reduced by the specified damage amount, accounting for
     * armor protection if the character is wearing armor. The actual damage reduction
     * depends on the implementing class and its armor value.
     * 
     * For Hero: Reduces health by (damage - armor), minimum 0 damage
     * For Monster: Reduces health by (damage - armor), minimum 0 damage
     * 
     * After taking damage, the character remains alive if health is still above 0,
     * and dies if health reaches or drops below 0. The character will not continue
     * to lose health if already dead.
     * 
     * @param damage the amount of damage to inflict on the character. Should be a 
     *               positive integer. If negative, behavior is undefined.
     *
     */
    void takeDamage(int damage);
    
    /**
     * Checks if the character is still alive in combat
     * 
     * This method returns whether the character can continue to participate in combat.
     * A character is considered alive if their health is greater than 0. A character
     * is dead (not alive) when their health reaches or falls below 0.
     * 
     * This method is essential for controlling the game loop - battles continue while
     * both participants are alive, and end when either combatant dies.
     * 
     * @return true if the character's health is greater than 0 and they can continue
     *         to fight; false if the character is dead (health <= 0) and cannot continue
     */
    boolean isAlive();
}