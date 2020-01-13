package selectionMenu;

import java.util.ArrayList;
import java.util.Scanner;

import player.*;
import square.*;
import run.*;

public class PreSelectionMenu extends SelectionMenu implements Confirmation {

	private static boolean exitedGame;
	public static ArrayList<Square> Gameboard = new ArrayList<>();

	@Override
	public void printMenu(ArrayList<Square> gameboard, Player p, ArrayList<Player> players) {
		System.out.println("What would you like to do next?");
		System.out.println("1. Display Statistics");
		System.out.println("2. Display Board");
		System.out.println("3. Roll Dice");
		System.out.println("4. Exit Game");
	}

	
	public void chooseOption(Scanner scanner, ArrayList<Square> gameboard, Player p, ArrayList<Player> players) {

		int choice = 0;
		boolean valid = false;

		/**
		 * Iterate until valid choice
		 */
		do {
			/**
			 * Try catch for valid int input in scanner
			 */
			try {

				printMenu(gameboard, p, players);
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					DisplayStatistics.displayStatistics(Gameboard, p);
					valid = false;
					break;
				case 2:
					Computer.displayBoard(Gameboard);
					valid = false;
					break;
				case 3:
					PlayerLocationUpdater.updatePlayerLocation(scanner, p, Gameboard, players);
					valid = true;
					break;
				case 4:
					if (Confirmation.confirm(scanner)) {
						setExitedGame(true);
						EndGame.gameEnder(p, players);
						valid = true; 
						break;
					} else {
						break;
					} 


				default:
					System.out.println("Invalid selection, try again");
					valid = false;
				}

			} catch (Exception e) {
				System.out.println("Invalid input, please try again.");
				scanner.next();

			}
		} while (!valid);
	}

	public static boolean isExitedGame() {
		return exitedGame;
	}

	public void setExitedGame(boolean exitedGame) {
		PreSelectionMenu.exitedGame = exitedGame;
	}





		

}