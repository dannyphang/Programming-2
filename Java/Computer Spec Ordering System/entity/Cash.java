package entity;

import template.PaymentOption;
import util.Utility;

public class Cash extends PaymentOption {
	private String currency;

	public Cash(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public static String heading() {
		return PaymentOption.heading()+String.format("%-15s\n", "Currency")+Utility.repeat(50, "=");
	}

	@Override
	public String toString() {
		return super.toString()+String.format("%-15s", currency);
	}
}