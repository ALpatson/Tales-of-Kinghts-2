/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tales.of.knights;

import tales.of.knights.game.TalesofKnights;

/**
 * Entry point for Tales of Knights
 * Launcher class
 */
public class Main {
    
    /**
     * Main method - Entry point
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            TalesofKnights game = new TalesofKnights();
            game.startGame();
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}
