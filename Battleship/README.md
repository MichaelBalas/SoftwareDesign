# Battleship
### Purpose
The purpose of this work is to design and specify modules to store the state of a game of [Battleship](https://www.thespruce.com/how-to-play-battleship-411069). The modules cover the Model portion of the Model View Controller design pattern. 
### Implementation Details
- There is a game state for each of the two players. This makes the module an abstract data type, not an abstract object.
- The state of the game board with the battleships is modelled as a two-dimensional sequence
- A separate board is kept for each player to track the shots they have taken
- There is a routine to initialize the board
- The placement of a ship in the initial configuration is checked for validity
- Shots are checked for validity
- The state of any cell of the game board can be inspected
- Notifications are produced for sunk ships
- Notifications are produced when the game is over  

All of the code is written in Java. Code files are documented using javadoc. The Module Interface Specifications can be found [here](specifications.pdf).
### Testing
Module **battleshipTests.java** tests the implemented routines using JUnit. A rule named **test** is included in the makefile (named **Makefile**), which runs all test cases. 
#### Author
Michael Balas

#### License
[GNU General Public License](../LICENSE)
