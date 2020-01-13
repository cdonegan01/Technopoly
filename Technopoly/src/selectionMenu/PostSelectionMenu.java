package selectionMenu;

import java.util.ArrayList;
import run.EndGame;
import java.util.Iterator;
import java.util.Scanner;


import mhPackage.ComputerManager;
import square.*;
import player.*;



public class PostSelectionMenu extends SelectionMenu implements Confirmation {

	public static ArrayList<Square> Gameboard = new ArrayList<>();
	
	private static boolean exitedGame;
	Scanner choose = new Scanner(System.in);
	boolean harness = true;
	
	public static ArrayList<Integer> compList;
	@Override
	public void printMenu(ArrayList<Square> gameboard, Player p, ArrayList<Player> players) {

		System.out.println("What would you like to do next?");
		System.out.println("1. Display Statistics");
		System.out.println("2. Display Portfolio");
		if (checkForUpgrade(gameboard, p)) { // harness for PlayerPortfolio boolean
			System.out.println("3. Buy Upgrade");
			System.out.println("4. End Turn");
			System.out.println("5. Exit Game");
		} else {
			System.out.println("3. End Turn");
			System.out.println("4. Exit Game");
		}
	}

	@Override
	public void chooseOption(Scanner scanner, ArrayList<Square> gameboard, Player p, ArrayList<Player> players) {

		int choice = 0;
		boolean valid = false;
		/*
		 * Check player can buy upgrades
		 */
		if (checkForUpgrade(gameboard, p)) { // harness for PlayerPortfolio boolean
			/**
			 * Iterate until valid choice
			 */
			do {
				/**
				 * Try catch for valid int input in scanner
				 */
				try {
					printMenu(gameboard, p, players);
					choice = choose.nextInt();

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
						compSelecta(gameboard, p, players);
						
						valid = false;
						break;
					case 4:
						if (Confirmation.confirm(scanner)) {
							valid = true;
							break;
						} else {
							break;
						}
					case 5:
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
					choose.next();

				}
			} while (!valid);

			/**
			 * alternative if player does not have complete field and can't buy upgrades
			 */
		} else {
			/**
			 * Iterate until valid choice
			 */
			do {
				/**
				 * Try catch for valid int input in scanner
				 */
				try {
					printMenu(gameboard, p, players);
					choice = choose.nextInt();

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

						if (Confirmation.confirm(scanner)) {
							valid = true;
						}
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
					choose.next();

				}
			} while (!valid);

		}
		choose.close();

	}


	public static boolean isExitedGame() {
		return exitedGame;
	}

	public void setExitedGame(boolean exitedGame) {
		PostSelectionMenu.exitedGame = exitedGame;
	}
	
	public void compSelecta(ArrayList<Square> gameboard, Player p, ArrayList<Player> players) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		ArrayList<Computer> playerSelection = new ArrayList<>();
		if (checkForUpgrade(gameboard, p)) {
			ComputerManager cM = new ComputerManager();
			compList = checkForField(gameboard, p);
			System.out.println("Please Choose Which Property you would like to buy and upgrade for:\n");
			for (Square square : gameboard) {
				Computer computer = (Computer) square;
				if(computer.getField()==compList.indexOf(option)) {
					playerSelection.add(computer);
					System.out.printf("%d: %s\n", (option++), (computer.getName()));
				}
			}
			int selection=scanner.nextInt();
			for (Computer computer : playerSelection) {
				if(playerSelection.indexOf(computer)==selection) {
					cM.buyUpgrade(scanner, p, computer, players);
			}
			}
		}
		scanner.close();
	}
	
	public ArrayList<Integer> checkForField(ArrayList<Square> gameboard, Player p) {
		ArrayList<Integer> compList = new ArrayList<Integer>();
		int field1 = 0, field2 = 0, field3 = 0, field4 = 0;
		Iterator<Square> checker = gameboard.iterator();
		while (checker.hasNext()) {
			Computer computer = (Computer) checker.next();
			if (computer.getOwner().equals(p.getPlayerName())) {
				switch (computer.getField()) {
				case 1:
					field1++;
					if (field1 == Computer.field1Limit) {
						compList.add(1);
						break;
					} else {
						break;
					}
				case 2:
					field2++;
					if (field2 == Computer.field2Limit) {
						compList.add(2);
						break;
					} else {
						break;
					}
				case 3:
					field3++;
					if (field3 == Computer.field3Limit) {
						compList.add(3);
						break;
					} else {
						break;
					}				
				case 4:
					field4++;
					if (field4 == Computer.field4Limit) {
						compList.add(4);
						break;
					} else {
						break;
					}	
				default:
					break;
				}				
			}
		}
		return compList;
	}
	
	public boolean checkForUpgrade(ArrayList<Square> gameboard, Player p) {
		int field1 = 0, field2 = 0, field3 = 0, field4 = 0;
		Iterator<Square> checker = gameboard.iterator();
		while (checker.hasNext()) {
			
			Computer computer = (Computer) checker.next();
			
			if (computer.getOwner().equals(p.getPlayerName())) {
				switch (computer.getField()) {
				case 1:
					field1++;
					break;
				case 2:
					field2++;
					break;
				
				case 3:
					field3++;
					break;
				
				case 4:
					field4++;
					break;
				default:
					break;
				}				
			}
		}
		if (field1 == Computer.field1Limit || field2 == Computer.field2Limit || field3 == Computer.field3Limit || field4 == Computer.field4Limit) {
			return true;
		} else {
			return false;
		}
	}		
}