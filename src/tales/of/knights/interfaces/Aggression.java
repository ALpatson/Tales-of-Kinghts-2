/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tales.of.knights.interfaces;

/**
 * Interface for characters that can attack
 * Represents aggressive behavior in combat
 * @author cobbina
 */
public interface Aggression {
    
    /**
     * Attack method for aggressive characters
     * @return damage dealt by the attack
     */
    int attack();
    
    /**
     * Take damage from an attack
     * @param damage amount of damage to take
     */
    void takeDamage(int damage);
    
    /**
     * Check if character is still alive
     * @return true if alive, false if dead
     */
    boolean isAlive();
}
