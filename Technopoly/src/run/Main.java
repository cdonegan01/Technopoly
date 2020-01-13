/**
 * 
 */
package run;

import java.util.ArrayList;
import java.util.Scanner;

import selectionMenu.*;
import player.*;
import square.*;

/**
 * @author 40130998
 *
 */
public class Main implements Confirmation{

	/**
	 * @param args
	 */
	public static ArrayList<Square> Gameboard = new ArrayList<>();
	
	public static ArrayList<Player> playerArray = new ArrayList<>(); 
	
	
	public final static int BASE_RESOURCES = 200;
	
	public final static int NO_OF_COMPUTERS = 10;
	
	public static boolean running = true;
	
	
	public static void main(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(System.in);) {
		// Generate the board
		Computer.generateGameBoard(Gameboard, NO_OF_COMPUTERS);
		Computer.displayBoard(Gameboard);
		
	
		
		
		
		
		
		ArrayList<Player> players = Player.enterNames(scanner, playerArray); 
		
		
		PreSelectionMenu preMenu = new PreSelectionMenu(); 
		
		PostSelectionMenu postMenu = new PostSelectionMenu(); 
		
		
		
		
		
		System.out.println("Each player begins on the GO square with " + BASE_RESOURCES + " resources.");	
		System.out.println();
		while (running) {
			for (Player p : players) {
				System.out.println(p.getPlayerName() + ", what would you like to do?");
	
				// display selection menu to player
				System.out.println();
				preMenu.chooseOption(scanner, Gameboard,p, players); 
				
				postMenu.chooseOption(scanner, Gameboard, p, players);
				
			}
		}
	} catch (Exception ex) {
		System.out.println("Main issue, please resolve before rebooting");
		ex.printStackTrace(); 
	}
	}
	


	
	
	
}