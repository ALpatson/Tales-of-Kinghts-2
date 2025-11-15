/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.places;

import tales.of.knights.characters.Shopkeeper;

/**
 * Town class - represents the town location
 * Extends Place
 */
public class Town extends Place {
    
    private Shopkeeper shopkeeper;
    
    /**
     * Constructor for Town
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
     * Get the shopkeeper
     * @return shopkeeper
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
     * Display the town
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
