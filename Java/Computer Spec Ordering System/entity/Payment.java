package entity;

import template.PaymentOption;

public class Payment {
	private PaymentOption paymentOption;
	private double amount;

	public Payment(PaymentOption paymentOption, double amount) {
		this.paymentOption = paymentOption;
		this.amount = amount;
	}

	public PaymentOption getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(PaymentOption paymentOption) {
		this.paymentOption = paymentOption;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}