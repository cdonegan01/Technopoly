package cormacCoolClassesTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cormacCoolClasses.Player;

public class TestPlayer {
	
	/**
	 * test
	 */
	
	//test data
	int validLocation, invalidLocationHigher, invalidLocationLower, validBalance, invalidBalance;
	String validPlayerName;

	@Before
	public void setUp() throws Exception {
		validLocation = 6;
		invalidLocationHigher = 12;
		invalidLocationLower = -1;
		validBalance = 200;
		invalidBalance = -1;
		validPlayerName = "validPlayerName";
	}
	
	@Test
	public void testPlayer() {
		Player e = new Player();
		assertNotNull(e);
	}

	@Test
	public void testPlayerStringIntInt() {
		Player e = new Player(validPlayerName, validBalance, validLocation);
		assertNotNull(e);
		
		assertEquals(e.getPlayerName(), validPlayerName);
		assertEquals(e.getCurrentBalance(), validBalance);
		assertEquals(e.getCurrentLocation(), validLocation);
	}

	@Test
	public void testSetPlayerName() throws Exception {
		Player e = new Player();
		String validName;
		
		validName = "1";
		e.setPlayerName(validName);
		assertEquals(validName, e.getPlayerName());
		
		validName = "123456789012345";
		e.setPlayerName(validName);
		assertEquals(validName, e.getPlayerName());
		
		validName = "123456789012345123456789012345";
		e.setPlayerName(validName);
		assertEquals(validName, e.getPlayerName());
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testNameOutOfBoundsLower() throws IndexOutOfBoundsException {
		Player e = new Player();
		String invalidName;
		
		invalidName = "";
		e.setPlayerName(invalidName);
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testNameOutOfBoundsHigher() throws IndexOutOfBoundsException {
		Player e = new Player();
		String invalidName;
		invalidName = "ldhjasldjaslkjaghjfgkjadflajkdhflajkdhsfalkjsdhfalkjdhflakjdhfalkdfhlakhfdlakjhflashfdajksdfkladhfa";
		e.setPlayerName(invalidName);
	}

	@Test
	public void testSetCurrentBalanceValid() {
		Player e = new Player();
		e.setCurrentBalance(validBalance);
		assertEquals(validBalance, e.getCurrentBalance());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testInvalidCurrentBalance() throws IllegalArgumentException {
		Player e = new Player();
		e.setCurrentBalance(invalidBalance);
	}

	@Test
	public void testSetCurrentLocationValid() throws IllegalArgumentException {
		Player e = new Player();
		int validLocation;
		
		validLocation = 0;
		e.setCurrentLocation(validLocation);
		assertEquals(validLocation, e.getCurrentLocation());
		
		validLocation = 6;
		e.setCurrentLocation(validLocation);
		assertEquals(validLocation, e.getCurrentLocation());
		
		validLocation = 11;
		e.setCurrentLocation(validLocation);
		assertEquals(validLocation, e.getCurrentLocation());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLocationOutOfBoundsHigher() throws IllegalArgumentException {
		Player e = new Player();
		e.setCurrentLocation(invalidLocationLower);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testLocationOutOfBoundsLower() throws IllegalArgumentException {
		Player e = new Player();
		e.setCurrentLocation(invalidLocationHigher);
	}

}
