import java.util.*;

public class Customer extends User {
	private String address;
	private String email;
	private List<PaymentOption> paymentOption;
	private List<Order> orderList;
	private Cart cart;
	private static List<Customer> customerList = new ArrayList<Customer>();

	// private static List<Customer> customerList;

	// constructor
	public Customer(String username, String name, String address, String email) {
		super(username, name, new Date());
		this.address = address;
		this.email = email;
		this.orderList = new ArrayList<Order>(Arrays.asList(new Order("123456", new Date())));
		this.paymentOption = new ArrayList<PaymentOption>();
		this.paymentOption.add(new Cash());
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
		return paymentOption;
	}

	public void setPaymentOption(List<PaymentOption> paymentOption) {
		this.paymentOption = paymentOption;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
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

	// public void updateProfile(String address, String email) {
	// 	setAddress(address);
	// 	setEmail(email);
	// }

	//this method do what eh???
	public void checkout() {

	}

	public void addPaymentOption() {
		paymentOption.add(new Card());
	}

	public static Customer getCustomer(int index) {
		return customerList.get(index);
	}

	public static boolean validateEmail(String email) {
		return email.matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
	}

	@Override
	public String toString() {
		return "Customer\n\nUsername: " + getUsername() + "\nName: " + getName() + "\nAddress: " + getAddress()
				+ "\nEmail: " + getEmail() + "\nRegistered Date: " + getRegisterDate();
	}

	public static boolean checkUsername(String username) {
		for (Customer c : customerList) {
			if (c.getUsername().equals(username))
				return false;
		}
		return true;
	}

	public static User[] displayUser(int page) {
		User[] result = new User[getListinglimit()];
		// if next page is empty, start from previous page page
		int startIndex = (page - 1) * getListinglimit() >= customerList.size() ? (page - 2) * getListinglimit()
				: (page - 1) * getListinglimit();
		System.out.println("test 1" + startIndex);
		// if endIndex is more than Customer list, the Custoemr last index will
		// be the customerList size()-1
		int endIndex = startIndex + getListinglimit() - 1 > customerList.size() - 1 ? customerList.size() - 1
				: startIndex + getListinglimit() - 1;

		for (; startIndex <= endIndex; startIndex++) {
			result[startIndex] = customerList.get(startIndex);
		}

		return result;
	}

	public static void register(Customer customer) {
		customerList.add(customer);
	}
	
	public static int login(String username) {
		for(Customer customer:customerList)
			if(customer.getUsername().equals(username))
				return customerList.indexOf(customer);
		
		return -1;
	}
	
}