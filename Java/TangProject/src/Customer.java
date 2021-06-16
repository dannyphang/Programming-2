import java.util.*;

public class Customer extends User{
    private String customerName;
    private String address;
    private String phone;
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();
    
    
    public Customer(String userID, String password, String loginStatus, String customerName, String address, String phone) {
        super(userID, password, loginStatus);
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(ArrayList<Customer> customerList) {
        Customer.customerList = customerList;
    }

    public static void register(Customer customer) {
        customerList.add(customer);
    }
    
    public static int login(String userID, String password){
        for(Customer cus: customerList){
            if(cus.getUserID().equals(userID) && cus.getPassword().equals(password)){
                return customerList.indexOf(cus);
            }
        }
        return -1;
    }
}
