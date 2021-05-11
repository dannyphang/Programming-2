package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import template.PaymentOption;
import util.Input_Validator;
import util.Utility;

public class Card extends PaymentOption {
	private String cardNum;
	private String cvv;
	private String expiryDate;
	private String vendor;

	public Card(String cardNum, String cvv, String expiryDate) {
		super();
		this.cardNum = cardNum;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
		checkVendor();
	}

	// getter & setter
	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public static boolean validateCardNum(String cardNum) {
		int cardnumarray[] = new int[12];
		if (cardNum.length() == 12 && Input_Validator.isNumeric(cardNum)) {
			for (int i = 0; i < 12; i++) {
				cardnumarray[i] = Character.getNumericValue(cardNum.charAt(i));
			}
			if ((cardnumarray[0] == 8 && cardnumarray[1] == 7) || (cardnumarray[0] == 4 && cardnumarray[1] == 9)) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateExpDate(String expiryDate) throws ParseException {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
			simpleDateFormat.setLenient(false);
			Date expiry = simpleDateFormat.parse(expiryDate);
			return expiry.after(new Date());
		} catch (ParseException  e) {
			throw e;
		}
	}

	public static boolean validateCVV(String cvv) {
		return Input_Validator.isNumeric(cvv) && cvv.length() == 3;
	}

	private void checkVendor() {
		String cardPrefix = cardNum.substring(0, 2);
		switch (cardPrefix) {
		case "87":
			vendor = "Vosa";
			break;
		default:
			vendor = "Mastor";
		}
	}

	public static String heading() {
		return PaymentOption.heading()+String.format("%-15s %-5s %-7s\n", "Card No.", "CVV", "Expiry Date")+Utility.repeat(50, "=");
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%-15s %-5s %-7s", cardNum, cvv, expiryDate);
	}
}