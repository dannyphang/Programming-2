package entity;

import template.User;

import java.text.SimpleDateFormat;
import java.util.*;

import template.*;

public class Customer extends User {
	private String address;
	private String email;
	private List<PaymentOption> paymentOption;
	private List<Order> orderList;
	private Cart cart;
	private static List<Customer> customerList = new ArrayList<Customer>();

	// constructor
	public Customer(String username, String name, String address, String email) {
		super(username, name);
		this.address = address;
		this.email = email;
		paymentOption = new ArrayList<PaymentOption>();
		orderList = new ArrayList<Order>();
		cart = new Cart();
		this.paymentOption.add(new Cash("RM"));
	}

	// getter & setter
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PaymentOption> getPaymentOption() {
		return new ArrayList<PaymentOption>(paymentOption);
	}

	public void setPaymentOption(List<PaymentOption> paymentOption) {
		this.paymentOption = new ArrayList<PaymentOption>(paymentOption);
	}

	public List<Order> getOrderList() {
		return new ArrayList<Order>(orderList);
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = new ArrayList<Order>(orderList);
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public static List<Customer> getCustomerList() {
		return new ArrayList<Customer>(customerList);
	}

	public void checkout(double grandTotal, Payment payment, Discount discount) {
		orderList.add(new Order(grandTotal, payment, discount, cart));
		cart.clearCart();
	}

	public void checkout(double grandTotal, Payment payment, Discount discount, Date checkoutDate) {
		orderList.add(new Order(grandTotal, payment, discount, cart, checkoutDate));
		cart.clearCart();
	}

	public void addPaymentOption(PaymentOption paymentOption) {
		if (paymentOption instanceof Cash)
			this.paymentOption.add(paymentOption);
		else if (paymentOption instanceof Card)
			this.paymentOption.add(paymentOption);
	}

	public void removePaymentOption(int index) throws Exception {
		try {
			paymentOption.remove(index);
		} catch (Exception e) {
			throw e;
		}
	}

	public static Customer getCustomer(int index) {
		return customerList.get(index);
	}

	public static void register(Customer customer) {
		customerList.add(customer);
	}

	public static int login(String username) {
		for (Customer customer : customerList)
			if (customer.getUsername().equals(username))
				return customerList.indexOf(customer);

		return -1;
	}

	public PaymentOption getPaymentOption(int index) {
		if (index > paymentOption.size())
			return null;

		return paymentOption.get(index);
	}

	public static boolean checkUsernameExist(String username) {

		for (Customer customer : customerList)
			if (customer.getUsername().equals(username))
				return true;

		return false;
	}

	@Override
	public String toString() {
		return String.format("%17s %-30s\n%17s %-30s\n%17s %-30s\n%17s %-30s\n%17s %-30s\n", "Username:",
				super.getUsername(), "Name:", super.getName(), "Address:", address, "Email:", email, "Registered Date:",
				new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(super.getRegisterDate()));
	}
}