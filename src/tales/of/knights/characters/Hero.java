/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

import tales.of.knights.items.Item;
import tales.of.knights.items.ItemBag;
import tales.of.knights.interfaces.Consumable;

/**
 * Hero class - the main player character
 * Extends Fighter with inventory management
 */
public class Hero extends Fighter {
    
    private ItemBag itemBag;
    
    /**
     * Constructor for Hero
     * @param name hero name
     * @param title hero title
     * @param health starting health
     * @param power starting power
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
     * Get the item bag
     * @return item bag
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
     * Use an item from inventory
     * @param index item index
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
     * Buy an item
     * @param item item to buy
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
     * Sell an item
     * @param index item index
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
     * Escape from battle
     * @return true if escape successful
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
     * Rest and recover health
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
   