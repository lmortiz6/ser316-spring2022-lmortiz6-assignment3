# ser316-spring2022-lmortiz6-assignment3

# Screen cast link
https://youtu.be/csZI-vd_saM

# Design Patterns

Factory :

 > Most classes with “Generator” in the name are examples of Factory Patterns. They return an object built based on one of a number of configurations that can be specified by name.

Strategy :

 > The ItemPool and EnemyPool classes choose a strategy at runtime by encapsulating Generator method calls into anonymous classes. These anonymous classes implement the private Command interface. This allows the actual method pull() to be only 1-2 lines long.

Singleton :

 > The InteriorGenerator class is a singleton, enforced by its private constructor and get method for 1 instance.


# Requirements Fulfilled

Character classes

 > main.java.system.PlayerGenerator builds player objects based on class

Small enemies spawn every floor, miniboss on even floors, boss every 5

 > main.java.system.InteriorGenerator, lines 109-117, 132-148

Equipping weapons

 > main.java.object.Entity, lines 276-278

Enemies have a chance to drop items

 > main.java.object.Enemy, lines 38-42

Potions for health/mana/energy (+other items as well)

 > main.java.system.UseItemGenerator, lines 30-69

 > Usable items defined by main.java.object.UseItem

Harder enemies spawn as you progress through floors

 > main.java.system.EnemyPool, lines 22-35

Curse applied to player every 5 floors

 > main.java.system.Game, lines 58-62

Player has stats

 > main.java.object.Entity, lines 29-33, 74-78

 > Package main.java.effect has effect files for stat boosts, e.g. VigorBoost, MindBoost, etc.

Player has skills/magic

 > main.java.object.Entity, line 37

 > main.java.object.Skill

Attacks have chance to miss

 > main.java.object.Entity, lines 412, 434-439

Xp gained from killing enemies

 > main.java.object.Enemy, lines 44-46

2 status ailments (poison and bleed)

 > main.java.effect.Poison, main.java.effect.Bleed

14 passive effects granted through relics (items)

 > main.java.object.Relic defines relic items

 > Relic items grant an effect from main.java.effect

 > main.java.system.RelicGenerator generates Relic items with specific effect/name/description.
