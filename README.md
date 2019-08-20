# OOP: "CREATE A NEW POKEMON GAME"
This pokemon game was developed as part of the programming course at Beuth University of Applied Science. It was used for practicing OOP. It is a simple game using JAVA-SWING that provides a graphical user interface.

## HOW TO START | EXECUTION OF POKEMON.JAR 
it may be that you first need to change file permissions to execute pokemon.jar:<br>
- ```cd $PATH$/pokemon.jar```<br>
- ```chmod 774 pokemon.jar```    change permission <br>
- ```java -jar pokemon.jar```    starting the game... <br>

## NOTES
It is highly recommended to heal your pokemon before starting a fight.<br> Due to time restriction concerning developement of this code, there are no "level ups" with gaining "Erfahrungspunkte". I decided to implement pokemon evolution, which why it does not take too long and you'll see that your pokemon evolves. 

# CODE INFORMATION

- **PokeGame.java** : Contains *Main* function and game control methods <br>
- **PokeGui.java** : Contains all SWING-Components and provides graphical user interface. EventListeners use methods from PokeGame.java <br>
- **Pokemon.java** : Superclass. This project implements Multi-Level-Inheritance with 3 Levels:<br>
[ Glumanda | Glutexo | Glurak ] These classes inherit properties and methods of class [ Feuerpokemon ] <br>
[ Schiggy | Schillok | Turtok ] These classes inherit properties and methods of class [ Wasserpokemon ] <br>
[ Bisasam | Bisaknosp | Bisaflor ] These classes inherit properties and methods of class [Pflanzenpokemon] <br>
[Feuerpokemon | Wasserpokemon | Pflanzenpoken ] These classes directly inherit properties and methods of Superclass [ Pokemon ]

## GAME DESCRIPTION AND FEATURES
The main window shows three options: [pokedex] [new fight] [exit game]
- **pokedex**: You can have a look at your team. With clicking a radio button you'll see the chosen pokemon and its status. It may be that its "Kampfpunkte (KP)" are very low due to a recent fight. You can heal your pokemon with the provided button "heilen". If you wanted to heal all of your pokemon, make sure no radio button is enabled e.g. directly after opening your pokedex. If your pokemon evolves, you'll see it in your pokedex, too.
- **starting a game**: There are 9 different pokemon that randomly attack you. You can choose your pokemon before starting a fight.
- **Pokemon**: Every pokemon is either a "Pflanzenpokemon", a "Wasserpokemon" or a "Feuerpokemon". Every pokemon has learned two attacks: The first one is neutral (it's always the attack called "Tackle"), the other one is a type-specific one. If you choose a water-attack against a fire-pokemon, you'll cause more damage. Same with plant-attack against a water-typ and fire-attack against a plant-typ. 
- **"Volltreffer"** sometimes you may have luck and there will be a "Volltreffer" that provides you an advantage during your fight.
- **Evolution** with every fight you won, your pokemon gains "Erfahrungspunkte". If your pokemon has got enough "Erfahrungspunkte", it will evolve into a stronger pokemon. It only takes 2-3 fights to test this feature. 

## LICENSE
author: Katharina Sachs | Beuth University of Applied Science <br> Programming Course (Prof. Troeger: <https://prof.beuth-hochschule.de/troeger/> )
