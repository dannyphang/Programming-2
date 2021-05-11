package template;

import java.util.*;

import entity.Warranty;

public abstract class Product {

	// data declaration
	private String productID, productBrand, productName;
	private double price;
	private int stockAmount;
	private Warranty warranty;
	private static final int listingLimit = 5; // Number of records displayed on screen

	// constructor
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

	public static int getListinglimit() {
		return listingLimit;
	}

        public String toString1() {
		return String.format("%-8s %-10s %-35s %10.2f %18d", productID, productBrand, productName, price, stockAmount);
	}

	public String toString2() {
		return String.format("%-8s %-10s %-35s %10.2f", productID, productBrand, productName, price);
	}
        
	public static List<? extends Product> displayProduct(int page, List<? extends Product> pList) {
		if (pList.isEmpty())
			return null;

		List<Product> result = new ArrayList<Product>();
		// if next page is empty, start from previous page page
		int startIndex = (page - 1) * listingLimit >= pList.size() ? (page - 2) * listingLimit
				: (page - 1) * listingLimit < 0 ? 0 : (page - 1) * listingLimit;
		// if endIndex is more than power supply list, the power supply last index will
		// be the end index
		int endIndex = startIndex + listingLimit - 1 > pList.size() - 1 ? pList.size() - 1
				: startIndex + listingLimit - 1;

		for (; startIndex <= endIndex; startIndex++) {
			result.add(pList.get(startIndex));
		}

		return result;
	}

	public static String heading1() {
		return String.format("%-12s %-10s %-35s %-18s %s", "Product ID", "Brand", "Product Name", "Price (RM)",
				"Stock Left");
	}

	public static String heading2() {
		return String.format("%-12s %-10s %-35s %-18s", "Product ID", "Brand", "Product Name", "Price (RM)");
	}

}
