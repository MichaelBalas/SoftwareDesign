// Author: Michael Balas


import java.util.Arrays;

/**
 * This class represents a Battleship game .
 */
public class Battleship {

    public static void main(String[] args) {
        boardInit();
        addShip(0, 0, 0, true);
        addShip(1, 0, 1, true);
        addShip(2, 0, 2, true);
        addShip(3, 0, 3, true);
        addShip(4, 0, 4, true);
        String x = getPlayerBoard();
        System.out.println(x);
    }

    // Extra helper method to visualize boards
    public static void printArray(int matrix[][]) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
        System.out.println("\n");
}

    public static final int SIZE = 10;
    public static final int NUM_SHIPS = 5;

    // lengths of the various ships in the game
    public static final int CARRIER_LENGTH = 5;
    public static final int BATTLESHIP_LENGTH = 4;
    public static final int CRUISER_LENGTH = 3;
    public static final int SUBMARINE_LENGTH = 3;
    public static final int DESTROYER_LENGTH = 2;

    // array of all ship lengths
    public static final int[] SHIPS =
    {
        CARRIER_LENGTH,
        BATTLESHIP_LENGTH,
        CRUISER_LENGTH,
        SUBMARINE_LENGTH,
        DESTROYER_LENGTH
    };

    // the total number of hits required to destroy all ships    
    public static final int HITPOINTS = (CARRIER_LENGTH + BATTLESHIP_LENGTH + CRUISER_LENGTH + SUBMARINE_LENGTH + DESTROYER_LENGTH);

    // State Variables
    private static int[][] playerBoard = new int[SIZE][SIZE];
    private static int[][] opponentBoard = new int[SIZE][SIZE];
    private static int[][] shotsFired = new int[SIZE][SIZE];
    private static int[][] shotsTaken = new int[SIZE][SIZE];
    private static boolean playerTurn;
    private static boolean readyToFire;

    public static void boardInit() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                playerBoard[i][j] = 0;
                opponentBoard[i][j] = 0;
                shotsFired[i][j] = 0;
                shotsTaken[i][j] = 0;
            }
        }
        playerTurn = true;
        readyToFire = false;
    }

    public static void switchTurn() throws GameOverException { 
        if ((readyToFire == true) && (percentPlayerShips() == 0 || percentOpponentShips() == 0)) {
            throw new GameOverException("Can't switch turns when game is over!");
        }
        playerTurn = !playerTurn;
    }

    public static boolean getTurn() {
        return playerTurn;
    }

    public static void addShip(int row, int column, int shipType, boolean orientation) throws InvalidLocationException, ShipAdditionException, InvalidShipTypeException {
        // ---------- Exceptions ---------- //
        if (!(0 <= shipType && shipType <= SHIPS.length - 1)) {
            throw new InvalidShipTypeException("Index out of bounds: Not a valid ship!");
        }
        if (readyToFire == true) {
            throw new ShipAdditionException("Cannot add ships once all have been placed");
        }
        // ---------- Adding Ships ---------- //
        for (int i = 0; i < SHIPS[shipType]; i++) {
            if (playerTurn == true) { // If it's the player's turn
                if (isValidPlacement(row, column, shipType, orientation) == true) {
                    if (orientation == true) { // If you want to place the ships horizontally
                        playerBoard[row][column+i] = 1;
                    } else { // If you want to place the ships vertically
                        playerBoard[row+i][column] = 1;
                    }
                } else {throw new InvalidLocationException("Can't place ship here!");}
            } else { // If it's the opponent's turn
                if (isValidPlacement(row, column, shipType, orientation) == true) {
                    if (orientation == true) {
                        opponentBoard[row][column+i] = 1;
                    } else {
                        opponentBoard[row+i][column] = 1;
                    }
                } else { throw new InvalidLocationException("Can't place ship here!");}
            }
        }
        if (allShipsPlaced() == true) { readyToFire = true;}
    }

    public static void shoot(int row, int column) throws InvalidLocationException, PrematureShotException, GameOverException{ 
        // ---------- Exceptions ---------- //
        if (readyToFire == false) {
            throw new PrematureShotException("Cannot shoot until all ships have been placed!");
        }
        if (percentPlayerShips() == 0 || percentOpponentShips() == 0) {
            throw new GameOverException("Cannot shoot when game has ended!");
        }
        // ---------- Shooting Ships ---------- //
        if (isValidShot(row, column) == true) {
            if (playerTurn == true) {
                shotsFired[row][column] = 1;
                opponentBoard[row][column] = 0;
                if (percentOpponentShips() > 0) {switchTurn();} //Switch turns after every shot (unless the game has ended)
            } else {
                shotsTaken[row][column] = 1;
                playerBoard[row][column] = 0;
                if (percentPlayerShips() > 0) {switchTurn();} // Switch turns after every shot (unless the game has ended)
            }
        } else {throw new InvalidLocationException("Can't shoot here!");}
    }

    // Not dependent on who's turn it is - want to be able to access at any point in the game
    public static double percentPlayerShips() {
        double percent = (double)remainingPlayerHitPoints() / HITPOINTS;
        return percent * 100.0;
    }

    // Not dependent on who's turn it is - want to be able to access at any point in the game
    public static double percentOpponentShips() {
        double percent = (double)remainingOpponentHitPoints() / HITPOINTS;
        return percent * 100.0;
    }

    public static int numShotsFired() {
        int totalShots = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                totalShots += shotsFired[i][j];
            }
        }
        return totalShots;
    }

    public static int numShotsTaken() {
        int totalShots = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                totalShots += shotsTaken[i][j];
            }
        }
        return totalShots;
    }

    public static boolean isWinning() throws GameOverException {
        if (percentPlayerShips() == 0 || percentOpponentShips() == 0) {
            throw new GameOverException("Someone has already won!");
        }
        if (playerTurn == true) { // If it's the player's turn
            if (percentPlayerShips() > percentOpponentShips()) { // If the player has greater health than the opponent
                return true; // Player is winning
            } else { return false; } // Otherwise, player is not winning
        } else { // If it's the opponent's turn
            if (percentOpponentShips() > percentPlayerShips()) { // If the opponent has greater health than the player
                return true; // Opponent is winning
            } else {return false; } //Otherwise, opponent is not winning
        }
    }

    public static boolean isWinner() {
        if (playerTurn == true) { // If it's the player's turn
            if (percentOpponentShips() == 0) { // If the opponent has no health (i.e. all ships are destroyed)
                return true; // The player has won
            } else { return false; } // Otherwise, the player has not won
        } else { // If it's the opponent's turn
            if (percentPlayerShips() == 0) { // If the player has no health (i.e. all ships are destroyed)
                return true; // The opponent has won
            } else { return false; } // Otherwise, the opponent has not won
        }
    }



    // -----------------------------------------
    // Local Functions Below
    // -----------------------------------------

    private static boolean isValidPlacement(int row, int column, int shipType, boolean orientation) {
        for (int i = 0; i < SHIPS[shipType]; i++) {
            if (playerTurn == true) { // If it's the player's turn
                if (orientation == true) { // If ships are to be placed horizontally
                    if (0 <= (column + i) && (column + i) <= (SIZE - 1) && playerBoard[row][column+i] != 1) {
                        return true;
                    }
                } else { // If ships are to be placed vertically
                    if (0 <= (row + i) && (row + i) <= (SIZE - 1) && playerBoard[row+i][column] != 1) {
                        return true;
                    }
                }
            } else { // If it's the opponent's turn
                if (orientation == true) { // If ships are to be placed horizontally
                    if (0 <= (column + i) && (column + i) <= (SIZE - 1) && opponentBoard[row][column+i] != 1) {
                        return true;
                    }
                } else { // If ships are to be placed vertically
                    if (0 <= (row + i) && (row + i) <= (SIZE - 1) && opponentBoard[row+i][column] != 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isValidShot(int row, int column) {
        if ((0 <= row && row <= (SIZE - 1)) &&  (0 <= column && column <= (SIZE - 1))) {
            if (playerTurn == true) {
                if (shotsFired[row][column] != 1) {
                    return true;
                }
            } else {
                if (shotsTaken[row][column] != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean allShipsPlaced() {
        if (percentPlayerShips() == 100 && percentOpponentShips() == 100) {
            return true;
        }
        return false;
    }

    private static int remainingPlayerHitPoints() {
        int remHitPoints = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                remHitPoints += playerBoard[i][j];
            }
        }
        return remHitPoints;
    }

    private static int remainingOpponentHitPoints() {
        int remHitPoints = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                remHitPoints += opponentBoard[i][j];
            }
        }
        return remHitPoints;
    }

    // -----------------------------------------
    // Access Modifiers (Getters)
    // -----------------------------------------

    public static boolean getPlayerTurn() {
        return playerTurn;
    }

    public static boolean getReadyToFire() {
        return readyToFire;
    }

    public static String getPlayerBoard() {
        String board = "";
        for (int i = 0; i < SIZE-1; i++) {
            for (int j = 0; j < SIZE -1; j++) {
                board += ""+playerBoard[i][j];
            }
        }
        return board;
    }

    public static String getOpponentBoard() {
        String board = "";
        for (int i = 0; i < SIZE-1; i++) {
            for (int j = 0; j < SIZE -1; j++) {
                board += ""+opponentBoard[i][j];
            }
        }
        return board;
    }

        public static String getShotsFired() {
            String board = "";
            for (int i = 0; i < SIZE-1; i++) {
                for (int j = 0; j < SIZE -1; j++) {
                    board += ""+shotsFired[i][j];
                }
            }
            return board;
        }

        public static String getShotsTaken() {
            String board = "";
            for (int i = 0; i < SIZE-1; i++) {
                for (int j = 0; j < SIZE -1; j++) {
                    board += ""+shotsTaken[i][j];
                }
            }
            return board;
        }

}