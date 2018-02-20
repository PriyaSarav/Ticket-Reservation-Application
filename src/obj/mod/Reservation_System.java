package obj.mod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reservation_System {
	String name;
	String contact;
	int age;
	int choice;
	String ClassOfSeat;
	int ticketNo = 500;
	boolean invalid = false;
	boolean status = false;
	String gender;
	int bookedTicket = 0;
	String[] source = { "Chennai", "Coimbatore" };
	String[] destination = { "Trichy", "Delhi" };
	int updatedTicket;
	Passenger_Details passenger = new Passenger_Details();
	Ticket tk = new Ticket();

	// Method to login
	public boolean login() {
		String userName;
		String password;
		Scanner input = new Scanner(System.in);
		do {
			invalid = false;
			System.out.println("Enter Username: ");
			userName = input.nextLine();
			if ((userName.contains(" "))) {
				invalid = true;
				System.out.println("Incorrect usrname! whitespace is not allowed");
			}
		} while (invalid == true);
		do {
			invalid = false;
			System.out.println("Enter password");
			password = input.nextLine();
			if (userName.equalsIgnoreCase(password)) {
				System.out.println("Login successful");
				return true;
			} else {
				invalid = true;
				System.out.println("Incorrect password!");
				// return false;
			}
		} while (invalid == true);
		return false;
	}

	//// Method to book
	public void bookTicket() throws Exception {
		String fromStation;
		String destinationStation;
		int amount, noOfPassengr = 0;
		int totalAmt = 0;
		int i = 0;
		try {
			do {
				invalid = false;
				System.out.println("Enter From");
				Scanner scObject = new Scanner(System.in);
				fromStation = scObject.next();
				if (((fromStation.equalsIgnoreCase("chennai")) || (fromStation.equalsIgnoreCase("coimbatore")))) {
					tk.setFrom(source);
				} else {
					invalid = true;
					System.out.println("No from available in this name");
				}
			} while (invalid == true);
			do {
				invalid = false;
				System.out.println("Enter Destination");
				Scanner scObj = new Scanner(System.in);
				destinationStation = scObj.next();
				if ((destinationStation.equalsIgnoreCase("Trichy")) || (destinationStation.equalsIgnoreCase("Delhi"))) {
					tk.setDestination(destination);
				} else {
					invalid = true;
					System.out.println("Destination is not available in this name");
				}
			} while (invalid == true);
			if ((destinationStation.equalsIgnoreCase("Trichy")) || (destinationStation.equalsIgnoreCase("Delhi"))) {
				do {
					try {
						invalid = false;
						Scanner scObjec = new Scanner(System.in);
						System.out.println("Enter passenger name: ");
						name = scObjec.next();
						passenger.setName(name);
					} catch (InputMismatchException e) {
						invalid = true;
						System.out.println("Enter a valid NAME!!");
					}
				} while (invalid == true);

				do {
					try {
						invalid = false;
						Scanner scObj1 = new Scanner(System.in);
						do {
							invalid = false;
							System.out.println("Enter 10 digit mobile num: ");
							contact = scObj1.next();
							if (contact.length() == 10) {
								passenger.setContact(contact);
							} else {
								invalid = true;
								System.out.println("Invalid mobile number!! enter 10 digit number");
							}
						} while (invalid == true);
					} catch (InputMismatchException e) {
						invalid = true;
						System.out.println("Enter a valid NUMBER!!");
					}
				} while (invalid == true);

				do {
					try {
						invalid = false;
						Scanner scObj2 = new Scanner(System.in);
						System.out.println("Enter age: ");
						age = scObj2.nextInt();
						if (age >= 6 && age <= 150) {
							passenger.setAge(age);
						} else {
							System.out.println("Enter the age properly!!");
							age = scObj2.nextInt();
							passenger.setAge(age);
						}
					} catch (InputMismatchException e) {
						invalid = true;
						System.out.println("Enter a valid AGE!!");
					}
				} while (invalid == true);

				do {
					try {
						invalid = false;
						do {
							Scanner scObj3 = new Scanner(System.in);
							System.out.println("Enter Gender: ");
							System.out.println("1.Male 2.Female");
							System.out.println("Select your Gender");
							choice = scObj3.nextInt();
							if (choice == 1) {
								gender = "MALE";
								passenger.setGender(gender);
							} else if (choice == 2) {
								gender = "FEMALE";
								passenger.setGender(gender);
							} else {
								System.out.println("Please enter 1 0r 2!!");
							}
						} while (choice >= 3);
					} catch (InputMismatchException e) {
						invalid = true;
						System.out.println("Enter a valid gender!!");
					}
				} while (invalid == true);

				do {
					try {
						do {
							Scanner scObj4 = new Scanner(System.in);
							System.out.println("select seat type");
							System.out.println("1.1A 2.2A 3.3A 4.SL");
							System.out.println("Enter your choice");
							choice = scObj4.nextInt();
							if (choice >= 1 && choice <= 4) {
								switch (choice) {
								case 1:
									ClassOfSeat = "1A";
									System.out.println("You have booked 1A seat for " + name);
									tk.setClassOfSeat(ClassOfSeat);
									break;
								case 2:
									ClassOfSeat = "2A";
									System.out.println("You have booked 2A seat for " + name);
									tk.setClassOfSeat(ClassOfSeat);
									break;
								case 3:
									ClassOfSeat = "3A";
									System.out.println("You have booked 3A seat for " + name);
									tk.setClassOfSeat(ClassOfSeat);
									break;
								case 4:
									ClassOfSeat = "SL";
									System.out.println("You have booked SL seat for " + name);
									tk.setClassOfSeat(ClassOfSeat);
									break;
								}
							} else {
								System.out.println("Please enter the available choice!!");
							}
						} while (choice >= 5);
					} catch (InputMismatchException e) {
						invalid = true;
						System.out.println("Enter a valid Choice!!");
					}
				} while (invalid == true);
				noOfPassengr++;
				Transaction trans = new Transaction();
				if (fromStation.equalsIgnoreCase("Chennai") && (destinationStation.equalsIgnoreCase("Trichy"))) {
					amount = 150;
					totalAmt = amount * noOfPassengr;
					trans.setTotalAmt(totalAmt);
				} else if (fromStation.equalsIgnoreCase("Coimbatore")
						&& (destinationStation.equalsIgnoreCase("Delhi"))) {
					amount = 300;
					totalAmt = amount * noOfPassengr;
					trans.setTotalAmt(totalAmt);
				} else if (fromStation.equalsIgnoreCase("Chennai") && (destinationStation.equalsIgnoreCase("Delhi"))) {
					amount = 420;
					totalAmt = amount * noOfPassengr;
					trans.setTotalAmt(totalAmt);
				} else if (fromStation.equalsIgnoreCase("Coimbatore")
						&& (destinationStation.equalsIgnoreCase("Trichy"))) {
					amount = 280;
					totalAmt = amount * noOfPassengr;
					trans.setTotalAmt(totalAmt);
				}
				trans.pay(totalAmt);
				ticketNo = ticketNo + 1;
				updatedTicket = ticketNo;
				tk.setUpdatedTicket(ticketNo);
				System.out.println("The ticket no is " + ticketNo);
				tk.setTicketNo(ticketNo);
				System.out.println("The ticket Status of " + ticketNo + " is Booked");
				tk.setTicketStatus("booked");
				// System.out.println(tk.getTicketStatus());
				bookedTicket++;
				tk.setBookedTicket(bookedTicket);
				passenger.display();
			}
		} catch (InputMismatchException e) {
			System.out.println("Input type mismatch error occurred");
		}
		// scObj.close();
	}

	// Method to cancel
	public void cancelTicket() throws Exception {
		int j = 0;
		do {
			Scanner userIn = new Scanner(System.in);
			try {
				do {
					System.out.println("Enter the ticketNumber to cancel");
					ticketNo = userIn.nextInt();
					if (ticketNo == updatedTicket && (!(tk.getTicketStatus().equals("Cancelled")))) {
						System.out.println("Your request for cancelling the ticketNo " + ticketNo + " is accepted");
						System.out.println("Ticket fare will be refunded to your account within 10days");
						System.out.println("The ticket Status of " + ticketNo + " is Cancelled");
						tk.setTicketStatus("Cancelled");
					} else {
						System.out.println("The ticket number entered is INVALID or Cancelled Already!!");
					}
					System.out.println("Want to cancel another ticket?? press 0 to menu 1 to cancel another ticket");
					j = userIn.nextInt();
				} while (j == 1);
			} catch (InputMismatchException e) {
				System.out.println("Input type mismatch error occurred");
				invalid = true;
			} catch (NullPointerException e) {
				System.out.println("Null Pointer Exception occrred!! No Tickets booked in your history");
				invalid = true;
			}
		} while (invalid == true);
		// userIn.close();
	}

	// Method to view Ticket
	public void viewTicket() {
		Scanner tkscan = new Scanner(System.in);
		System.out.println("Enter ticket number");
		ticketNo = tkscan.nextInt();
		if (bookedTicket == 0 || ticketNo != updatedTicket) {
			System.out
					.println("No Tickets available to view!! Make sure you booked ticket and giving correct ticketno");
		} else if (ticketNo == updatedTicket) {
			System.out.println("............Passenger Details......");
			System.out.println("Passenger name is " + name);
			System.out.println("Ticket no is " + ticketNo);
			System.out.println("Class of seat type is " + tk.getClassOfSeat());
			System.out.println("Ticket Status is " + tk.getTicketStatus());
			System.out.println("Passenger contact is " + contact);
			System.out.println("Passenger age is " + age);
			System.out.println("Passenger gender is " + gender);
			System.out.println("..............................");
		} else {
			System.out.println("No tickets available!!");
		}
	}

	public void doExit() {
		// TODO Auto-generated method stub
		System.out.println("Thanks for using Online Reservation System");
	}
}
