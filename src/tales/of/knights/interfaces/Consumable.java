/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tales.of.knights.interfaces;
import tales.of.knights.characters.Character;

/**
 * Consumable Interface - Defines behavior for one-time use items in Tales of Knights
 * 
 * This interface establishes a contract for any item that can be consumed or used
 * by a character during gameplay. Consumable items are items with temporary effects
 * that are consumed (used up) when activated, such as healing potions, damage-boosting
 * explosives, or other utility items.
 * 
 * Unlike equipment items (weapons and armor) which provide passive bonuses, consumable
 * items must be explicitly used and have immediate, one-time effects on the target character.
 * After being used, the item is typically removed from the player's inventory.
 * 
 * Classes implementing this interface (HealingItem and DamageItem) must provide their own
 * implementations of the use() and getDescription() methods, allowing for different item
 * effects while maintaining a consistent interface for item usage.
 * 
 * The Consumable interface works with the Aggression interface to enable item usage during
 * combat, allowing characters to drink potions, use explosives, and interact with consumable
 * items throughout the game.
 * 
 * @author cobbina
 * @version 1.3
 *
 */
public interface Consumable {
    
    /**
     * Activates the consumable item's effect on a target character
     * 
     * This method applies the item's effect to the specified character. The exact effect
     * depends on the implementing class - healing items restore health, damage items boost
     * attack power, etc.
     * 
     * When a character uses a consumable item:
     * 1. The item's use() method is called with the character as the target
     * 2. The item applies its effect (such as adding health or boosting power)
     * 3. The item is removed from the character's inventory (handled by ItemBag)
     * 4. A message is displayed to inform the player of the effect
     * 
     * For HealingItem: Restores a specified amount of health to the character
     * For DamageItem: Temporarily boosts the character's power/damage for the next attack
     * 
     * @param character the character to apply the item's effect to. Cannot be null.
     *                  The character's stats will be modified based on the item type.
     * 
     * @throws NullPointerException if character is null
     *
     */
    void use(Character character);
    
    /**
     * Retrieves a description of the item's effect and purpose
     * 
     * This method returns a string that describes what the item does when used.
     * The description is displayed in the inventory and shop to help the player
     * understand the item's effects before using or purchasing it.
     * 
     * Example descriptions:
     * - "Restores 25 health points"
     * - "Boosts attack power by 25 for next attack"
     * - "Recovers 50 health points"
     * 
     * The description should be clear, concise, and informative so players can
     * make informed decisions about which consumable items to use during gameplay.
     * 
     * @return a string describing the consumable item's effect and benefits.
     *         Never null or empty.
     * 
     */
    String getDescription();
}