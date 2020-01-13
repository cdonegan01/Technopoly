/**
 * 
 */
package square;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;
import java.util.List;

import player.Player;

// import square.*;

/**
 * @author Brendan
 *
 */
public class Computer extends Square {
	// Computer Array
	public static ArrayList<Square> Gameboard = new ArrayList<Square>();

	public static List<SquareNames> squareNames = Arrays.asList(SquareNames.values());

	// Enum

	FieldNames fieldNames;
	// Constants
	public static int compPriceMin = 400;
	public static int compPriceMax = 2500;
	public static int sessPriceMin = 100;
	public static int sessPriceMax = 2500;
	public static int upPriceMin = 100;
	public static int upPriceMax = 1000;
	public static int upLevelMin = 0;
	public static int upLevelMax = 4;
	public static int field1Limit = 2;
	public static int field2Limit = 3;
	public static int field3Limit = 3;
	public static int field4Limit = 2;

	// Instance Variables

	private String owner;
	private int computerPrice;
	private int sessionPrice;
	private int upgradePrice;
	private int upgradeLevel = 0;
	private int field;

	// Constructors
	/**
	 * Default Constructors
	 */
	public Computer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @throws Exception
	 */
	public Computer(SquareNames name, String owner, int computerPrice, int sessionPrice, int upgradePrice,
			int upgradeLevel, int field) throws Exception {
		super(name);
		this.setComputerPrice(computerPrice);
		this.setSessionPrice(sessionPrice);
		this.setUpgradePrice(upgradePrice);
		this.setUpgradeLevel(upgradeLevel);
		this.setField(field);
		this.setOwner(owner);
		// TODO Auto-generated constructor stub
	}
	// Methods

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param Player the owner to set
	 */
	public void setOwner(String Player) {
		this.owner = Player;
	}

	/**
	 * @return the computerPrice
	 */
	public int getComputerPrice() {
		return computerPrice;
	}

	/**
	 * @param computerPrice the computerPrice to set
	 * @throws Exception
	 */
	public void setComputerPrice(int computerPrice) throws Exception {
		if (computerPrice >= compPriceMin && computerPrice <= compPriceMax) {
			this.computerPrice = computerPrice;
		} else {
			throw new Exception("Computer Price Assignment Error");
		}

	}

	/**
	 * @return the baseRent
	 */
	public int getSessionPrice() {
		return sessionPrice;
	}

	/**
	 * @param baseRent the baseRent to set
	 */
	public void setSessionPrice(int sessionPrice) throws Exception {
		if (sessionPrice >= sessPriceMin && sessionPrice <= sessPriceMax) {
			this.sessionPrice = sessionPrice;
		} else {
			throw new Exception("Session Price Assignment Error");
		}
	}

	/**
	 * @return the housePrice
	 */
	public int getUpgradePrice() {
		return upgradePrice;
	}

	/**
	 * @param upgradePrice the housePrice to set
	 */
	public void setUpgradePrice(int upgradePrice) throws Exception {
		if (upgradePrice >= upPriceMin && upgradePrice <= upPriceMax) {
			this.upgradePrice = upgradePrice;
		} else {
			throw new Exception();
		}
	}

	/**
	 * @return the upgradeLevel
	 */
	public int getUpgradeLevel() {
		return upgradeLevel;
	}

	/**
	 * @param upgradeLevel the upgradeLevel to set
	 */
	public void setUpgradeLevel(int upgradeLevel) throws Exception {
		if (upgradeLevel >= upLevelMin && upgradeLevel <= upLevelMax) {
			this.upgradeLevel = upgradeLevel;
		} else {
			throw new Exception("Upgrade Assignment Error");
		}
	}

	/**
	 * @return the field
	 */
	public int getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 * @throws Exception
	 */
	public void setField(int field) throws Exception {
		if (field >= 1 && field <= 4) {
			this.field = field;
		} else {
			throw new Exception("Field Assignment Error");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see square.Square#displaySquare()
	 */
	@Override
	public void displaySquare() {
		// TODO Auto-generated method stub
		FieldNames fieldName;

		super.displaySquare();
		// System.out.println("Location : \t\t\t\t" + Gameboard.);
		System.out.println("Computer Owner : \t\t\t" + getOwner());
		System.out.println("Computer Price : \t\t\t" + getComputerPrice());
		System.out.println("Computer Session Price : \t\t" + getSessionPrice());
		System.out.println("Computer Upgrade Price : \t\t" + getUpgradePrice());
		System.out.println("Computer Current Upgrade Level : \t" + getUpgradeLevel());
		if (getField() == 1) {
			fieldName = FieldNames.ANTIQUES;
			System.out.println("Computer Field: \t\t\t" + fieldName);
		} else if (getField() == 2) {
			fieldName = FieldNames.CLASSIC;
			System.out.println("Computer Field: \t\t\t" + fieldName);
		} else if (getField() == 3) {
			fieldName = FieldNames.RETRO;
			System.out.println("Computer Field: \t\t\t" + fieldName);
		} else if (getField() == 4) {
			fieldName = FieldNames.ELITE;
			System.out.println("Computer Field: \t\t\t" + fieldName);
		}

	}

	public static ArrayList<Square> generateGameBoard(ArrayList<Square> Gameboard, int numberOfSquares) throws Exception {
		// Local Vars
		int field1 = 0;
		int field2 = 0;
		int field3 = 0;
		int field4 = 0;
		int compPriceTemp = compPriceMin;
		int compPriceMod = ((compPriceMax - compPriceMin) / (numberOfSquares - 1));
		int sessPriceTemp = sessPriceMin;
		int sessPriceMod = ((sessPriceMax - sessPriceMin) / (numberOfSquares - 1));
		int upPriceTemp = upPriceMin;
		int upPriceMod = ((upPriceMax - upPriceMin) / (numberOfSquares - 1));

		// Iterators setting the ascending price of squares.
		for (int index = 0; index < numberOfSquares + 2; index++) {
			int fieldName = 0;
			if (index == 0) {
				Gameboard.add(new Go(squareNames.get(index), Go.getPASS_GO_PAY()));
			} else if (index == ((numberOfSquares / 2) + 1)) {
				Gameboard.add(new FreeSession(squareNames.get(index),
						"Congratulations you have won a free session at a New Café!"));
			} else {
				if (field1 < field1Limit) {
					fieldName = 1;
					field1++;
				} else if (field2 < field2Limit) {
					fieldName = 2;
					field2++;
				} else if (field3 < field3Limit) {
					fieldName = 3;
					field3++;
				} else if (field4 < field4Limit) {
					fieldName = 4;
					field4++;
				}
				Gameboard.add(new Computer(squareNames.get(index), null, compPriceTemp, sessPriceTemp, upPriceTemp,
						upLevelMin, fieldName));
				compPriceTemp += compPriceMod;
				sessPriceTemp += sessPriceMod;
				upPriceTemp += upPriceMod;
			}

		}
		//		System.out.println(Gameboard.size());

		return Gameboard;
	}

	public static void displayBoard(ArrayList<Square> Gameboard, ArrayList<Player> players) throws Exception {
		Iterator<Square> displayBoard = Gameboard.iterator();
		while (displayBoard.hasNext()) {
			displayBoard.next().displaySquare();
			for (int count = 0; count < players.size(); count++) {
				if (Gameboard.get(count) == 
			}
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.println();
		}
	}
//	public static void main(String[] args) {
//		generateGameBoard(10);
//		
//		Iterator<Square> displayBoard = Gameboard.iterator();
//		while (displayBoard.hasNext()) {
//			Computer computer = (Computer) displayBoard.next();
//			computer.getName();
//		}
//	}

}
