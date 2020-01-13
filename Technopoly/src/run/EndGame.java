package run;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import player.Player;
import selectionMenu.PostSelectionMenu;
import selectionMenu.PreSelectionMenu;

/**
 * @author Cormac
 * This class holds all methods relating to ending the game, either through exiting manually or one player going below 0 on their balance
 *
 */
public class EndGame {
	
	
	/**
	 * This method begins the process of ending the game
	 * @param player
	 * @param players
	 * @throws InputMismatchException
	 */
	public static void gameEnder(Player player, ArrayList<Player> players) throws InputMismatchException {

		Scanner restartGameScanner = new Scanner(System.in);
		
		//determining whether or not the player has manually exited the game 
		if (PreSelectionMenu.isExitedGame() == true || PostSelectionMenu.isExitedGame() == true) {
			System.out.println(player.getPlayerName() + " took the coward's way out. Game Over!");
		} else {
			System.out.println(player.getPlayerName() + " has gone bankrupt. Game Over!");
		}
			
		//calling a method to determine the winner of the game and print the result to screen
		determineWinner(players);

		System.out.println("Sadly, all good things must come to an end. And so this game of Technopoly draws to a close.");
		System.out.println("But, just for you, I'm willing to let you take another ride on the Technopoly rollercoaster. Do you want to play again?");
		System.out.println("Please make your selection: ");
		System.out.println("1. Yes");
		System.out.println("2. No");
		
		//the player choosing whether or not they wish to play the game again
		int restartGameChoice;
		boolean valid = false;
		do {
			try {
				restartGameChoice = restartGameScanner.nextInt();
				switch (restartGameChoice) {
				case 1:
					System.out.println("As you wish! The Cosmic Ballet goes on!");
					// startGame();
					valid = true;
					break;
				case 2:
					System.out.println("As you wish. Until we meet again, my friends!");
					valid = true;
					break;
				default:
					System.out.println("Invalid selection, try again");
					valid = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again.");
				restartGameScanner.next();
			}
		} while (!valid);

		restartGameScanner.close();

	}
	
	/**
	 * This method determines the winner of the game, or whether or not there was a draw, and prints the result to screen
	 * @param players
	 */
	public static void determineWinner(ArrayList<Player> players) {
		int highestBalance = -9999;
		String winner = "";
		boolean draw = false;
		for (Player element : players) {
			if (element.getCurrentBalance() > highestBalance) {
				highestBalance = element.getCurrentBalance();
				winner = element.getPlayerName();
			} else if (element.getCurrentBalance() == highestBalance) {
				System.out.println("Incredible! " + element.getPlayerName() + " has the exact same amount of money as "
						+ winner + "! It's a draw!");
				draw = true;
			}
		}
		if (draw == true) {
			System.out.println(
					"The game has ended as a draw, with the following players sharing the wealth and glories of victory! Truly, the real Technopoly was friendship all along.");
			for (Player element : players) {
				if (element.getCurrentBalance() == highestBalance) {
					System.out.println(element.getPlayerName());
				}
			}
			System.out.println();
		} else {
			System.out.println(
					"Congratulations, " + winner + ", you have won the game with an astonishing " + highestBalance
							+ " in the bank! You may lord this victory over your friends for the rest of time.");
			System.out.println();
		}

		System.out.println("Final Rankings: ");
		for (Player element : players) {
			System.out.println(element.getPlayerName() + " ended the game with " + element.getCurrentBalance()
					+ " in their account.");
		}
		System.out.println();
	}
}