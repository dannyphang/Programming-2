import java.util.*;

public class Customer extends User {    

	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
    
    public Customer(String username, String password) {
        super(username, password);
    }
    
    public static ArrayList<Customer> getCustomerList() {
        return new ArrayList<Customer>(customerList);
    }

    public static void setCustomerList(ArrayList<Customer> customerList) {
        Customer.customerList = customerList;
    }
    
    public static Customer getCustomer(int index) {
		return customerList.get(index);
    }
    
    public static void registerCustomer(Customer customer) {
        customerList.add(customer);
    }

    public static boolean checkUser(String username){
        
        for (Customer customer : customerList)
			if (customer.getUsername().equals(username))
				return true;

        return false;
    }
}
