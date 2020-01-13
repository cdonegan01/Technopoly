package run;

import java.util.Random;

public class Dice {

	public static int diceOne() {
		int diceFace = 4;

		Random rand = new Random();

		int dice1;

		dice1 = rand.nextInt(diceFace) + 1;

		return dice1;
	}

	public static int diceTwo() {
		int diceFace = 4;

		Random rand = new Random();

		int dice2;

		dice2 = rand.nextInt(diceFace) + 1;

		return dice2;
	}

	public static int rollDice() {
		int dice1, dice2; 
		dice1 = diceOne(); 
		dice2 = diceTwo(); 
		System.out.println("You rolled " + dice1 + " and " + dice2 + ".");
		int totalRoll = dice1+dice2; 
		System.out.println("Your total roll is " + totalRoll + "!");
		return totalRoll;
	}
}
