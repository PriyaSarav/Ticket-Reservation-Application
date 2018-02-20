package obj.mod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

	public static void main(String args[]) throws Exception {
		System.out.println("---WELCOME TO ONLINE TICKET RESERVATION SYSTEM----");
		Reservation_System app = new Reservation_System();
		int choice = 0;
		boolean loginStatus = app.login();
		if (loginStatus) {
			do {
				try {
					System.out.println("Choose options");
					System.out.println("1.Book ticket 2.Cancel ticket  3.View Ticket  4.Exit");
					Scanner input = new Scanner(System.in);
					choice = input.nextInt();
					switch (choice) {
					case 1:
						app.bookTicket();
						break;
					case 2:
						app.cancelTicket();
						break;
					case 3:
						app.viewTicket();
						break;
					case 4:
						app.doExit();
						break;
					}
					// input.close();
				} catch (InputMismatchException e) {
					System.out.println("Input type mismatch error occurred, Provide a proper input");
				}
			} while (choice != 4);

		}
	}
}