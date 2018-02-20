package obj.mod;

import java.util.Scanner;

public class Ticket {
	private int ticketNo;
	private String from[];
	private String destination[];
	private int updatedTicket;
	private int bookedTicket;
	private String ticketStatus;
	private String classOfSeat;
	Scanner scan = new Scanner(System.in);

	public String[] getDestination() {
		return destination;
	}

	public void setDestination(String[] destination) {
		this.destination = destination;
	}

	public String[] getFrom() {
		return from;
	}

	public void setFrom(String[] from) {
		this.from = from;
	}

	public void getTicket() {
		System.out.println();
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public int getBookedTicket() {
		return bookedTicket;
	}

	public void setBookedTicket(int bookedTicket) {
		this.bookedTicket = bookedTicket;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public int getUpdatedTicket() {
		return updatedTicket;
	}

	public void setUpdatedTicket(int updatedTicket) {
		this.updatedTicket = updatedTicket;
	}

	public String getClassOfSeat() {
		return classOfSeat;
	}

	public void setClassOfSeat(String classOfSeat) {
		this.classOfSeat = classOfSeat;
	}

}
