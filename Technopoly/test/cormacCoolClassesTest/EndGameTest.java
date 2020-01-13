package cormacCoolClassesTest;

import static org.junit.Assert.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import cormacCoolClasses.EndGame;
import cormacCoolClasses.Player;

public class EndGameTest extends EndGame {
	
	/**
	 * tEST
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGameEnderExitGame() {
		
		int currentPlayer = 1;
		
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", 5, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 600, 0);
		
		Player[] players = new Player[4];
		
		players[0] = player1;
		players[1] = player2;
		players[2] = player3;
		players[3] = player4;
		
		boolean exitedGame = true;
		
		if (exitedGame == true) {
			System.out.println(players[currentPlayer].getPlayerName()+" took the coward's way out. Game Over!");
		} else {
			System.out.println(players[currentPlayer].getPlayerName()+" has gone bankrupt. Game Over!");
		}
		determineWinner(players);
		
		System.out.println("Sadly, all good things must come to an end. And so this game of Technopoly draws to a close.");
		System.out.println("But, just for you, I'm willing to let you take another ride on the Technopoly rollercoaster. Do you want to play again?");
		System.out.println("Please make your selection: ");
		System.out.println("1. Yes");
		System.out.println("2. No");
		
		int restartGameChoice = 2; 
        boolean valid = false;
		do {
            try {
                switch (restartGameChoice) {
                case 1:
                    System.out.println("As you wish! The Cosmic Ballet goes on!");
        			//startGame();
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
            }
        } while (!valid);
		
	}
	
	@Test
	public void testGameEnderBankrupcy() {
		
		int currentPlayer = 1;
		
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", -50, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 600, 0);
		
		Player[] players = new Player[4];
		
		players[0] = player1;
		players[1] = player2;
		players[2] = player3;
		players[3] = player4;
		
		boolean exitedGame = false;
		
		if (exitedGame == true) {
			System.out.println(players[currentPlayer].getPlayerName()+" took the coward's way out. Game Over!");
		} else {
			System.out.println(players[currentPlayer].getPlayerName()+" has gone bankrupt. Game Over!");
		}
		determineWinner(players);
		
		System.out.println("Sadly, all good things must come to an end. And so this game of Technopoly draws to a close.");
		System.out.println("But, just for you, I'm willing to let you take another ride on the Technopoly rollercoaster. Do you want to play again?");
		System.out.println("Please make your selection: ");
		System.out.println("1. Yes");
		System.out.println("2. No");
		
		int restartGameChoice = 2; 
        boolean valid = false;
		do {
            try {
                switch (restartGameChoice) {
                case 1:
                    System.out.println("As you wish! The Cosmic Ballet goes on!");
        			//startGame();
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
            }
        } while (!valid);
		
	}

	@Test
	public void testDetermineWinner() {
		
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", 5, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 600, 0);
		
		Player[] players = new Player[4];
		
		players[0] = player1;
		players[1] = player2;
		players[2] = player3;
		players[3] = player4;
		
		determineWinner(players);
		
	}
	
	@Test
	public void testDrawDetermineWinner() {
		
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", 500, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 500, 0);
		
		Player[] players = new Player[4];
		
		players[0] = player1;
		players[1] = player2;
		players[2] = player3;
		players[3] = player4;
		
		determineWinner(players);
		
	}

}
