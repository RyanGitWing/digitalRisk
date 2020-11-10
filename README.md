# digitalRisk

Game Authors: Vyasan Jogarasan, Ryan Nguyen, Fareen Lavji, Vis Kirubakaran
readme Author: Vyasan Jogarasan, Fareen Lavji
Version: 10.09.2020

Deliverables: -
* Source Code and executable in JAR file
* UML Diagram
* Sequence Diagrams for important scenarios
* Documentation (including JAVADocs)

Updates: -
* Refactored to implement a back-end that doesn't touch the UX
* Added JUnit tests
* Created GUI

Known Issues: -
* Players use up the entire map on initialization regardless of number of players.
* Checking to see if a player is attacking their own country has a temporary fix.
* The GUI is still text based and has some quirks.
* The visual map has issues with alignment, assigning colours, and showing adjacent countries.
* The model view controller handleGameUpdate() needs to be improved.
* The GUI is handled in one class and can be split up and modularized.

Road Map Ahead: -
* Refactor the Game class and GUI
* Fix known issues and make GUI more user - friendly
* Implement the AI
* Implement army movement, custom country initialization, and bonus armies
