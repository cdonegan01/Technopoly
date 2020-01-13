package run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import player.*;
import square.*;

/**
 * This class holds the "updatePlayerLocation" method, facilitating the player's
 * movement around the Game Board
 * 
 * @author Cormac
 *
 */
public class PlayerLocationUpdater {

	/**
	 * This method updates the player location variable, facilitating their changing
	 * position on the gameboard as it relates to the Gameboard Arraylist.
	 * 
	 * @param player
	 * @param Gameboard
	 * @param players
	 */
	public static void updatePlayerLocation(Scanner scanner, Player player, ArrayList<Square> Gameboard, ArrayList<Player> players) {
		// moving the player through the gameboard
		int counter = player.getCurrentLocation();
		int dice = Dice.rollDice();
		for (int count = 0; count < dice; count++) {
			counter++;
			player.setCurrentLocation(player.getCurrentLocation() + 1);
			if (counter > 11) {
				player.setCurrentLocation(0);
				Go.payday(player);
				counter = 0;
			}
		}
		// Determining what occurs on the square the player has landed on
		Iterator<Square> determineSquare = Gameboard.iterator();
		while (determineSquare.hasNext()) {
			System.out.println("rub jeff");
			if (determineSquare.next().getName() == SquareNames.FREE_SESSION
					&& Gameboard.get(counter).equals(player.getCurrentLocation())) {
				// the player has landed on the Free Session space, and an appropriate message
				// is displayed
				determineSquare.next().displaySquare();

			} else if (determineSquare.next().getName() == SquareNames.GO
					&& Gameboard.get(counter).equals(player.getCurrentLocation())) {
				determineSquare.next().displaySquare();
				// nothing happens, as the player has already been paid for passing Go above
			} else { 
				// the player has landed on a computer square, now we determine if the current
				// player owns the square, if another player owns it or whether it is owned at
				// all.
				determineSquare.next().displaySquare();
				Computer computer = (Computer) determineSquare.next();
				if (computer.getOwner().isEmpty()) {
					// computer square is empty, current player is offered opportunity to buy the
					// square
					mhPackage.ComputerManager.buyComputer(scanner, player, computer, players);
				} else if (computer.getOwner().equals(player.getPlayerName())) {
					// as this is handled in the post selection menu, the player is simply moved
					// there
				} else {
					// the player has landed on a computer square owned by another player
					mhPackage.ComputerManager.paySessionPrice(player, players, Gameboard);
					for (Player element : players) {
						if (element.getPlayerName() == computer.getOwner()) {
							player.setCurrentBalance(player.getCurrentBalance() - computer.getSessionPrice());
							element.setCurrentBalance(element.getCurrentBalance() + computer.getSessionPrice());
							if (player.getCurrentBalance() < 1) {
								EndGame.gameEnder(player, players);
							}
						}
					}
				}
			}
		}
	} 
}