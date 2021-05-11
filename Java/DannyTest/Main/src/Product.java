//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public abstract class Product {

	//data declaration
    private String productID;
    private String productBrand, productName;
    private double price;
    private int stockAmount;
    private Warranty warranty;
    private static final int listingLimit = 5; //Number of records displayed on screen
    
  //constructor
    public Product() {
    }

    //Constructor without warranty variable
	public Product(String productID, String productBrand, String productName, double price, int stockAmount) {
		super();
		this.productID = productID;
		this.productBrand = productBrand;
		this.productName = productName;
		this.price = price;
		this.stockAmount = stockAmount;
	}

	public Product(String productID, String productBrand, String productName, double price, int stockAmount,
			Warranty warranty) {
		this.productID = productID;
		this.productBrand = productBrand;
		this.productName = productName;
		this.price = price;
		this.stockAmount = stockAmount;
		this.warranty = warranty;
	}

	// getter and setter
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public Warranty getWarranty() {
		return warranty;
	}

	public void setWarranty(Warranty warranty) {
		this.warranty = warranty;
	}

	public static int getListingLimit() {
		return listingLimit;
	}

	public static List<Product> displayProduct(int page) {
		return null;
	}

	private static void displayBrowseProductMenu(){
		System.out.println(" =============================");
		System.out.println("|| 1. Graphic card           ||");
		System.out.println("|| 2. Power Supply           ||");
		System.out.println("|| 3. Processor              ||");
		System.out.println("|| 4. Ram                    ||");
		System.out.println("|| 5. Storage                ||");
		System.out.println("||                           ||");
		System.out.println("|| B. Back to previous page  ||");
		System.out.println(" =============================");
	}
}