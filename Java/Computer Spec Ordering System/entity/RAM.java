package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import template.Product;
import util.Utility;

public class RAM extends Product {
	private int capacity;
	private double speed;
	private String technology;
	private static int ramIDCount = 1;
	private static List<RAM> ramList = new ArrayList<RAM>(Arrays.asList(
			new RAM("Corsair", "Vengeance LED", 386.00, 100, Warranty.getWarranty("WR1"), 16, 3200, "Tech 1"),
			new RAM("HyperX", "Fury RGB", 424.00, 100, Warranty.getWarranty("WR6"), 16, 3466, ""),
			new RAM("HyperX", "Fury RGB", 315.00, 100, Warranty.getWarranty("WR1"), 16, 3200, "Tech 3"),
			new RAM("HyperX", "Impact", 388.00, 100, Warranty.getWarranty("WR1"), 16, 3200, ""),
			new RAM("HyperX", "Impact", 281.00, 100, Warranty.getWarranty("WR1"), 16, 2666, "")));

	public RAM(String productBrand, String productName, double price, int stockAmount, Warranty warranty, int capacity,
			double speed, String technology) {
		super("RA" + ramIDCount, productBrand, productName, price, stockAmount, warranty);
		this.capacity = capacity;
		this.speed = speed;
		this.technology = technology;
		ramIDCount++;
	}

	public RAM(RAM ram) {
		super("RA" + ramIDCount, ram.getProductBrand(), ram.getProductName(), ram.getPrice(), ram.getStockAmount(),
				new Warranty(ram.getWarranty()));
		this.capacity = ram.capacity;
		this.speed = ram.speed;
		this.technology = new String(ram.technology);
		ramIDCount++;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public static int getRamIDCount() {
		return ramIDCount;
	}

	public static void setRamIDCount(int ramIDCount) {
		RAM.ramIDCount = ramIDCount;
	}

	public static List<RAM> getRamList() {
		return new ArrayList<RAM>(ramList);
	}

	public static void setRamList(List<RAM> ramList) {
		RAM.ramList = new ArrayList<RAM>(ramList);
	}

	public static RAM getProduct(String id) {
		for (RAM ram : ramList)
			if (ram.getProductID().equals(id))
				return ram;

		return null;
	}

	public static String heading(int page) {
		return String.format("%-20s %6s %d %s %.0f %s", "RAM", "\nPage ", page, "/",
				Math.ceil((double) ramList.size() / getListinglimit()), "\n") + Product.heading1()
				+ String.format("%15s %15s %15s\n", "Capacity", "Speed", "Technology") + Utility.repeat(136, "=");
	}

	@Override
	public String toString() {
		return super.toString1() + String.format("%15d\t %7.1f %15s", capacity, speed, technology);
	}
}
