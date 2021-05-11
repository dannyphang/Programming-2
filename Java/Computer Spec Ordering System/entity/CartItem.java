package entity;

import java.text.SimpleDateFormat;
import java.util.*;

import template.Product;

public class CartItem {
	// Declaration
	private Product product;
	private int quantity;
	private Date addDate;

	// Constructor
	public CartItem(Product product, int quantity) {
		if (product instanceof Processor)
			this.product = new Processor((Processor) product);
		else if (product instanceof GraphicCard)
			this.product = new GraphicCard((GraphicCard) product);
		else if (product instanceof RAM)
			this.product = new RAM((RAM) product);
		else if (product instanceof PowerSupply)
			this.product = new PowerSupply((PowerSupply) product);
		else if (product instanceof Storage)
			this.product = new Storage((Storage) product);

		this.product.setProductID(new String(product.getProductID()));
		this.quantity = quantity;
		this.addDate = new Date();
	}

	// For inserting dummy data
	public CartItem(Product product, int quantity, Date addDate) {
		if (product instanceof Processor)
			this.product = new Processor((Processor) product);
		else if (product instanceof GraphicCard)
			this.product = new GraphicCard((GraphicCard) product);
		else if (product instanceof RAM)
			this.product = new RAM((RAM) product);
		else if (product instanceof PowerSupply)
			this.product = new PowerSupply((PowerSupply) product);
		else if (product instanceof Storage)
			this.product = new Storage((Storage) product);

		this.product.setProductID(new String(product.getProductID()));
		this.quantity = quantity;
		this.addDate = addDate;
	}

	public CartItem(CartItem ci) {
		if (ci.getProduct() instanceof Processor)
			this.product = new Processor((Processor) ci.getProduct());
		else if (ci.getProduct() instanceof GraphicCard)
			this.product = new GraphicCard((GraphicCard) ci.getProduct());
		else if (ci.getProduct() instanceof RAM)
			this.product = new RAM((RAM) ci.getProduct());
		else if (ci.getProduct() instanceof PowerSupply)
			this.product = new PowerSupply((PowerSupply) ci.getProduct());
		else if (ci.getProduct() instanceof Storage)
			this.product = new Storage((Storage) ci.getProduct());

		this.product.setProductID(new String(ci.getProduct().getProductID()));
		this.quantity = ci.quantity;
		this.addDate = new Date(ci.addDate.getTime());
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

	public double getSubtotal() {
		return product != null ? product.getPrice() * quantity : 0;
	}

	// toString without subtotal
	public String toString1() throws NullPointerException {
		try {
			return product.toString2()
					+ String.format("%18s %10d\n", new SimpleDateFormat("dd/MM/yyyy").format(addDate), quantity);
		} catch (NullPointerException ex) {
			throw ex;
		}
	}

	// toString with subtotal
	public String toString2() throws NullPointerException {
		try {
			return product.toString2() + String.format("%18s %10d %12.2f\n",
					new SimpleDateFormat("dd/MM/yyyy").format(addDate), quantity, getSubtotal());
		} catch (NullPointerException ex) {
			throw ex;
		}
	}
}