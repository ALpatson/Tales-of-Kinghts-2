/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.characters;

import tales.of.knights.items.*;

/**
 * Shopkeeper Class - Merchant NPC
 * 
 * Extends Villager to provide shopping services. The shopkeeper manages a shop
 * inventory and sells items to the hero. Each item type has different variants.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Villager
 * @see Hero
 * @see ItemBag
 */
public class Shopkeeper extends Villager {
    
    /** Shop inventory containing items for sale */
    private ItemBag shop;
    
    /**
     * Creates a new Shopkeeper NPC
     * 
     * Initializes a shopkeeper with starting inventory of weapons, armor,
     * healing items, and damage items.
     * 
     * @param name the shopkeeper's name
     */
    public Shopkeeper(String name) {
        super(name, "Merchant", "Shopkeeper");
        try {
            this.shop = new ItemBag();
            initializeShop();
        } catch (Exception e) {
            System.out.println("Error creating shopkeeper: " + e.getMessage());
            this.shop = new ItemBag();
        }
    }
    
    /**
     * Initializes shop with starting items
     * 
     * Adds weapons, armor, healing items, and damage items to shop inventory.
     */
    private void initializeShop() {
        try {
            this.shop.addItem(new Weapon("Iron Sword", 20, 50));
            this.shop.addItem(new Weapon("Steel Sword", 30, 75));
            this.shop.addItem(new Armor("Leather Armor", 5, 40));
            this.shop.addItem(new Armor("Steel Armor", 10, 60));
            this.shop.addItem(new HealingItem("Health Potion", 25, 3, 25));
            this.shop.addItem(new HealingItem("Greater Potion", 50, 5, 40));
            this.shop.addItem(new DamageItem("Explosive Bomb", 25, 30));
        } catch (Exception e) {
            System.out.println("Error initializing shop: " + e.getMessage());
        }
    }
    
    /**
     * Displays shop menu and available categories
     * 
     * Shows options to buy weapons, armor, potions, or damage items.
     */
    public void displayShop() {
        try {
            System.out.println("\n========== GENERAL SHOP ==========");
            System.out.println("Welcome to the shop!");
            System.out.println("1. Buy Weapon");
            System.out.println("2. Buy Armor");
            System.out.println("3. Buy Healing Item");
            System.out.println("4. Buy Damage Item");
            System.out.println("5. Sell Item");
            System.out.println("6. Leave Shop");
            System.out.println("=================================\n");
        } catch (Exception e) {
            System.out.println("Error displaying shop: " + e.getMessage());
        }
    }
    
    /**
     * Gets an item from the shop inventory
     * 
     * Returns the item at the specified index, or null if not found.
     * 
     * @param index the position of the item in shop inventory
     * @return the Item at that index, or null if invalid index
     */
    public Item getShopItem(int index) {
        try {
            if (this.shop == null) {
                System.out.println("Error: Shop is null!");
                return null;
            }
            
            if (index < 0) {
                System.out.println("Error: Index cannot be negative!");
                return null;
            }
            
            return this.shop.getItem(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Item index out of range!");
            return null;
        } catch (Exception e) {
            System.out.println("Error getting shop item: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Sells an item to the hero
     * 
     * Creates an item based on type and sells it to the hero if they have
     * enough gold. Item types: "weapon", "armor", "healing", "damage".
     * 
     * @param hero the player making the purchase
     * @param itemType the type of item to sell ("weapon", "armor", etc.)
     */
    public void sellItem(Hero hero, String itemType) {
        try {
            if (hero == null) {
                System.out.println("Error: Hero is null!");
                return;
            }
            
            if (itemType == null || itemType.trim().isEmpty()) {
                System.out.println("Error: Item type is invalid!");
                return;
            }
            
            Item item = null;
            
            switch (itemType.toLowerCase()) {
                case "weapon" -> item = new Weapon("Iron Sword", 20, 50);
                case "armor" -> item = new Armor("Leather Armor", 5, 40);
                case "healing" -> item = new HealingItem("Health Potion", 25, 3, 25);
                case "damage" -> item = new DamageItem("Explosive Bomb", 25, 30);
                default -> {
                    System.out.println("Error: Unknown item type!");
                    return;
                }
            }
            
            if (item == null) {
                System.out.println("Error: Could not create item!");
                return;
            }
            
            hero.buy(item);
        } catch (Exception e) {
            System.out.println("Error selling item: " + e.getMessage());
        }
    }
}