package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Utility;

public class Discount {
	private double totalCashRebate, totalPercentage;
	private static double memberDiscount = 5;
	private static double tradeDiscount[][] = { { 200, 10, 0 }, { 500, 20, 0 }, { 1000, 100, 5 }, { 2500, 500, 10 } };
	// Order is important(ascending)
	// {amount to exceed, cash Rebate, Discount Percentage}

	public Discount() {
		totalCashRebate = 0;
		totalPercentage = 0;
	}

	public Discount(double totalCashRebate, double totalPercentage) {
		this.totalCashRebate = totalCashRebate;
		this.totalPercentage = totalPercentage;
	}

	public double getTotalCashRebate() {
		return totalCashRebate;
	}

	public void setTotalCashRebate(double totalCashRebate) {
		this.totalCashRebate = totalCashRebate;
	}

	public double getTotalPercentage() {
		return totalPercentage;
	}

	public void setTotalPercentage(double totalPercentage) {
		this.totalPercentage = totalPercentage;
	}

	public static double getMemberDiscount() {
		return memberDiscount;
	}

	public static void setMemberDiscount(double memberDiscount) {
		Discount.memberDiscount = memberDiscount;
	}
        
	public static double[][] getTradeDiscount() {
		double[][] copy = new double[tradeDiscount.length][tradeDiscount[0].length];
		System.arraycopy(Discount.tradeDiscount, 0, copy, 0, copy.length);
		return copy;
	}

	public static void setTradeDiscount(double[][] tradeDiscount) {
		Discount.tradeDiscount = new double[tradeDiscount.length][tradeDiscount[0].length];
		System.arraycopy(tradeDiscount, 0, Discount.tradeDiscount, 0, tradeDiscount.length);
	}
        
        
	// Methods
	public void applyMemberDiscount(boolean isMember) {
		if (isMember)
			totalPercentage += memberDiscount;
	}

	public void calculateTradeDiscount(double amount) {
		for (int i = tradeDiscount.length - 1; i >= 0; i--) {
			if (amount >= tradeDiscount[i][0]) {
				totalCashRebate = tradeDiscount[i][1];
				totalPercentage = tradeDiscount[i][2];
				break;
			}
		}
	}

	public static void displayDiscountInfo() {
		List<String> result = new ArrayList<String>(Arrays.asList(heading().split("\n")));
		for (int i = 0; i < tradeDiscount.length; i++) {
			result.add(String.format("%17.2f %20.2f %25.2f", tradeDiscount[i][0], tradeDiscount[i][1],tradeDiscount[i][2]));
		}

		Utility.formatMenu(result.toArray(new String[0]));
	}

	public static String heading() {
		return String.format("%-20s\n\n", "Discount Information") + String.format("%19s %18s %25s\n",
				"Spent Amount (RM)", "Cash Rebate (RM)", "Discount percentage (%)") + Utility.repeat(64, "=") + "\n";
	}
}