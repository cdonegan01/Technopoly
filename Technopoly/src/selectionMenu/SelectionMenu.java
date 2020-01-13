package selectionMenu;

import java.util.ArrayList;
import java.util.Scanner;

import player.Player;
import square.*;

public abstract class SelectionMenu {

	public abstract void printMenu(ArrayList<Square> gameboard, Player p, ArrayList<Player> players);
	


	public abstract void chooseOption(Scanner scanner, ArrayList<Square> gameboard, Player p, ArrayList<Player> players);

}
