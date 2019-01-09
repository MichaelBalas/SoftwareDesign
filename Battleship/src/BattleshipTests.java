// Author: Michael Balas

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* <h1>BattleshipTests</h1>
* The BattleshipTests class verifies the correctness and reliability of the Battleship module
*
* @author  Michael Balas
* @since   2019-01-03
*/

public class BattleshipTests {
	private Battleship b;

	@Before
	public void SetUp() {
		b = new Battleship();
		b.boardInit();
	}

	@After
	public void tearDown() {
		b = null;
	}

	@Test(expected = InvalidLocationException.class)
	public void InvalidVerticalShipLocation() {
		b.addShip(6, 0, 0, false);
	}

	@Test(expected = InvalidLocationException.class)
	public void InvalidHorizontalShipLocation() {
		b.addShip(0, 6, 0, true);
	}

	@Test(expected = InvalidLocationException.class)
	public void InvalidShotAtShip() {
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.addShip(4, 0, 4, true);
	        b.switchTurn();
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.addShip(4, 0, 4, true);
	        b.switchTurn();
	        b.shoot(0, 0); b.shoot(9, 9);
	        b.shoot(0, 0);
	}

	@Test(expected = PrematureShotException.class)
	public void PrematureShot() {
		b.addShip(0, 0, 0, true);
		b.shoot(0, 0);
	}

	@Test(expected = PrematureShotException.class)
	public void PrematureShotAdvanced() {
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.addShip(4, 0, 4, true);
	        b.switchTurn();
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.shoot(0, 0);
	}

	@Test(expected = InvalidLocationException.class)
	public void InvalidShot() {
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.addShip(4, 0, 4, true);
	        b.switchTurn();
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.addShip(4, 0, 4, true);
	        b.switchTurn();
	        b.shoot(9, 9); b.shoot(0, 0);
	        b.shoot(9, 9);
	}

	@Test(expected = ShipAdditionException.class)
	public void InvalidShipAddition() {
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.addShip(4, 0, 4, true);
	        b.switchTurn();
	        b.addShip(0, 0, 0, true);
	        b.addShip(1, 0, 1, true);
	        b.addShip(2, 0, 2, true);
	        b.addShip(3, 0, 3, true);
	        b.addShip(4, 0, 4, true);
	        b.switchTurn();
	        b.addShip(5, 0, 1, true);
	}

	@Test(expected = GameOverException.class)
	public void InvalidShotAfterEnd() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.shoot(0, 0); b.shoot(9, 0);
		b.shoot(0, 1); b.shoot(9, 1);
		b.shoot(0, 2); b.shoot(9, 2);
		b.shoot(0, 3); b.shoot(9, 3);
		b.shoot(0, 4); b.shoot(9, 4);
		b.shoot(1, 0); b.shoot(9, 5);
		b.shoot(1, 1); b.shoot(9, 6);
		b.shoot(1, 2); b.shoot(9, 7);
		b.shoot(1, 3); b.shoot(9, 8);
		b.shoot(1, 4); b.shoot(9, 9);
		b.shoot(2, 0); b.shoot(8, 0);
		b.shoot(2, 1); b.shoot(8, 1);
		b.shoot(2, 2); b.shoot(8, 2);
		b.shoot(3, 0); b.shoot(8, 3);
		b.shoot(3, 1); b.shoot(8, 4);
		b.shoot(3, 2); b.shoot(8, 5);
		b.shoot(4, 0); b.shoot(8, 6);
		b.shoot(4, 1); b.shoot(8, 7);
	}

	@Test
	public void testAddPlayerShip() {
		b.addShip(0, 0, 0, true);
		String actual = Battleship.getPlayerBoard();
		String expected = "111110000000000000000000000000000000000000000000000000000000000000000000000000000";
		assertEquals(expected, actual);
	}

	@Test
	public void testAddOpponentShip() {
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		String actual = Battleship.getOpponentBoard();
		String expected = "111110000000000000000000000000000000000000000000000000000000000000000000000000000";
		assertEquals(expected, actual);
	}

	@Test
	public void testAddManyPlayerShips() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		String actual = Battleship.getPlayerBoard();
		String expected = "111110000111100000111000000111000000110000000000000000000000000000000000000000000";
		assertEquals(expected, actual);
	}

	@Test
	public void testAddManyOpponentShips() {
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		String actual = Battleship.getOpponentBoard();
		String expected = "111110000111100000111000000111000000110000000000000000000000000000000000000000000";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTurn() {
		boolean expected = true;
		boolean actual = b.getTurn();
		assertEquals(expected, actual);
	}

	@Test
	public void testSwitchTurn() {
		boolean expected = false;
		b.switchTurn();
		boolean actual = b.getTurn();
		assertEquals(expected, actual);
	}


	@Test
	public void testHundPercentPlayerShips() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		double expected = 100.0;
		double actual = b.percentPlayerShips();
		double epsilon = 0.001;
		assertEquals(expected, actual, epsilon);
	}

	@Test
	public void testPercentPlayerShips() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		double expected = 88.235;
		double actual = b.percentPlayerShips();
		double epsilon = 0.001;
		assertEquals(expected, actual, epsilon);
	}

	@Test
	public void testHundPercentOpponentShips() {
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		double expected = 100.0;
		double actual = b.percentOpponentShips();
		double epsilon = 0.001;
		assertEquals(expected, actual, epsilon);
	}

	@Test
	public void testPercentOpponentShips() {
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		double expected = 70.588;
		double actual = b.percentOpponentShips();
		double epsilon = 0.001;
		assertEquals(expected, actual, epsilon);
	}

	@Test
	public void testNumShotsFired() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		for (int i = 0; i < 9; i++) {
			b.shoot(i, i);
		}
		int expected = 8/2 + 1; // Because turns switch after every shot, and player starts
		int actual = b.numShotsFired();
		assertEquals(expected, actual);
	}

	@Test
	public void testNumShotsTaken() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		for (int i = 0; i < 8; i++) {
			b.shoot(i, i);
		}
		int expected = 8/2; // Because turns switch after every shot, and player (not opponent) starts
		int actual = b.numShotsTaken();
		assertEquals(expected, actual);
	}

	@Test
	public void testPlayerIsWinning() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.shoot(0, 0); //player shot (hit)
		b.shoot(9, 9); //opponent shot (miss)
		b.shoot(0, 1); //player shot (hit)
		b.shoot(9, 8); //opponent shot (miss)
		b.shoot(0, 2); //player shot (hit)
		b.shoot(9, 7); //opponent shot (miss)
		boolean expected = true;
		boolean actual = b.isWinning();
		assertEquals(expected, actual);
	}

	@Test
	public void testOpponentIsWinning() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.shoot(9, 9); //player shot (miss)
		b.shoot(0, 0); //opponent shot (hit)
		b.shoot(9, 8); //player shot (miss)
		b.shoot(0, 1); //opponent shot (hit)
		b.shoot(9, 7); //player shot (miss)
		b.shoot(0, 2); //opponent shot (hit)
		b.shoot(9, 6); //player shot (miss)
		boolean expected = true;
		boolean actual = b.isWinning();
		assertEquals(expected, actual);
	}

	@Test
	public void testPlayerIsWinner() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.shoot(0, 0); b.shoot(9, 0);
		b.shoot(0, 1); b.shoot(9, 1);
		b.shoot(0, 2); b.shoot(9, 2);
		b.shoot(0, 3); b.shoot(9, 3);
		b.shoot(0, 4); b.shoot(9, 4);
		b.shoot(1, 0); b.shoot(9, 5);
		b.shoot(1, 1); b.shoot(9, 6);
		b.shoot(1, 2); b.shoot(9, 7);
		b.shoot(1, 3); b.shoot(9, 8);
		b.shoot(1, 4); b.shoot(9, 9);
		b.shoot(2, 0); b.shoot(8, 0);
		b.shoot(2, 1); b.shoot(8, 1);
		b.shoot(2, 2); b.shoot(8, 2);
		b.shoot(3, 0); b.shoot(8, 3);
		b.shoot(3, 1); b.shoot(8, 4);
		b.shoot(3, 2); b.shoot(8, 5);
		b.shoot(4, 0); b.shoot(8, 6);
		b.shoot(4, 1); 
		boolean expected = true;
		boolean actual = b.isWinner();
		assertEquals(expected, actual);
	}

	@Test
	public void testOpponentIsWinner() {
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.addShip(0, 0, 0, true);
		b.addShip(1, 0, 1, true);
		b.addShip(2, 0, 2, true);
		b.addShip(3, 0, 3, true);
		b.addShip(4, 0, 4, true);
		b.switchTurn();
		b.shoot(9, 0); b.shoot(0, 0);
		b.shoot(9, 1); b.shoot(0, 1);
		b.shoot(9, 2); b.shoot(0, 2);
		b.shoot(9, 3); b.shoot(0, 3);
		b.shoot(9, 4); b.shoot(0, 4);
		b.shoot(9, 5); b.shoot(1, 0);
		b.shoot(9, 6); b.shoot(1, 1);
		b.shoot(9, 7); b.shoot(1, 2);
		b.shoot(9, 8); b.shoot(1, 3);
		b.shoot(9, 9); b.shoot(1, 4);
		b.shoot(8, 0); b.shoot(2, 0);
		b.shoot(8, 1); b.shoot(2, 1);
		b.shoot(8, 2); b.shoot(2, 2);
		b.shoot(8, 3); b.shoot(3, 0);
		b.shoot(8, 4); b.shoot(3, 1);
		b.shoot(8, 5); b.shoot(3, 2);
		b.shoot(8, 6); b.shoot(4, 0);
		b.shoot(8, 7); b.shoot(4, 1);
		boolean expected = true;
		boolean actual = b.isWinner();
		assertEquals(expected, actual);
	}
}