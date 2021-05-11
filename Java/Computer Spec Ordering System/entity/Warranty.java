package entity;

import java.util.*;

import util.Utility;

public class Warranty {
	// data declaration
	private String warrantyID;
	private String warrantyYearLength;
	private String[] warrantyCoverage;
	private static List<Warranty> warrantyList = new ArrayList<Warranty>(
			Arrays.asList(new Warranty("", new String[] {}), new Warranty("4 mths", new String[] { "Broken" }),
					new Warranty("6 mths", new String[] { "Broken" }), new Warranty("1 yr", new String[] { "Broken" }),
					new Warranty("1 yr 6 mths", new String[] { "Broken", "Water Damage" }),
					new Warranty("2 yr", new String[] { "Broken", "Water Damage" }),
					new Warranty("2 yr 6 mths", new String[] { "Broken", "Water Damage", "Fire" })));
	private static int warrantyIDCount = 1;
	private static int listingLimit = 5;

	// constructor
	public Warranty(String warrantyYearLength, String[] warrantyCoverage) {
		warrantyID = "WR" + warrantyIDCount;
		this.warrantyYearLength = warrantyYearLength;
		this.warrantyCoverage = new String[warrantyCoverage.length];
		System.arraycopy(warrantyCoverage, 0, this.warrantyCoverage, 0, warrantyCoverage.length);
		warrantyIDCount++;
	}

	public Warranty(Warranty warranty) {
		warrantyID = "WR" + warrantyIDCount;
		this.warrantyYearLength = new String(warranty.warrantyYearLength);
		this.warrantyCoverage = new String[warranty.warrantyCoverage.length];
		System.arraycopy(warranty.warrantyCoverage, 0, this.warrantyCoverage, 0, warranty.warrantyCoverage.length);
		warrantyIDCount++;
	}

	// getter and setter
	public String getWarrantyID() {
		return warrantyID;
	}

	public void setWarrantyID(String warrantyID) {
		this.warrantyID = warrantyID;
	}

	public String getWarrantyYearLength() {
		return warrantyYearLength;
	}

	public void setWarrantyYearLength(String warrantyYearLength) {
		this.warrantyYearLength = warrantyYearLength;
	}

	public static List<Warranty> getWarrantyList() {
		return new ArrayList<Warranty>(warrantyList);
	}

	public static void setWarrantyList(List<Warranty> warrantyList) {
		Warranty.warrantyList = new ArrayList<Warranty>(warrantyList);
	}

	public static int getListingLimit() {
		return listingLimit;
	}

	public static void setListingLimit(int listingLimit) {
		Warranty.listingLimit = listingLimit;
	}

	public String[] getWarrantyCoverage() {
		String[] copy = new String[warrantyCoverage.length];
		System.arraycopy(warrantyCoverage, 0, copy, 0, copy.length);
		return copy;
	}

	public void setWarrantyCoverage(String[] warrantyCoverage) {
		this.warrantyCoverage = new String[warrantyCoverage.length];
		System.arraycopy(warrantyCoverage, 0, this.warrantyCoverage, 0, warrantyCoverage.length);
	}

	public static int getWarrantyIDCount() {
		return warrantyIDCount;
	}

	public static void setWarrantyIDCount(int warrantyIDCount) {
		Warranty.warrantyIDCount = warrantyIDCount;
	}
        
        public static Warranty getWarranty(String warrantyID) {
		for (Warranty w : warrantyList)
			if (w.getWarrantyID().equals(warrantyID))
				return w;
		return null;
	}
        
        @Override
	public String toString() {
		return String.format("%-14s", warrantyID);
	}

	public String toString(int page) {
		// Combine string[] into one string for toString() output
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < warrantyCoverage.length; i++) {
			sb.append(warrantyCoverage[i]);
			if (i != warrantyCoverage.length - 1)
				sb.append(", ");
		}
		return String.format("%-15s %-14s %-10s", warrantyID, warrantyYearLength, sb);
	}

	public static String heading() { // print only warranty ID
		return String.format("%2s %-14s", " ", "Warranty ID");
	}

	public static String heading(int page) {
		return String.format("%-20s %6s %d %s %.0f %s", "Warranty Information", "\nPage ", page, "/",
				Math.ceil((double) warrantyList.size() / listingLimit), "\n")
				+ String.format("%-14s %-12s %11s\n", "Warranty ID", "Duration", "Coverage") + Utility.repeat(55, "=")
				+ "\n";
	}

	public static List<Warranty> getResult(int page) {
		List<Warranty> result = new ArrayList<Warranty>();
		// if next page is empty, start from previous page page
		int startIndex = (page - 1) * listingLimit >= warrantyList.size() ? (page - 2) * listingLimit
				: (page - 1) * listingLimit;
		// if endIndex is more than power supply list, the power supply last index will
		// be the end index
		int endIndex = startIndex + listingLimit - 1 > warrantyList.size() - 1 ? warrantyList.size() - 1
				: startIndex + listingLimit - 1;

		for (; startIndex <= endIndex; startIndex++) {
			result.add(warrantyList.get(startIndex));
		}
		return result;
	}
}
