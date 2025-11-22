/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;
import tales.of.knights.characters.Shopkeeper;

/**
 * Town Class - Safe Hub Location with Shopkeeper
 * 
 * Extends Place to represent the main town where players can rest, buy/sell items,
 * and interact with NPCs. The town is a safe haven from dungeon combat.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Place
 * @see Dungeon
 * @see Shopkeeper
 */
public class Town extends Place {
    
    /** The town's shopkeeper who sells and buys items */
    private Shopkeeper shopkeeper;
    
    /**
     * Creates a new Town location
     * 
     * Initializes the town with a shopkeeper who manages the shop.
     */
    public Town() {
        super("Town", "A bustling town with shops and an inn");
        try {
            this.shopkeeper = new Shopkeeper("Merchant");
        } catch (Exception e) {
            System.out.println("Error creating town: " + e.getMessage());
            this.shopkeeper = new Shopkeeper("Merchant");
        }
    }
    
    /**
     * Gets the town's shopkeeper
     * 
     * @return the Shopkeeper NPC who runs the shop
     */
    public Shopkeeper getShopkeeper() {
        try {
            if (this.shopkeeper == null) {
                this.shopkeeper = new Shopkeeper("Merchant");
            }
            return this.shopkeeper;
        } catch (Exception e) {
            System.out.println("Error getting shopkeeper: " + e.getMessage());
            return new Shopkeeper("Merchant");
        }
    }
    
    /**
     * Displays the town information
     * 
     * Shows town name and description to the player.
     */
    @Override
    public void display() {
        try {
            System.out.println("\n========== " + this.name.toUpperCase() + " ==========");
            System.out.println(this.description);
            System.out.println("=====================================\n");
        } catch (Exception e) {
            System.out.println("Error displaying town: " + e.getMessage());
        }
    }
}