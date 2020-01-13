/**
 * 
 */
package square;

import player.Player;

/**
 * @author Brendan
 *
 */
public class Go extends Square {
	
	// Instance Vars
	private static int PASS_GO_PAY = 2000;
	
	// Constructors
	
	
	/**
	 * @param name
	 */
	
	public Go(SquareNames squareName, int PASS_GO_PAY) {
		this.name = squareName;
		Go.PASS_GO_PAY = PASS_GO_PAY;
		// TODO Auto-generated constructor stub
	}
	// Methods

	/**
	 * @return the pASS_GO_PAY
	 */
	public static int getPASS_GO_PAY() {
		return PASS_GO_PAY;
	}
	/**
	 * Method to Pay Player P1
	 * @param p1
	 */
	public static void payday(Player p1) {
		int currentBalance = p1.getCurrentBalance();
		p1.setCurrentBalance(currentBalance + PASS_GO_PAY);
		System.out.println("Your Just Got Paid!");
		System.out.println("Updated Player Balance : \t"+currentBalance);
		
		
	}
	
	
}