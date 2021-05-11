package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import template.Product;
import util.Utility;

public class PowerSupply extends Product {
	private int capacity;
	private String interfaceType;
	private static int psIDCount = 1;
	private static List<PowerSupply> psList = new ArrayList<PowerSupply>(Arrays.asList(
			new PowerSupply("Corsair", "AX860", 1180.00, 100, Warranty.getWarranty("WR5"), 860, "Interface 1"),
			new PowerSupply("Corsair", "CX550M", 1358, 100, Warranty.getWarranty("WR4"), 550, ""),
			new PowerSupply("EVGA", "SuperNova 1600 T2", 1876, 100, Warranty.getWarranty("WR1"), 1600, ""),
			new PowerSupply("Seasonic", "FOCUS 750", 1826, 100, Warranty.getWarranty("WR1"), 750, "Interface 4"),
			new PowerSupply("Litepower", "450W", 1138, 100, Warranty.getWarranty("WR1"), 450, ""),
			new PowerSupply("XXXX", "450W", 1128, 40, Warranty.getWarranty("WR2"), 450, ""),
			new PowerSupply("YYYY", "550W", 2228, 7, Warranty.getWarranty("WR6"), 450, "")));

	public PowerSupply(String productBrand, String productName, double price, int stockAmount, Warranty warranty,
			int capacity, String interfaceType) {
		super("PS" + psIDCount, productBrand, productName, price, stockAmount, warranty);
		this.capacity = capacity;
		this.interfaceType = interfaceType;
		psIDCount++;
	}

	public PowerSupply(PowerSupply ps) {
		super("PS" + psIDCount, ps.getProductBrand(), ps.getProductName(), ps.getPrice(), ps.getStockAmount(),
				new Warranty(ps.getWarranty()));
		this.capacity = ps.capacity;
		this.interfaceType = new String(ps.interfaceType);
		psIDCount++;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public static int getPsIDCount() {
		return psIDCount;
	}

	public static void setPsIDCount(int psIDCount) {
		PowerSupply.psIDCount = psIDCount;
	}

	public static List<PowerSupply> getPsList() {
		return new ArrayList<PowerSupply>(psList);
	}

	public static void setPsList(List<PowerSupply> psList) {
		PowerSupply.psList = new ArrayList<PowerSupply>(psList);
	}

	public static PowerSupply getProduct(String id) {
		for (PowerSupply ps : psList)
			if (ps.getProductID().equals(id))
				return ps;

		return null;
	}

	public static String heading(int page) {
		return String.format("%-20s %6s %d %s %.0f %s", "PowerSupply", "\nPage ", page, "/",
				Math.ceil((double) psList.size() / getListinglimit()), "\n") + Product.heading1()
				+ String.format("%15s %18s\n", "Capacity", "Interface Type") + Utility.repeat(123, "=");
	}

	@Override
	public String toString() {
		return super.toString1() + String.format("%15d %18s", capacity, interfaceType);
	}
}
