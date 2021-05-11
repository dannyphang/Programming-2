package entity;

import java.util.*;

import template.Product;
import util.Utility;

public class GraphicCard extends Product {
	private int benchmark;
	private int videoRam;
	private static int gcIDCount = 1;
	private static List<GraphicCard> gcList = new ArrayList<GraphicCard>(Arrays.asList(
			new GraphicCard("NVIDIA", "Titan RTX", 9999.00, 100, Warranty.getWarranty("WR6"), 14947, 0),
			new GraphicCard("NVIDIA", "GeForce RTX 2080 Ti", 4799.00, 100, Warranty.getWarranty("WR6"), 14593, 0),
			new GraphicCard("NVIDIA", "GeForce RTX 2080 SUPER", 3199.00, 100, Warranty.getWarranty("WR5"), 11700, 0),
			new GraphicCard("NVIDIA", "GeForce GTX 1080 Ti", 2799.00, 100, Warranty.getWarranty("WR1"), 9968, 0),
			new GraphicCard("NVIDIA", "GeForce RTX 2060 SUPER", 1699.00, 100, Warranty.getWarranty("WR1"), 8908, 0),
			new GraphicCard("AMD", "Radeon RX 5700 XT", 2599.00, 100, Warranty.getWarranty("WR1"), 9182, 0),
			new GraphicCard("AMD", "Radeon RX Vega 64", 2199.00, 100, Warranty.getWarranty("WR1"), 7325, 0),
			new GraphicCard("AMD", "Radeon RX 570", 1699.00, 100, Warranty.getWarranty("WR5"), 3870, 0)));

	public GraphicCard(String productBrand, String productName, double price, int stockAmount, Warranty warranty,
			int benchmark, int videoRam) {
		super("GC" + gcIDCount, productBrand, productName, price, stockAmount, warranty);
		this.benchmark = benchmark;
		this.videoRam = videoRam;
		gcIDCount++;
	}

	public GraphicCard(GraphicCard gc) {
		super("GC" + gcIDCount, gc.getProductBrand(), gc.getProductName(), gc.getPrice(), gc.getStockAmount(),
				new Warranty(gc.getWarranty()));
		this.benchmark = gc.benchmark;
		this.videoRam = gc.videoRam;
		gcIDCount++;
	}

	public int getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(int benchmark) {
		this.benchmark = benchmark;
	}

	public int getVideoRam() {
		return videoRam;
	}

	public void setVideoRam(int videoRam) {
		this.videoRam = videoRam;
	}

	public static int getGcIDCount() {
		return gcIDCount;
	}

	public static void setGcIDCount(int gcIDCount) {
		GraphicCard.gcIDCount = gcIDCount;
	}

	public static List<GraphicCard> getGcList() {
		return new ArrayList<GraphicCard>(gcList);
	}

	public static void setGcList(List<GraphicCard> gcList) {
		GraphicCard.gcList = new ArrayList<GraphicCard>(gcList);
	}

	public static GraphicCard getProduct(String id) {
		for (GraphicCard gc : gcList)
			if (gc.getProductID().equals(id))
				return gc;

		return null;
	}

	public static String heading(int page) {
		return String.format("%-20s %6s %d %s %.0f %s", "Graphic Cards", "\nPage ", page, "/",
				Math.ceil((double) gcList.size() / getListinglimit()), "\n") + Product.heading1()
				+ String.format("%15s %15s\n", "Benchmark", "Video RAM") + Utility.repeat(120, "=");
	}

	@Override
	public String toString() {
		return super.toString1() + String.format("%15d %15d", benchmark, videoRam);
	}
}
