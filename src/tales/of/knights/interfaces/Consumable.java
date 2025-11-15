/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tales.of.knights.interfaces;


import tales.of.knights.characters.Character;
/**
 *Interface for items that can be consumed
 *Represents items that can be used and have effects
 * @author cobbi
 */

public interface Consumable {
    
    /**
     * Use the consumable item on a character
     * @param character the character to affect
     */
    void use(Character character);
    
    /**
     * Get the description of the item's effect
     * @return description string
     */
    String getDescription();
}