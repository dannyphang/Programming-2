package entity;

import java.util.*;

import template.Product;
import util.Utility;

public class Storage extends Product {
	private String type;
	private int capacity;
	private String writingSpeed;
	private String readingSpeed;
	private static int storageIDCount = 1;
	private static List<Storage> storageList = new ArrayList<Storage>(Arrays.asList(
			new Storage("SanDisk", "SSD PLUS", 527.00, 100, Warranty.getWarranty("WR4"), "SSD", 1000, "375MB/s",
					"375MB/s"),
			new Storage("SanDisk", "SSD PLUS", 256.00, 100, Warranty.getWarranty("WR1"), "SSD", 480, "375MB/s",
					"375MB/s"),
			new Storage("SanDisk", "SSD PLUS", 143.00, 100, Warranty.getWarranty("WR1"), "SSD", 120, "375MB/s",
					"375MB/s"),
			new Storage("Samsung", "860 Evo", 788.00, 100, Warranty.getWarranty("WR1"), "SSD", 1000, "375MB/s",
					"375MB/s"),
			new Storage("Samsung", "860 Evo", 375.00, 100, Warranty.getWarranty("WR1"), "SSD", 500, "375MB/s",
					"375MB/s"),
			new Storage("Western", "Caviar Blue 3.5\" Internal", 488.00, 100, Warranty.getWarranty("WR1"), "HDD", 3000,
					"120MB/s", "120MB/s"),
			new Storage("Western", "Caviar Red 3.5\" Internal", 244.00, 100, Warranty.getWarranty("WR1"), "HDD", 2000,
					"120MB/s", "120MB/s"),
			new Storage("Western", "Caviar White 3.5\" Internal", 177.00, 100, Warranty.getWarranty("WR1"), "HDD", 1000,
					"120MB/s", "120MB/s"),
			new Storage("ADATA", "Portable 2.5\" External", 450.00, 100, Warranty.getWarranty("WR6"), "HDD", 3000,
					"120MB/s", "120MB/s"),
			new Storage("ADATA", "Portable 2.5\" External", 255.00, 100, Warranty.getWarranty("WR1"), "HDD", 2000,
					"120MB/s", "120MB/s")));

	public Storage(String productBrand, String productName, double price, int stockAmount, Warranty warranty,
			String type, int capacity, String writingSpeed, String readingSpeed) {
		super("ST" + storageIDCount, productBrand, productName, price, stockAmount, warranty);
		this.type = new String(type);
		this.capacity = capacity;
		this.writingSpeed = new String(writingSpeed);
		this.readingSpeed = new String(readingSpeed);
		storageIDCount++;
	}

	public Storage(Storage s) {
		super("ST" + storageIDCount, s.getProductBrand(), s.getProductName(), s.getPrice(), s.getStockAmount(),
				new Warranty(s.getWarranty()));
		this.type = s.type;
		this.capacity = s.capacity;
		this.writingSpeed = s.writingSpeed;
		this.readingSpeed = s.readingSpeed;
		storageIDCount++;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getWritingSpeed() {
		return writingSpeed;
	}

	public void setWritingSpeed(String writingSpeed) {
		this.writingSpeed = writingSpeed;
	}

	public String getReadingSpeed() {
		return readingSpeed;
	}

	public void setReadingSpeed(String readingSpeed) {
		this.readingSpeed = readingSpeed;
	}

	public static int getStorageIDCount() {
		return storageIDCount;
	}

	public static void setStorageIDCount(int storageIDCount) {
		Storage.storageIDCount = storageIDCount;
	}

	public static List<Storage> getStorageList() {
		return new ArrayList<Storage>(storageList);
	}

	public static void setStorageList(List<Storage> storageList) {
		Storage.storageList = new ArrayList<Storage>(storageList);
	}

	public static Storage getProduct(String id) {
		for (Storage s : storageList)
			if (s.getProductID().equals(id))
				return s;

		return null;
	}

	public static String heading(int page) {
		return String.format("%-20s %6s %d %s %.0f %s", "Storage", "\nPage ", page, "/",
				Math.ceil((double) storageList.size() / getListinglimit()), "\n") + Product.heading1()
				+ String.format("%15s %15s %15s %15s\n", "Type", "Capacity", "Read Speed", "Write Speed")
				+ Utility.repeat(152, "=");
	}

	@Override
	public String toString() {
		return super.toString1() + String.format("%15s %15d %15s %15s", type, capacity, readingSpeed, writingSpeed);
	}
}
