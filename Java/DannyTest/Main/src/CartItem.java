import java.util.*;

public class CartItem {
	// Declaration
	private Product product;
	private int quantity;
	private Date addDate;

	// Constructor
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.addDate = new Date();
	}
	
	//For inserting dummy data
	public CartItem(Product product, int quantity, Date addDate) {
		this.product = product;
		this.quantity = quantity;
		this.addDate = addDate;
	}

	// Getter and Setter
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	@Override
	public String toString() {

		return String.format("%-12s %-10s %-25s", product.getProductID(), product.getProductBrand(),
				product.getProductName()) + String.format(" %15s %18s", quantity, addDate)
				+ String.format(" %5.2f", product.getPrice());
	}

	public double getSubtotal() {
		return product.getPrice() * quantity;
	}
}