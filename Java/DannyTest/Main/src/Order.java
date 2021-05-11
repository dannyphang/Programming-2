import java.util.*;

public class Order {
	// Declaration
	private String orderID;
	private Date checkoutDate;
	//private Discount discount;
    //private Payment payment;
	private Cart cart;

	// Constructor
	public Order() {
		// initiate order
	}

	public Order(String orderID, Date checkoutDate){
		this.orderID = orderID;
		this.checkoutDate = checkoutDate;
	}

	// public Order(String orderID, Payment payment, Date checkoutDate, Discount discount, Cart cart) {
	// 	this.orderID = orderID;
	// 	this.payment = payment;
	// 	Date checkoutDate2 = checkoutDate;
	// 	this.discount = discount;
	// 	this.cart = cart;
	// }

	// Getter and Setter
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	// public Payment getPayment() {
	// 	return payment;
	// }

	// public void setPayment(Payment payment) {
	// 	this.payment = payment;
	// }

	public Date getcCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	// public Discount getDiscount() {
	// 	return discount;
	// }

	// public void setDiscount(Discount discount) {
	// 	this.discount = discount;
	// }

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString(){
		return ("Order ID: " + orderID + "\nCheckout Date: " + checkoutDate);
	}
}