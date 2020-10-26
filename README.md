# digitalRisk

Game Authors: Vyasan Jogarasan, Ryan Nguyen, Fareen Lavji, Vis Kirubakaran
readme Author: Vyasan Jogarasan
Deliverables:
Source Code and executable in JAR file
UML Diagram
Sequence Diagrams for important scenarios
Documentation

Known Issues:

Weren't able to randomally allocate countries to a player, because of this we can't operate in the battle phase since 
the players don't have any countries.

There is also no method to show who has won the game .

Did not dispearse the army to players according to player count.

Did not do a check to see if the country inputted by the user is a valid country in the game.

Our class hookups and architecture needs to be reassessed.


Road Map Ahead:

Refactor the whole game.
Add feature to randomally allocate players and their armies around the map.
Add a method to check if there is only one player left and notify the game that it is over and there is a winner.
Implement our text based RISK game into a GUI(adding view and controller).
Adding addition features to the game such as: bonus troop placement, troop movementn and an AI player.
Add a Save/Load feature, and a feature to add custom maps.
