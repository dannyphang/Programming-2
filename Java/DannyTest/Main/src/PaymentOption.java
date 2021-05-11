public abstract class PaymentOption {
	private String paymentID;
	private double paymentAmount;
	private static int paymentOptionNum;

	// constructor
	public PaymentOption() {
		this.paymentID = ("PO"+ paymentOptionNum);
		paymentOptionNum++;
	}

	// getter & setter
	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public static int getPaymentOptionNum() {
		return paymentOptionNum;
	}

	public static void setPaymentOptionNum(int paymentOptionNum) {
		PaymentOption.paymentOptionNum = paymentOptionNum;
	}

}