# Tales of Knights - Complete Game Documentation


###  Project Overview

**Tales of Knights** is a text-based RPG (Role-Playing Game) written in Java. It demonstrates advanced Object-Oriented Programming (OOP) concepts including inheritance, polymorphism, encapsulation, abstraction, and interfaces.

**Version:** 1.0  
**Language:** Java   
**IDE:** NetBeans  

---

##  Game Features

###  Core Features

- **Character Creation**: Create your hero with custom name and title
- **Character Statistics**: Track health, power, fame, and money
- **Combat System**: Real-time battle with monsters using strategy and tactics
- **Inventory System**: Collect and manage up to 8 items
- **Shopping**: Buy and sell weapons, armor, and consumables
- **NPCs**: Interact with shopkeepers, gamblers, and other villagers
- **Dungeon Exploration**: Explore multiple dungeon chambers with increasing difficulty
- **Item Management**: Equip weapons and armor, use consumable items
- **Progression System**: Gain money and fame as you complete challenges

###  Game Mechanics

#### Combat
- Attack monsters using equipped weapons
- Use items (healing potions, damage boosters) during battle
- Analyze enemy stats before attacking
- 30% chance to escape from combat
- Gain gold and fame for victories

#### Economy
- Start with 100 gold
- Buy items from the shopkeeper
- Sell items for gold
- Gamble with NPCs (50% win chance)
- Earn gold from defeated monsters

#### Progression
- Increasing dungeon difficulty (Levels 1-5)
- More challenging monsters at higher levels
- Better rewards for difficult battles
- Fame affects NPC interactions

---



##  OOP Concepts Demonstrated

### 1. **Inheritance**
- `Character` as base class for all characters
- `Fighter` extends `Character` with combat abilities
- `Hero` extends `Fighter` with inventory
- `Monster` extends `Fighter` with AI
- `Villager` extends `Character` for NPCs
- `Item` as base for all items
- `Weapon`, `Armor`, `HealingItem`, `DamageItem` extend `Item`

### 2. **Polymorphism**
- `attack()` method implemented differently in `Hero` and `Monster`
- `takeDamage()` overridden with armor consideration
- `introduce()` displays different info for each character
- Interface methods implemented multiple ways

### 3. **Encapsulation**
- Private fields with public getters/setters
- Validation in setter methods
- Exception handling in property methods
- Protected access for subclass modifications

### 4. **Abstraction**
- Abstract classes: `Character`, `Fighter`, `Villager`, `Item`, `Place`
- Abstract methods force subclass implementation
- Interfaces: `Aggression`, `Consumable`
- Complex logic hidden from user

### 5. **Interfaces**
- `Aggression`: Defines combat behavior
- `Consumable`: Defines item usage behavior
- Multiple classes implement both interfaces


## 🎮 How to Play

### Character Creation
```
Enter your character's name: Hero
Enter your character's title: Knight
```

### Main Menu
```
========== MAIN MENU ==========
1. Go to Town
2. Enter Dungeon
3. Check Status
4. Check Inventory
5. Quit Game
```

### In Town
- **Visit Shop**: Buy weapons, armor, potions
- **Visit Inn**: Buy drinks (gain fame), gamble
- **Rest**: Recover health
- **Leave**: Return to main menu

### In Dungeon
- **Attack**: Deal damage using equipped weapon
- **Use Item**: Use healing or damage items
- **Analyze**: See enemy stats
- **Escape**: 30% chance to flee

### Combat Example
```
A wild Goblin appears!
Health: 30/30
Power: 10

========== BATTLE MENU ==========
1. Attack
2. Use Item
3. Analyze Enemy
4. Escape

Choose an action: 1
Hero attacks with Iron Sword for 35 damage!
Goblin takes 35 damage! (Health: 0)

========== VICTORY ==========
Goblin has been defeated!
You gained 100 gold!
You gained 50 fame!
```

---

## 📊 Game Balance

### Starting Stats
- **Health**: 100
- **Power**: 15
- **Fame**: 0
- **Money**: 100 gold

### Weapons
| Weapon | Damage | Cost |
|--------|--------|------|
| Iron Sword | 20 | 50 gold |
| Steel Sword | 30 | 75 gold |

### Armor
| Armor | Protection | Cost |
|-------|-----------|------|
| Leather Armor | 5 | 40 gold |
| Steel Armor | 10 | 60 gold |

### Items
| Item | Effect | Cost |
|------|--------|------|
| Health Potion | +25 HP | 25 gold |
| Greater Potion | +50 HP | 40 gold |
| Explosive Bomb | +25 DMG | 30 gold |

### Monsters
| Monster | Health | Power | Challenge |
|---------|--------|-------|-----------|
| Goblin | 30 | 10 | 1 |
| Orc | 40 | 12 | 2 |
| Troll | 50 | 14 | 3 |
| Dragon | 60 | 16 | 4 |
| Demon | 70 | 18 | 5 |

---

## 🔧 Exception Handling

The game includes comprehensive exception handling:

### Handled Exceptions
- **NullPointerException**: Object null checks
- **NumberFormatException**: Invalid number input
- **IndexOutOfBoundsException**: Array bounds checking
- **IllegalArgumentException**: Invalid parameters
- **Generic Exception**: Catch-all for unknown errors




## 🐛 Known Limitations

1. **Text-Based Only**: No graphics or animations
2. **Single Player**: No multiplayer support
3. **No Save System**: Game restarts from beginning
4. **Limited Content**: 5 dungeon levels, 5 monsters
5. **Simple AI**: Monsters use random damage

---

## 📈 Future Enhancements

Possible improvements:

1. **Save/Load System**: Resume games
2. **More Content**: Additional monsters, items, locations
3. **Improved UI**: Better menu design
4. **Game Balance**: Adjust difficulty curves
5. **Quests**: Quest system with objectives
6. **Multiplayer**: Network play
7. **Graphics**: Graphical interface

---

##  Contributing
To add new features:

1. Create new classes in appropriate packages
2. Follow existing naming conventions
3. Add comprehensive exception handling
4. Document with Javadoc
5. Test thoroughly before committing

---


## 👨‍💻 Author

Created as a comprehensive Java learning project demonstrating OOP principles.


## 📚 References

### Java Documentation
- https://docs.oracle.com/javase/8/docs/
- https://docs.oracle.com/javase/tutorial/

### OOP Concepts
- https://www.oracle.com/java/technologies/oop-concepts.html
- https://docs.oracle.com/javase/tutorial/java/concepts/


## 🎉 Enjoy Tales of Knights!

This comprehensive RPG demonstrates professional Java programming practices. Have fun playing and learning!

**Version History:**
- v1.0: Initial release with full OOP implementation


**Happy Gaming!** 
