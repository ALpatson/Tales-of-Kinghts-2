/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

import tales.of.knights.items.Item;
import tales.of.knights.items.ItemBag;
import tales.of.knights.interfaces.Consumable;

/**
 * Hero Class - The Player Character
 * 
 * Extends Fighter with inventory management and player-specific abilities.
 * The Hero is the player-controlled character that participates in combat,
 * collects items, and progresses through the game.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Fighter
 * @see ItemBag
 * @see Consumable
 */
public class Hero extends Fighter {
    
    /** Inventory that stores items the hero collects */
    private ItemBag itemBag;
    
    /**
     * Creates a new Hero character
     * 
     * @param name the hero's name
     * @param title the hero's title/class
     * @param health starting health points
     * @param power starting attack power
     */
    public Hero(String name, String title, int health, int power) {
        super(name, title, health, power);
        try {
            this.itemBag = new ItemBag();
        } catch (Exception e) {
            System.out.println("Error creating hero: " + e.getMessage());
            this.itemBag = new ItemBag();
        }
    }
    
    /**
     * Gets the hero's inventory
     * 
     * @return the ItemBag containing all collected items
     */
    public ItemBag getItemBag() {
        try {
            if (this.itemBag == null) {
                this.itemBag = new ItemBag();
            }
            return this.itemBag;
        } catch (Exception e) {
            System.out.println("Error getting item bag: " + e.getMessage());
            return new ItemBag();
        }
    }
    
    /**
     * Uses a consumable item from inventory
     * 
     * Removes the item from inventory after use. Only works with Consumable items
     * like healing potions or damage boosters.
     * 
     * @param index the position of the item in inventory
     */
    public void useItem(int index) {
        try {
            if (this.itemBag == null) {
                System.out.println("Error: Item bag is null!");
                return;
            }
            
            if (index < 0) {
                System.out.println("Error: Item index cannot be negative!");
                return;
            }
            
            Item item = this.itemBag.getItem(index);
            
            if (item == null) {
                System.out.println("Error: Item not found!");
                return;
            }
            
            if (item instanceof Consumable consumable) {
                consumable.use(this);
                this.itemBag.removeItem(index);
            } else {
                System.out.println("Cannot use that item!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid item index!");
        } catch (ClassCastException e) {
            System.out.println("Error: Item type mismatch!");
        } catch (Exception e) {
            System.out.println("Error using item: " + e.getMessage());
        }
    }
    
    /**
     * Purchases an item and adds it to inventory
     * 
     * Deducts gold from hero's money and adds item to inventory.
     * Fails if hero doesn't have enough gold.
     * 
     * @param item the item to purchase - must not be null
     */
    public void buy(Item item) {
        try {
            if (item == null) {
                System.out.println("Error: Item is null!");
                return;
            }
            
            int itemValue = item.getValue();
            
            if (itemValue < 0) {
                System.out.println("Error: Invalid item value!");
                return;
            }
            
            if (this.money < itemValue) {
                System.out.println("You don't have enough money! Need " + itemValue + ", have " + this.money);
                return;
            }
            
            this.removeMoney(itemValue);
            this.itemBag.addItem(item);
            System.out.println("You bought " + item.getDescription() + " for " + itemValue + " gold!");
        } catch (Exception e) {
            System.out.println("Error buying item: " + e.getMessage());
        }
    }
    
    /**
     * Sells an item from inventory
     * 
     * Removes item from inventory and adds gold to hero's money.
     * 
     * @param index the position of the item to sell in inventory
     */
    public void sell(int index) {
        try {
            if (index < 0) {
                System.out.println("Error: Invalid item index!");
                return;
            }
            
            if (this.itemBag == null) {
                System.out.println("Error: Item bag is null!");
                return;
            }
            
            Item item = this.itemBag.getItem(index);
            
            if (item == null) {
                System.out.println("Error: Item not found!");
                return;
            }
            
            int itemValue = item.getValue();
            
            if (itemValue < 0) {
                System.out.println("Error: Invalid item value!");
                return;
            }
            
            this.addMoney(itemValue);
            this.itemBag.removeItem(index);
            System.out.println("You sold " + item.getDescription() + " for " + itemValue + " gold!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Item index out of range!");
        } catch (Exception e) {
            System.out.println("Error selling item: " + e.getMessage());
        }
    }
    
    /**
     * Attempts to escape from battle
     * 
     * 30% chance of successful escape. If successful, hero avoids combat.
     * If failed, hero stays in battle.
     * 
     * @return true if escape was successful, false if failed
     */
    public boolean escape() {
        try {
            double escapeChance = 0.3; // 30% chance
            double random = Math.random();
            
            if (random < escapeChance) {
                System.out.println(this.name + " successfully escaped!");
                return true;
            } else {
                System.out.println(this.name + " failed to escape!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error during escape: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Rests at an inn to recover health
     * 
     * Recovers 50 health points (capped at maximum health).
     * Used when hero needs healing between battles.
     */
    public void rest() {
        try {
            int healAmount = 50;
            
            if (healAmount < 0) {
                System.out.println("Error: Invalid heal amount!");
                return;
            }
            
            this.heal(healAmount);
            System.out.println(this.name + " rests and recovers.");
        } catch (Exception e) {
            System.out.println("Error resting: " + e.getMessage());
        }
    }
}