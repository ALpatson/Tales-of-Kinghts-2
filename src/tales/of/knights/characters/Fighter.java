/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

import tales.of.knights.interfaces.Aggression;
import tales.of.knights.items.Weapon;
import tales.of.knights.items.Armor;
/**
 * Abstract Fighter class that extends Character
 * Represents a combat-capable character
 * @author cobbi
 */
public abstract class Fighter extends Character implements Aggression {
    
    protected Weapon weapon;
    protected Armor armor;
    
    /**
     * Constructor for Fighter
     * @param name fighter name
     * @param title fighter title
     * @param health fighter health
     * @param power fighter power
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
     * Attack with equipped weapon
     * @return damage dealt
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
     * Take damage considering armor
     * @param damage damage to take
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
     * Equip a weapon
     * @param weapon weapon to equip
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
     * Equip armor
     * @param armor armor to equip
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
     * Get current weapon
     * @return equipped weapon
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
     * Get current armor
     * @return equipped armor
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
     * Analyze an enemy
     * @param enemy enemy to analyze
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