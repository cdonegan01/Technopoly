package cormacCoolClassesTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cormacCoolClasses.FreeParking;
import cormacCoolClasses.Go;
import cormacCoolClasses.Player;
import cormacCoolClasses.Property;
import cormacCoolClasses.Square;
import cormacCoolClasses.UpdatePlayerLocation;

public class UpdatePlayerLocationTest {
	
	/**
	 * Test
	 */
	
	int currentPlayer;

	@Before
	public void setUp() throws Exception {
		currentPlayer = 0;
		
		Player player1 = new Player("Cormac", 500, 0);
		Player player2 = new Player("Cormac", 500, 0);
		Player player3 = new Player("Cormac", 500, 0);
		Player player4 = new Player("Cormac", 500, 0);
		
		Player[] Players = new Player[4];
		
		Players[0] = player1;
		Players[1] = player2;
		Players[2] = player3;
		Players[3] = player4;

		Square[] GameBoard = new Square[12];
		
		Square sq1 = new Go("Go", 200);
		Square sq2 = new Property("cheap one", "", 100, 100, 100, 100, 100);
		Square sq3 = new Property("cheap two", "", 100, 100, 100, 100, 100);
		Square sq4 = new Property("lowMid one", "", 100, 100, 100, 100, 100);
		Square sq5 = new Property("lowMid two", "", 100, 100, 100, 100, 100);
		Square sq6 = new Property("lowMid three", "", 100, 100, 100, 100, 100);
		Square sq7 = new FreeParking("", "");
		Square sq8 = new Property("highMid one", "", 100, 100, 100, 100, 100);
		Square sq9 = new Property("highMid two", "", 100, 100, 100, 100, 100);
		Square sq10 = new Property("highMid three", "", 100, 100, 100, 100, 100);
		Square sq11 = new Property("high one", "", 100, 100, 100, 100, 100);
		Square sq12 = new Property("high two", "", 100, 100, 100, 100, 100);
		
		GameBoard[0] = sq1;
		GameBoard[1] = sq2;
		GameBoard[2] = sq3;
		GameBoard[3] = sq4;
		GameBoard[4] = sq5;
		GameBoard[5] = sq6;
		GameBoard[6] = sq7;
		GameBoard[7] = sq8;
		GameBoard[8] = sq9;
		GameBoard[9] = sq10;
		GameBoard[10] = sq11;
		GameBoard[11] = sq12;
		
		int diceRoll = 6;
	}

	@Test
	public void testUpdatePlayerLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlayerLocationUpdater() {
	
	}

}
