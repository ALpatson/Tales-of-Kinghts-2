/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.items;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemBag class - manages inventory of items
 */
public class ItemBag {
    
    private List<Item> items;
    private static final int MAX_ITEMS = 8;
    
    /**
     * Constructor for ItemBag
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
     * Add an item to the bag
     * @param item item to add
     * @return true if successful
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
     * Get an item from the bag
     * @param index item index
     * @return item or null
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
     * Remove an item from the bag
     * @param index item index
     * @return true if successful
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
     * Get the number of items in the bag
     * @return item count
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
     * Display all items in the bag
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
     * Clear all items from the bag
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