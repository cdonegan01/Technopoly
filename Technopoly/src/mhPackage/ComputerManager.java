/**
 *
 */
package mhPackage;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import player.Player;
import square.*;
import run.EndGame;
import selectionMenu.Confirmation;
 
/**
 * @author User
 *
 */
public class ComputerManager implements Confirmation {
 
    /**
     *
     */
    public ComputerManager() {
 
    }
 
    /**
     * subtracts square price from player balance
     *
     * @param p
     * @param ps
     */
    public static void buyComputer(Scanner scanner, Player p, Computer c, ArrayList<Player> players) {
        System.out.println(c.getName() + " is unowned! Do you want to buy it?");
 
        if (p.getCurrentBalance() - c.getComputerPrice() > 0) {
            System.out.println("Your purchase will leave you with " + (p.getCurrentBalance() - c.getComputerPrice()) + ".");
            if (Confirmation.confirm(scanner)) {
                p.setCurrentBalance(p.getCurrentBalance() - c.getComputerPrice());
                c.setOwner(p.getPlayerName());
                System.out.println(p.getPlayerName() + ", you own " + c.getName() + "!");
            } else {
 
            }
        } else {
            System.out.println("This purchase will bankrupt you!");
            if (Confirmation.confirm(scanner)) {
                p.setCurrentBalance(p.getCurrentBalance() - c.getComputerPrice());
                c.setOwner(p.getPlayerName());
                EndGame.gameEnder(p, players);
            } else {
 
            }
        }
    }
 
    public void buyUpgrade(Scanner scanner, Player p, Computer c, ArrayList<Player> players) throws Exception {
 
        if (p.getCurrentBalance() - c.getUpgradePrice() > 0) {
        	System.out.println("This purchase will leave you with " + p.getCurrentBalance() + ".");
        	if (Confirmation.confirm(scanner)) {
	            p.setCurrentBalance(p.getCurrentBalance() - c.getUpgradePrice());
	            c.setUpgradeLevel(c.getUpgradeLevel() + 1);
	            System.out.println(c.getName() + " is set to level " + c.getUpgradeLevel() + ".");
	            if (c.getUpgradeLevel() < 3) {
	                c.setSessionPrice(c.getSessionPrice() + c.getUpgradePrice());
	                System.out.println("Session price set to " + c.getSessionPrice());
	            } else {
	                c.setSessionPrice(c.getSessionPrice() + c.getUpgradePrice());
	                System.out.println("Session price set to " + c.getSessionPrice());
	            }
        	}
        } else {
            System.out.println("This purchase will bankrupt you!");
            if (Confirmation.confirm(scanner)) {
                p.setCurrentBalance(p.getCurrentBalance() - c.getUpgradePrice());
                c.setOwner(p.getPlayerName());
                EndGame.gameEnder(p, players);
            }
        }
    }
 
    /**
     * deduct rent from player on owned square and pay landlord
     */
    public static void paySessionPrice(Player player, ArrayList<Player> playerList, ArrayList<Square> gameboard) {
 
        Iterator<Square> sessionCalc = gameboard.iterator();
        while (sessionCalc.hasNext()) {
            Computer computer = (Computer) sessionCalc.next();
            if (gameboard.indexOf(computer) == player.getCurrentLocation()) {
                for (Player element : playerList) {
                    if (element.getPlayerName() == computer.getOwner()) {
                        player.setCurrentBalance(player.getCurrentBalance() - computer.getSessionPrice());
                        System.out.println(computer.getSessionPrice() + " deducted from " + player.getPlayerName() + ".");
                        element.setCurrentBalance(element.getCurrentBalance() + computer.getSessionPrice());
                        System.out.println(computer.getSessionPrice() + " paid to " + element.getPlayerName() + ".");
                        if (player.getCurrentBalance() < 1) {
                            EndGame.gameEnder(player, playerList);
                        }
                    }
                }
            }
        }
    }
   

}