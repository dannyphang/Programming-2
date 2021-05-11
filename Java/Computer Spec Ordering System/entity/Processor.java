/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.*;

import template.Product;
import util.Utility;

public class Processor extends Product {
	// data declaration
	private int benchmark;
	private int cacheSpeed;
	private static int processorIDCount = 1;
	private static List<Processor> processorList = new ArrayList<Processor>(
			Arrays.asList(new Processor("Intel", "i5 8th Gen", 100.0, 265, Warranty.getWarranty("WR5"), 230, 230),
					new Processor("Intel", "i5 9th Gen", 200.0, 235, Warranty.getWarranty("WR5"), 332, 332),
					new Processor("Intel", "i7 8th Gen", 300.0, 125, Warranty.getWarranty("WR5"), 442, 442),
					new Processor("Intel", "i7 9th Gen", 400.0, 465, Warranty.getWarranty("WR5"), 555, 555)));

	// with warranty var
	public Processor(String productBrand, String productName, double price, int stockAmount, Warranty warranty,
			int benchmark, int cacheSpeed) {

		super("PR" + processorIDCount, productBrand, productName, price, stockAmount, warranty);
		this.benchmark = benchmark;
		this.cacheSpeed = cacheSpeed;
		processorIDCount++;

	}

	public Processor(Processor p) {
		super("PR" + processorIDCount, p.getProductBrand(), p.getProductName(), p.getPrice(), p.getStockAmount(),
				new Warranty(p.getWarranty()));
		this.benchmark = p.benchmark;
		this.cacheSpeed = p.cacheSpeed;
		processorIDCount++;
	}

	// getter and setter
	public int getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(int benchmark) {
		this.benchmark = benchmark;
	}

	public int getCacheSpeed() {
		return cacheSpeed;
	}

	public void setCacheSpeed(int cacheSpeed) {
		this.cacheSpeed = cacheSpeed;
	}

	public static int getProcessorIDCount() {
		return processorIDCount;
	}

	public static void setProcessorIDCount(int processorIDCount) {
		Processor.processorIDCount = processorIDCount;
	}

	public static List<Processor> getProcessorList() {
		return new ArrayList<Processor>(processorList);
	}

	public static void setProcessorList(List<Processor> processorList) {
		Processor.processorList = new ArrayList<Processor>(processorList);
	}

	public static Processor getProduct(String id) {
		for (Processor p : processorList)
			if (p.getProductID().equals(id))
				return p;

		return null;
	}

	public static String heading(int page) {
		return String.format("%-20s %6s %d %s %.0f %s", "Processor", "\nPage ", page, "/",
				Math.ceil((double) processorList.size() / getListinglimit()), "\n") + Product.heading1()
				+ String.format("%15s %15s\n", "Benchmark", "Cache Speed") + Utility.repeat(120, "=");
	}

	@Override
	public String toString() {
		return super.toString1() + String.format("%15d %15d", benchmark, cacheSpeed);
	}
}
