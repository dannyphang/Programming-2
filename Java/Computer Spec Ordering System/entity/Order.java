package entity;

import java.util.*;

public class Order implements Comparable<Order> {
	// Declaration
	private String orderID;
	private Date checkoutDate;
	private double grandTotal;
	private Payment payment;
	private Discount discount;
	private Cart cart;
	private static int orderNum = 1;

	// Constructor
	public Order(double grandTotal, Payment payment, Discount discount, Cart cart) {
		orderID = "OR-" + orderNum;
		checkoutDate = new Date();
		this.grandTotal = grandTotal;
		this.payment = payment;
		this.discount = discount;
		this.cart = new Cart(cart.getCartItemList());

		orderNum++;
	}

	public Order(double grandTotal, Payment payment, Discount discount, Cart cart, Date checkoutDate) {
		orderID = "OR-" + orderNum;
		this.checkoutDate = checkoutDate;
		this.grandTotal = grandTotal;
		this.payment = payment;
		this.discount = discount;
		this.cart = new Cart(cart.getCartItemList());

		orderNum++;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public static int getOrderNum() {
		return orderNum;
	}

	public static void setOrderNum(int orderNum) {
		Order.orderNum = orderNum;
	}

	@Override
	public int compareTo(Order order) {
		return this.checkoutDate.compareTo(order.getCheckoutDate());
	}
}