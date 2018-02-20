package obj.mod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Transaction implements Payment {
	private String cardHolderName;
	private String cardNum;
	private int totalAmt;

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}

	// Method Overriding
	public void pay(int totalAmt) {
		boolean invalid = false;
		do {
			try {
				Scanner scObj = new Scanner(System.in);
				do {
					invalid = false;
					System.out.println("Enter card number");
					cardNum = scObj.next();
					if (cardNum.length() == 16) {
						setCardNum(cardNum);
					} else {
						invalid = true;
						System.out.println("Enter valid card Number of 16 digits!!");
					}
				} while (invalid == true);
				System.out.println("Enter card holder name");
				cardHolderName = scObj.next();
				setCardHolderName(cardHolderName);
				System.out.println(totalAmt + " paid with credit card " + cardNum);
			} catch (InputMismatchException e) {
				invalid = true;
				System.out.println("Input type mismatch error occurred");
			}
		} while (invalid == true);
	}

	public double pay(double totalAmt) {
		System.out.println(totalAmt + " paid with credit card");
		return totalAmt;
	}
}
