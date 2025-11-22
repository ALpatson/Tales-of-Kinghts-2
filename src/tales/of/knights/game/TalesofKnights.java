/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tales.of.knights.game;

import java.util.Scanner;
import tales.of.knights.characters.Hero;
import tales.of.knights.characters.Monster;
import tales.of.knights.characters.Shopkeeper;
import tales.of.knights.characters.Gambler;
import tales.of.knights.places.Town;
import tales.of.knights.places.Dungeon;
import tales.of.knights.places.Room;
import tales.of.knights.items.*;

/**
 * TalesofKnights Main Game Controller
 * 
 * Main game class that manages the overall game flow, menus, and combat system.
 * Handles player interaction, game state, and all major gameplay features including
 * town exploration, dungeon combat, shopping, gambling, and inventory management.
 * 
 * @author cobbina
 * @version 1.0
 * 
 * @see Hero
 * @see Monster
 * @see Town
 * @see Dungeon
 */
public class TalesofKnights {
    
    /** The player character controlled by the user */
    private Hero player;
    
    /** Scanner for handling user input from console */
    private Scanner scanner;
    
    /** The safe town location with shops and inn */
    private Town town;
    
    /** The dangerous dungeon with multiple combat levels */
    private Dungeon dungeon;
    
    /** Flag indicating if the game is currently running */
    private boolean gameRunning;
    
    /** Flag indicating if a battle is currently in progress */
    private boolean inBattle;
    
    /** Flag indicating if we're in New Game+ mode (harder difficulty) */
    private boolean isNewGamePlus;
    
    /**
     * Creates a new TalesofKnights game instance
     * 
     * Initializes the game world with scanner, town, dungeon, and game state flags.
     */
    public TalesofKnights() {
        try {
            this.scanner = new Scanner(System.in);
            this.town = new Town();
            this.dungeon = new Dungeon();
            this.gameRunning = true;
            this.inBattle = false;
            this.isNewGamePlus = false;
        } catch (Exception e) {
            System.out.println("Error initializing game: " + e.getMessage());
        }
    }
    
    /**
     * Starts the game and creates the player character
     * 
     * Displays welcome screen, prompts for character name and title,
     * creates the player, and begins the main game loop.
     */
    public void startGame() {
        try {
            System.out.println("\n════════════════════════════════════════════════════");
            System.out.println("║        WELCOME TO TALES OF KNIGHTS         ║");
            System.out.println("║      A Text-Based Fantasy Adventure        ║");
            System.out.println("════════════════════════════════════════════════════\n");
            
            System.out.print("Enter your character's name: ");
            String name = scanner.nextLine();
            
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Error: Name cannot be empty!");
                name = "Hero";
            }
            
            System.out.print("Enter your character's title: ");
            String title = scanner.nextLine();
            
            if (title == null || title.trim().isEmpty()) {
                System.out.println("Error: Title cannot be empty!");
                title = "Adventurer";
            }
            
            this.player = new Hero(name, title, 100, 15);
            
            if (this.player != null) {
                this.player.introduce();
                gameLoop();
            }
        } catch (Exception e) {
            System.out.println("Error starting game: " + e.getMessage());
        }
    }
    
    /**
     * Main game loop that displays menu and handles player choices
     * 
     * Continues until player quits or dies. Offers options to visit town,
     * enter dungeon, check status, view inventory, or quit.
     */
    private void gameLoop() {
        try {
            while (this.gameRunning && this.player != null && this.player.isAlive()) {
                try {
                    System.out.println("========== MAIN MENU ==========");
                    System.out.println("1. Go to Town");
                    System.out.println("2. Enter Dungeon");
                    System.out.println("3. Check Status");
                    System.out.println("4. Check Inventory");
                    System.out.println("5. Quit Game");
                    System.out.println("==============================\n");
                    
                    System.out.print("Choose an option: ");
                    String choice = scanner.nextLine();
                    
                    if (choice == null || choice.trim().isEmpty()) {
                        System.out.println("Error: Please enter a valid option.\n");
                        continue;
                    }
                    
                    switch (choice.trim()) {
                        case "1":
                            townMenu();
                            break;
                        case "2":
                            dungeonMenu();
                            break;
                        case "3":
                            if (this.player != null) {
                                this.player.introduce();
                            }
                            break;
                        case "4":
                            if (this.player != null) {
                                this.player.getItemBag().displayInventory();
                            }
                            break;
                        case "5":
                            endGame();
                            break;
                        default:
                            System.out.println("Error: Invalid choice. Please enter 1-5.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Error in game loop: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error in main game loop: " + e.getMessage());
        }
    }
    
    /**
     * Town menu with options to shop, visit inn, rest, or leave
     * 
     * Provides access to town features including the shop and inn.
     */
    private void townMenu() {
        try {
            if (this.player == null || this.town == null) {
                System.out.println("Error: Town or player is null!");
                return;
            }
            
            boolean inTown = true;
            
            while (inTown && this.player.isAlive()) {
                try {
                    System.out.println("\n========== TOWN MENU ==========");
                    System.out.println("1. Visit Shop");
                    System.out.println("2. Visit Inn");
                    System.out.println("3. Rest at Inn");
                    System.out.println("4. Leave Town");
                    System.out.println("==============================\n");
                    
                    System.out.print("Choose an option: ");
                    String choice = scanner.nextLine();
                    
                    if (choice == null || choice.trim().isEmpty()) {
                        System.out.println("Error: Please enter a valid option.\n");
                        continue;
                    }
                    
                    switch (choice.trim()) {
                        case "1":
                            shopMenu();
                            break;
                        case "2":
                            innMenu();
                            break;
                        case "3":
                            this.player.rest();
                            break;
                        case "4":
                            inTown = false;
                            break;
                        default:
                            System.out.println("Error: Invalid choice.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Error in town menu: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error accessing town: " + e.getMessage());
        }
    }
    
    /**
     * Shop menu for buying and selling items
     * 
     * Allows purchasing weapons, armor, healing items, and damage items,
     * plus selling items from inventory.
     */
    private void shopMenu() {
        try {
            if (this.player == null || this.town == null) {
                System.out.println("Error: Cannot access shop!");
                return;
            }
            
            Shopkeeper shopkeeper = this.town.getShopkeeper();
            if (shopkeeper == null) {
                System.out.println("Error: Shopkeeper not found!");
                return;
            }
            
            boolean inShop = true;
            
            while (inShop) {
                try {
                    shopkeeper.displayShop();
                    System.out.print("Choose an option: ");
                    String choice = scanner.nextLine();
                    
                    if (choice == null || choice.trim().isEmpty()) {
                        System.out.println("Error: Please enter a valid option.\n");
                        continue;
                    }
                    
                    switch (choice.trim()) {
                        case "1":
                            shopkeeper.sellItem(this.player, "weapon");
                            break;
                        case "2":
                            shopkeeper.sellItem(this.player, "armor");
                            break;
                        case "3":
                            shopkeeper.sellItem(this.player, "healing");
                            break;
                        case "4":
                            shopkeeper.sellItem(this.player, "damage");
                            break;
                        case "5":
                            sellMenu();
                            break;
                        case "6":
                            inShop = false;
                            break;
                        default:
                            System.out.println("Error: Invalid choice.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Error in shop: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error accessing shop: " + e.getMessage());
        }
    }
    
    /**
     * Sell menu for trading inventory items for gold
     * 
     * Displays inventory and allows player to select items to sell.
     */
    private void sellMenu() {
        try {
            if (this.player == null) {
                System.out.println("Error: Player is null!");
                return;
            }
            
            this.player.getItemBag().displayInventory();
            System.out.print("Select item to sell (number): ");
            
            try {
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    System.out.println("Cancelled.\n");
                    return;
                }
                
                int itemIndex = Integer.parseInt(input.trim());
                this.player.sell(itemIndex);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!\n");
            }
        } catch (Exception e) {
            System.out.println("Error in sell menu: " + e.getMessage());
        }
    }
    
    /**
     * Inn menu with drinking and gambling options
     * 
     * Allows player to buy drinks for fame or gamble for gold.
     */
    private void innMenu() {
        try {
            if (this.player == null) {
                System.out.println("Error: Player is null!");
                return;
            }
            
            Gambler gambler = new Gambler("Lucky");
            boolean inInn = true;
            
            while (inInn) {
                try {
                    System.out.println("\n========== INN MENU ==========");
                    System.out.println("1. Buy Drink (+5 Fame)");
                    System.out.println("2. Gamble");
                    System.out.println("3. Leave");
                    System.out.println("=============================\n");
                    
                    System.out.print("Choose an option: ");
                    String choice = scanner.nextLine();
                    
                    if (choice == null || choice.trim().isEmpty()) {
                        System.out.println("Error: Please enter a valid option.\n");
                        continue;
                    }
                    
                    switch (choice.trim()) {
                        case "1":
                            this.player.addFame(5);
                            System.out.println("You bought a drink! +5 Fame\n");
                            break;
                        case "2":
                            gambler.displayGamblingOptions();
                            System.out.print("Choose: ");
                            String bet = scanner.nextLine();
                            
                            if (bet == null || bet.trim().isEmpty()) {
                                continue;
                            }
                            
                            try {
                                int betAmount = Integer.parseInt(bet.trim());
                                if (betAmount > 0) {
                                    gambler.gamble(this.player, betAmount);
                                } else {
                                    System.out.println("Error: Bet must be positive!\n");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Please enter a valid number!\n");
                            }
                            break;
                        case "3":
                            inInn = false;
                            break;
                        default:
                            System.out.println("Error: Invalid choice.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Error in inn: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error accessing inn: " + e.getMessage());
        }
    }
    
    /**
     * Dungeon menu to enter combat challenges
     * 
     * Allows player to enter dungeon chambers and engage in battles.
     * Chamber 5 is the special final boss chamber.
     */
    private void dungeonMenu() {
        try {
            if (this.player == null || this.dungeon == null) {
                System.out.println("Error: Dungeon or player is null!");
                return;
            }
            
            boolean inDungeon = true;
            
            while (inDungeon && this.player.isAlive()) {
                try {
                    int currentLevel = this.dungeon.getCurrentLevel();
                    
                    System.out.println("\n========== ENTER DUNGEON ==========");
                    System.out.println("1. Enter Chamber " + currentLevel);
                    
                    // Chamber 5 is the final boss chamber
                    if (currentLevel >= 5) {
                        System.out.println("   ⚠️  WARNING: This is the FINAL CHAMBER!");
                        System.out.println("   (The final boss awaits...)");
                    }
                    
                    System.out.println("2. Return to Town");
                    System.out.println("===================================\n");
                    
                    System.out.print("Choose an option: ");
                    String choice = scanner.nextLine();
                    
                    if (choice == null || choice.trim().isEmpty()) {
                        System.out.println("Error: Please enter a valid option.\n");
                        continue;
                    }
                    
                    switch (choice.trim()) {
                        case "1":
                            battle();
                            break;
                        case "2":
                            inDungeon = false;
                            break;
                        default:
                            System.out.println("Error: Invalid choice.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Error in dungeon menu: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error accessing dungeon: " + e.getMessage());
        }
    }
    
    /**
     * Scales a monster's stats for New Game+ difficulty
     * 
     * In New Game+, monsters are SIGNIFICANTLY stronger:
     * - Health is multiplied by 3
     * - Power is multiplied by 2.5
     * - They're actual threats instead of one-shot kills
     * 
     * @param enemy the Monster to scale
     */
    private void scaleMonsterForNewGamePlus(Monster enemy) {
        try {
            if (!this.isNewGamePlus || enemy == null) {
                return;
            }
            
            // Dramatically increase monster stats for challenge
            int scaledHealth = (int)(enemy.getMaxHealth() * 3);      // 3x health
            int scaledPower = (int)(enemy.getPower() * 2.5);         // 2.5x damage
            
            // Set new health and power
            enemy.setMaxHealth(scaledHealth);
            enemy.setHealth(scaledHealth);
            enemy.setPower(scaledPower);
            
            System.out.println("\n⚠️  NEW GAME+ SCALING ACTIVATED!");
            System.out.println("⚠️  This monster is SIGNIFICANTLY stronger!\n");
        } catch (Exception e) {
            System.out.println("Error scaling monster: " + e.getMessage());
        }
    }
    /**
     * Battle system with turn-based combat
     * 
     * Handles one-on-one combat between player and enemy. Provides options to
     * attack, use items, analyze enemy, or escape. Continues until one side dies.
     * In New Game+, monsters are scaled to be significantly stronger.
     */
    private void battle() {
        try {
            if (this.player == null || this.dungeon == null) {
                System.out.println("Error: Battle setup failed!");
                return;
            }
            
            Room currentRoom = this.dungeon.getCurrentRoom();
            if (currentRoom == null) {
                System.out.println("Error: Room is null!");
                return;
            }
            
            Monster enemy = currentRoom.getMonster();
            if (enemy == null) {
                System.out.println("Error: Enemy is null!");
                return;
            }
            
            // Scale monster if we're in New Game+ mode
            scaleMonsterForNewGamePlus(enemy);
            
            this.inBattle = true;
            
            System.out.println("\n========== BATTLE START ==========");
            enemy.display();
            
            while (this.inBattle && this.player.isAlive() && enemy.isAlive()) {
                try {
                    System.out.println("========== BATTLE MENU ==========");
                    System.out.println("1. Attack");
                    System.out.println("2. Use Item");
                    System.out.println("3. Analyze Enemy");
                    System.out.println("4. Escape");
                    System.out.println("=================================\n");
                    
                    System.out.print("Choose an action: ");
                    String action = scanner.nextLine();
                    
                    if (action == null || action.trim().isEmpty()) {
                        System.out.println("Error: Please choose an action.\n");
                        continue;
                    }
                    
                    switch (action.trim()) {
                        case "1":
                            performAttack(enemy);
                            if (enemy.isAlive()) {
                                enemyAttack(enemy);
                            }
                            break;
                        case "2":
                            this.player.getItemBag().displayInventory();
                            System.out.print("Select item to use (number): ");
                            
                            try {
                                String itemChoice = scanner.nextLine();
                                if (itemChoice == null || itemChoice.trim().isEmpty()) {
                                    System.out.println("Cancelled.\n");
                                    break;
                                }
                                
                                int itemIndex = Integer.parseInt(itemChoice.trim());
                                this.player.useItem(itemIndex);
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Please enter a valid number!\n");
                                break;
                            }
                            
                            if (enemy.isAlive()) {
                                enemyAttack(enemy);
                            }
                            break;
                        case "3":
                            this.player.analyzeEnemy(enemy);
                            break;
                        case "4":
                            if (this.player.escape()) {
                                this.inBattle = false;
                            } else {
                                enemyAttack(enemy);
                            }
                            break;
                        default:
                            System.out.println("Error: Invalid action.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Error in battle: " + e.getMessage());
                }
            }
            
            if (this.inBattle) {
                endBattle(enemy);
            }
        } catch (Exception e) {
            System.out.println("Error starting battle: " + e.getMessage());
        }
    }
    
    /**
     * Executes a player attack during battle
     * 
     * @param enemy the Monster being attacked
     */
    private void performAttack(Monster enemy) {
        try {
            if (this.player == null || enemy == null) {
                System.out.println("Error: Player or enemy is null!");
                return;
            }
            
            int damage = this.player.attack();
            enemy.takeDamage(damage);
        } catch (Exception e) {
            System.out.println("Error performing attack: " + e.getMessage());
        }
    }
    
    /**
     * Executes an enemy attack during battle
     * 
     * @param enemy the Monster attacking
     */
    private void enemyAttack(Monster enemy) {
        try {
            if (this.player == null || enemy == null) {
                System.out.println("Error: Player or enemy is null!");
                return;
            }
            
            int damage = enemy.attack();
            this.player.takeDamage(damage);
        } catch (NullPointerException e) {
            System.out.println("Error: Combat error - enemy is null!");
        } catch (Exception e) {
            System.out.println("Error during enemy attack: " + e.getMessage());
        }
    }
    
    /**
     * Processes battle end - victory or defeat
     * 
     * If player wins, awards gold and fame.
     * Chamber 5 is special - after winning, shows victory menu with options.
     * If player loses, ends the game.
     * 
     * @param enemy the Monster that was fought
     */
    private void endBattle(Monster enemy) {
        try {
            if (this.player == null || enemy == null) {
                System.out.println("Error: Player or enemy is null!");
                return;
            }
            
            if (!enemy.isAlive()) {
                int goldReward = enemy.getMoney();
                int fameReward = enemy.getFame();
                
                this.player.addMoney(goldReward);
                this.player.addFame(fameReward);
                
                System.out.println("\n========== VICTORY ==========");
                System.out.println(enemy.getName() + " has been defeated!");
                System.out.println("You gained " + goldReward + " gold!");
                System.out.println("You gained " + fameReward + " fame!");
                System.out.println("=============================\n");
                
                // Check if we're in Chamber 5 (final chamber)
                int currentLevel = this.dungeon.getCurrentLevel();
                if (currentLevel >= 5) {
                    // Chamber 5 victory - show special menu
                    chamber5VictoryMenu();
                } else {
                    // Normal chambers advance to next level
                    this.dungeon.nextRoom();
                }
            } else if (!this.player.isAlive()) {
                System.out.println("\n========== DEFEAT ==========");
                System.out.println("You have been defeated!");
                System.out.println("============================\n");
                this.gameRunning = false;
            }
            
            this.inBattle = false;
        } catch (Exception e) {
            System.out.println("Error ending battle: " + e.getMessage());
        }
    }
    
    /**
     * Special menu for Chamber 5 after VICTORY
     * 
     * After defeating the final boss, player can:
     * - Replay Chamber 5 (fight the boss again)
     * - Start New Game+ from Chamber 1 (keep all items, money, fame)
     */
    private void chamber5VictoryMenu() {
        try {
            if (this.player == null || this.dungeon == null) {
                System.out.println("Error: Cannot access Chamber 5 victory menu!");
                return;
            }
            
            boolean inVictoryMenu = true;
            
            while (inVictoryMenu) {
                try {
                    System.out.println("\n╔═══════════════════════════════════════════╗");
                    System.out.println("║     CONGRATULATIONS! YOU WON!             ║");
                    System.out.println("║   You defeated the final boss!            ║");
                    System.out.println("╚═══════════════════════════════════════════╝\n");
                    
                    System.out.println("What would you like to do?\n");
                    System.out.println("1. Replay Chamber 5");
                    System.out.println("   └─ Fight the final boss again!");
                    System.out.println("   └─ Keep all your items, money, and fame");
                    System.out.println("\n2. Start New Game+ from Chamber 1");
                    System.out.println("   └─ Begin a new adventure!");
                    System.out.println("   └─ Keep all your progress (items, money, fame)");
                    System.out.println("   └─ The dungeon resets to Chamber 1");
                    System.out.println("   └─ Monsters become stronger!\n");
                    
                    System.out.println("3. View Current Stats\n");
                    
                    System.out.print("Choose an option: ");
                    String choice = scanner.nextLine();
                    
                    if (choice == null || choice.trim().isEmpty()) {
                        System.out.println("Error: Please enter a valid option.\n");
                        continue;
                    }
                    
                    switch (choice.trim()) {
                        case "1":
                            // Replay Chamber 5 - boss respawns but player keeps everything
                            System.out.println("\n✓ The final boss has risen again...");
                            System.out.println("✓ All your progress is saved.\n");
                            // Don't advance dungeon level, keep at 5
                            inVictoryMenu = false;
                            break;
                            
                        case "2":
                            // Start New Game+ from Chamber 1 - reset dungeon but keep player stats
                            System.out.println("\n✓ Starting New Game+...");
                            System.out.println("✓ You keep all your items, money, and fame!");
                            System.out.println("✓ The dungeon resets to Chamber 1.");
                            System.out.println("✓ WARNING: Enemies are SIGNIFICANTLY stronger!");
                            System.out.println("✓ This will be a TRUE CHALLENGE!\n");
                            
                            // Reset dungeon to Chamber 1
                            this.dungeon = new Dungeon();
                            
                            // Mark that we're in New Game+ mode (harder difficulty)
                            this.isNewGamePlus = true;
                            
                            System.out.println("✓ New Game+ started! Prepare for a real battle...\n");
                            
                            inVictoryMenu = false;
                            return;
                            
                        case "3":
                            // View stats
                            if (this.player != null) {
                                System.out.println();
                                this.player.introduce();
                            }
                            break;
                            
                        default:
                            System.out.println("Error: Invalid choice. Please enter 1-3.\n");
                    }
                } catch (Exception e) {
                    System.out.println("Error in Chamber 5 victory menu: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error accessing Chamber 5 victory menu: " + e.getMessage());
        }
    }
    
    
    /**
     * Ends the game and displays final stats
     * 
     * Shows game over screen with player's final statistics.
     */
    private void endGame() {
        try {
            System.out.println("\n========== GAME OVER ==========");
            System.out.println("Thanks for playing Tales of Knights!");
            
            if (this.player != null) {
                System.out.println("\nFinal Stats:");
                this.player.introduce();
            }
            
            System.out.println("================================\n");
            this.gameRunning = false;
        } catch (Exception e) {
            System.out.println("Error ending game: " + e.getMessage());
            this.gameRunning = false;
        }
    }
}