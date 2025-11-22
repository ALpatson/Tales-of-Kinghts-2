/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemBag Class - Inventory Management System
 * 
 * Manages a collection of items that a character carries. Has a maximum
 * capacity of 8 items. Supports adding, removing, and retrieving items.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Item
 * @see Hero
 * @see Shopkeeper
 */
public class ItemBag {
    
    /** List of items in the bag */
    private List<Item> items;
    
    /** Maximum capacity - bag can hold up to 8 items */
    private static final int MAX_ITEMS = 8;
    
    /**
     * Creates a new empty ItemBag
     * 
     * Initializes an empty inventory ready to store items.
     */
    public ItemBag() {
        try {
            this.items = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error creating item bag: " + e.getMessage());
            this.items = new ArrayList<>();
        }
    }
    
    /**
     * Adds an item to the bag
     * 
     * Fails if bag is full (max 8 items) or item is null.
     * 
     * @param item the item to add - must not be null
     * @return true if item was successfully added, false if bag is full or error
     */
    public boolean addItem(Item item) {
        try {
            if (item == null) {
                System.out.println("Error: Cannot add null item!");
                return false;
            }
            
            if (this.items == null) {
                this.items = new ArrayList<>();
            }
            
            if (this.items.size() >= MAX_ITEMS) {
                System.out.println("Error: Your bag is full! Maximum " + MAX_ITEMS + " items.");
                return false;
            }
            
            this.items.add(item);
            System.out.println("Added " + item.getDescription() + " to inventory.");
            return true;
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: Cannot modify item list!");
            return false;
        } catch (Exception e) {
            System.out.println("Error adding item: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Gets an item from the bag by index
     * 
     * @param index the position of the item (0-7)
     * @return the Item at that index, or null if invalid index
     */
    public Item getItem(int index) {
        try {
            if (this.items == null) {
                System.out.println("Error: Item bag is null!");
                return null;
            }
            
            if (index < 0 || index >= this.items.size()) {
                System.out.println("Error: Invalid item index! Valid range: 0-" + (this.items.size() - 1));
                return null;
            }
            
            return this.items.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Item index out of bounds!");
            return null;
        } catch (Exception e) {
            System.out.println("Error getting item: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Removes an item from the bag by index
     * 
     * @param index the position of the item to remove
     * @return true if item was successfully removed, false if invalid index
     */
    public boolean removeItem(int index) {
        try {
            if (this.items == null) {
                System.out.println("Error: Item bag is null!");
                return false;
            }
            
            if (index < 0 || index >= this.items.size()) {
                System.out.println("Error: Invalid item index!");
                return false;
            }
            
            Item removed = this.items.remove(index);
            System.out.println("Removed " + removed.getDescription() + " from inventory.");
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Item index out of range!");
            return false;
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: Cannot modify item list!");
            return false;
        } catch (Exception e) {
            System.out.println("Error removing item: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Gets the number of items currently in the bag
     * 
     * @return the count of items (0-8)
     */
    public int getItemCount() {
        try {
            if (this.items == null) {
                return 0;
            }
            return this.items.size();
        } catch (Exception e) {
            System.out.println("Error getting item count: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Displays all items in the inventory
     * 
     * Shows a formatted list of all items with their positions.
     */
    public void displayInventory() {
        try {
            if (this.items == null || this.items.isEmpty()) {
                System.out.println("\nYour inventory is empty!");
                return;
            }
            
            System.out.println("\n========== INVENTORY ==========");
            for (int i = 0; i < this.items.size(); i++) {
                Item item = this.items.get(i);
                if (item != null) {
                    System.out.println(i + ": " + item.getDescription());
                }
            }
            System.out.println("===============================\n");
        } catch (Exception e) {
            System.out.println("Error displaying inventory: " + e.getMessage());
        }
    }
    
    /**
     * Clears all items from the bag
     * 
     * Removes every item, leaving the bag empty.
     */
    public void clear() {
        try {
            if (this.items != null) {
                this.items.clear();
            }
        } catch (Exception e) {
            System.out.println("Error clearing inventory: " + e.getMessage());
        }
    }
}