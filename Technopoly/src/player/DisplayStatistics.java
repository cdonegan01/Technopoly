/**
 * 
 */
package player;

import java.util.ArrayList;
import java.util.Iterator;

import player.Player;
import square.*;


/**
 * @author 40130998
 *
 */
public class DisplayStatistics {
	
	public static ArrayList<Square> Gameboard = new ArrayList<>();
	
	/**
	 * 
	 */
	public DisplayStatistics() {

	}

	public static void displayStatistics(ArrayList<Square> Gameboard, Player p) {

		System.out.println();
		System.out.println("Player: " + p.getPlayerName());
		System.out.println("Current balance: " + p.getCurrentBalance());

		System.out.println("Computers owned: ");
		Iterator<Square> displayer=Gameboard.iterator();

		while(displayer.hasNext()) {

			Computer computer = (Computer) displayer.next();
			if (computer.getOwner().equals(p.getPlayerName())) {
				System.out.println(computer.getName());
				System.out.println("Level: " + computer.getUpgradeLevel());
			}
			displayer.next().displaySquare();
		}
	}
}
