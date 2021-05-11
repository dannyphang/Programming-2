package template;

public abstract class PaymentOption {
	private String paymentID;
	private static int paymentOptionNum=1;

	// constructor
	public PaymentOption() {
		this.paymentID = ("PO" + paymentOptionNum);
		paymentOptionNum++;
	}

	// getter & setter
	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public static int getPaymentOptionNum() {
		return paymentOptionNum;
	}

	public static void setPaymentOptionNum(int paymentOptionNum) {
		PaymentOption.paymentOptionNum = paymentOptionNum;
	}
	
	public static String heading() {
		return String.format("%-12s", "Payment ID");
	}

	@Override
	public String toString() {
		return String.format("%-8s", paymentID);
	}
}