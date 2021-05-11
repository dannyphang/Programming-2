package util;

import java.text.SimpleDateFormat;
import java.util.*;

import entity.Cart;
import entity.CartItem;
import entity.CartItemHistory;
import entity.Customer;
import entity.Order;
import template.Report;

public class CartItemHistoryReport extends Report {
	private static List<String> report = new ArrayList<String>(Arrays.asList());
	private List<CartItemHistory> ciHistory = new ArrayList<CartItemHistory>();

	public CartItemHistoryReport(Customer c) {
		customer = c;
//		for (CartItem ci: customer.getCart().getCartItemList())
//			cartItemList.add(ci);

//		for (Order o: customer.getOrderList())
//			for (CartItem ci: o.getCart().getCartItemList())
//				cartItemList.add(ci);

		for (CartItemHistory h : c.getCart().getCiHistory())
			ciHistory.add(h);
	}

	@Override
	public void printReport() {
		// TODO Auto-generated method stub
		compareDate(null);
		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout("Cart Item Overall History Report", true, reportArr);
	}

	@Override
	public void printByWeek() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		Date dateAfter = cal.getTime();

		compareDate(dateAfter);

		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout("Cart Item Week History Report", true, reportArr);
	}

	@Override
	public void printByMonth() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		Date dateAfter = cal.getTime();

		compareDate(dateAfter);

		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout("Cart Item Month History Report", true, reportArr);
	}

	@Override
	public void printByYear() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1);
		Date dateAfter = cal.getTime();

		compareDate(dateAfter);

		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout("Cart Item Year History Report", true, reportArr);
	}

	public static List<String> getReport() {
		return report;
	}

	public static void setReport(List<String> report) {
		CartItemHistoryReport.report = report;
	}

	private void compareDate(Object o) {
		report.clear();
		report.add(String.format("%-12s %-12s %-5s %-12s", "Date", "Product ID", "Qty", "Action"));
		report.add(Utility.repeat(42, "="));

		for (CartItemHistory h : ciHistory) {
			if (o != null)
				if (h.getCi().getAddDate().compareTo((Date) o) < 0)
					continue;

			Date cartItemDate = h.getCi().getAddDate();
			report.add(String.format("%-12s %-12s %-5d %-12s", new SimpleDateFormat("dd MMM yyyy").format(cartItemDate),
					h.getCi().getProduct().getProductID(), h.getCi().getQuantity(), h.getAction()));
		}
	}

};