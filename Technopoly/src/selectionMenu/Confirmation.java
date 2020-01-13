package selectionMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract interface Confirmation {

	public static  boolean confirm(Scanner scanner) {
		int choice;
		boolean valid = false;
		boolean confirmation = false;
		do {
			try {

				System.out.println("Are you sure?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				choice = scanner.nextInt();

				if (choice == 1) {
					valid = true;
					confirmation = true;
				} else if (choice == 2) {
					valid = true;
					scanner.nextLine();

				} else {
					System.out.println("Invalid Selection.");

				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again.");
				scanner.nextLine(); 
			}

		} while (!valid);
		return confirmation;
	}
} 