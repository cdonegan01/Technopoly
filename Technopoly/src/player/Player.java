/**
 * 
 */
package player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import selectionMenu.*;
import square.*;

/**
 * @author Brendan
 *
 */
public class Player implements Confirmation {

	// Instance Vars
	private String playerName;
	private int currentBalance;
	private int currentLocation;

	// Constructors
	/**
	 * Default Constructor
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param playerName
	 * @param currentBalance
	 * @param currentLocation
	 * @param playerNum
	 */
	public Player(String playerName, int currentBalance, int currentLocation) {
		super();
		this.playerName = playerName;
		this.setCurrentBalance(currentBalance);
		this.currentLocation = currentLocation;
	}

	// Methods
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the currentBalance
	 */
	public int getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(int currentBalance) {
		if (currentBalance > 0) {
			this.currentBalance = currentBalance;
		} else {
			// end game goes here
		}
	}

	/**
	 * @return the currentLocation
	 */
	public int getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}

	public static ArrayList<Player> generatePlayerArray(ArrayList<Player> playerArray, String[] playerNames) {
		for (int loop = 0; loop < playerNames.length; loop++) {
			playerArray.add(new Player(playerNames[loop], Go.getPASS_GO_PAY(), 0));
		}
		return playerArray;

	}

	public static ArrayList<Player> enterNames(Scanner scanner, ArrayList<Player> playerArray) throws Exception {

		boolean exitEnterNames = false;
		do {
			try {
			System.out.println("How many players wish to play?");

			int noOfPlayers = scanner.nextInt();
			
			String[] playerNames = new String[noOfPlayers];
			scanner.nextLine();

			int playerNumber = 1;

			for (int loop = 0; loop < playerNames.length; loop++) {

				System.out.printf("Please enter name of player %d :\n", playerNumber++);

				playerNames[loop] = scanner.next();

				scanner.nextLine();

			}
			playerArray = generatePlayerArray(playerArray, playerNames);

			System.out.println("Your names are:");
			Iterator<Player> playerConfirmer = playerArray.iterator();
			while (playerConfirmer.hasNext()) {
				System.out.println(playerConfirmer.next().getPlayerName());
			}
			if (Confirmation.confirm(scanner)) {
				exitEnterNames = true;
				return playerArray;
			} else {
				playerArray.clear();
			}
			
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again.");
				scanner.nextLine(); 
			}
		} while (!exitEnterNames);
		return playerArray;
	}

}
