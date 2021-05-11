package util;

import entity.CartItem;
import java.text.SimpleDateFormat;
import java.util.*;

import entity.Customer;
import entity.Order;
import template.Report;

public class OrderHistoryReport extends Report {
	// Declaration
	private static List<String> report = new ArrayList<String>(Arrays.asList());

	public OrderHistoryReport(Customer c) {
		customer = c;
	}

	@Override
	public void printReport() {
		System.out.println("Hi " + customer.getName() + ". This is your order history.");
		Date dateAfter;
		List<Order> result = customer.getOrderList();
		Date orderDate;
		String orderID = "";
		double amount = 0.00;
		String paymentID = "";
		String id = "";

		Collections.sort(result);
		dateAfter = !result.isEmpty() ? result.get(0).getCheckoutDate() : null;
		report.clear();
		report.add(String.format(" %-12s %-10s %-15s %-15s %-30s", "Order Date", "Order ID", "Amount(RM)", "Payment ID",
				"Ordered Items"));
		report.add(" " + Utility.repeat(99, "="));
		for (Order o : result) {
			orderDate = o.getCheckoutDate();
			orderID = o.getOrderID();
			amount = o.getGrandTotal();
			paymentID = o.getPayment().getPaymentOption().getPaymentID();
			for (CartItem p : o.getCart().getCartItemList()) {
				id += p.getProduct().getProductID() + " ";
			}
			report.add(String.format(" %-12s %-10s %-15.2f %-15s %-30s",
					new SimpleDateFormat("dd/MM/yyyy").format(orderDate), orderID, amount, paymentID, id));
		}
		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout(
				" Overall Order History Report  "
						+ (dateAfter != null ? new SimpleDateFormat("dd/MM/yyyy").format(dateAfter) : ""),
				true, reportArr);
	}

	@Override
	public void printByWeek() {
		System.out.println("Hi " + customer.getName() + ". This is your order history.");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		Date dateAfter = cal.getTime();
		List<Order> result = customer.getOrderList();
		Date orderDate;
		String orderID = "";
		double amount = 0.00;
		String paymentID = "";
		String id = "";

		Collections.sort(result);
		dateAfter = !result.isEmpty() ? result.get(0).getCheckoutDate() : null;
		report.clear();
		report.add(String.format(" %-12s %-10s %-15s %-15s %-30s", "Order Date", "Order ID", "Amount(RM)", "Payment ID",
				"Ordered Items"));
		report.add(" " + Utility.repeat(99, "="));
		for (Order o : result) {
			orderDate = o.getCheckoutDate();
			orderID = o.getOrderID();
			amount = o.getGrandTotal();
			paymentID = o.getPayment().getPaymentOption().getPaymentID();
			;
			for (CartItem p : o.getCart().getCartItemList()) {
				id += p.getProduct().getProductID() + " ";
			}

			report.add(String.format(" %-12s %-10s %-15.2f %-15s %-30s",
					new SimpleDateFormat("dd/MM/yyyy").format(orderDate), orderID, amount, paymentID, id));
		}
		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout("Weekly Order History Report", true, reportArr);
	}

	@Override
	public void printByMonth() {
		System.out.println("Hi " + customer.getName() + ". This is your order history.");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		Date dateAfter = cal.getTime();
		List<Order> result = customer.getOrderList();
		Date orderDate;
		String orderID = "";
		double amount = 0.00;
		String paymentID = "";
		String id = "";

		Collections.sort(result);
		dateAfter = !result.isEmpty() ? result.get(0).getCheckoutDate() : null;
		report.clear();
		report.add(String.format(" %-12s %-10s %-15s %-15s %-30s", "Order Date", "Order ID", "Amount(RM)", "Payment ID",
				"Ordered Items"));
		report.add(" " + Utility.repeat(99, "="));
		for (Order o : result) {
			orderDate = o.getCheckoutDate();
			orderID = o.getOrderID();
			amount = o.getGrandTotal();
			paymentID = o.getPayment().getPaymentOption().getPaymentID();
			;
			for (CartItem p : o.getCart().getCartItemList()) {
				id += p.getProduct().getProductID() + " ";
			}

			report.add(String.format(" %-12s %-10s %-15.2f %-15s %-30s",
					new SimpleDateFormat("dd/MM/yyyy").format(orderDate), orderID, amount, paymentID, id));
		}
		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout("Monthly Order History Report", true, reportArr);
	}

	@Override
	public void printByYear() {
		System.out.println("Hi " + customer.getName() + ". This is your order history.");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1);
		Date dateAfter = cal.getTime();
		List<Order> result = customer.getOrderList();
		Date orderDate;
		String orderID = "";
		double amount = 0.00;
		String paymentID = "";
		String id = "";

		Collections.sort(result);
		dateAfter = !result.isEmpty() ? result.get(0).getCheckoutDate() : null;
		report.clear();
		report.add(String.format(" %-12s %-10s %-15s %-15s %-30s", "Order Date", "Order ID", "Amount(RM)", "Payment ID",
				"Ordered Items"));
		report.add(" " + Utility.repeat(99, "="));
		for (Order o : result) {
			orderDate = o.getCheckoutDate();
			orderID = o.getOrderID();
			amount = o.getGrandTotal();
			paymentID = o.getPayment().getPaymentOption().getPaymentID();
			;
			for (CartItem p : o.getCart().getCartItemList()) {
				id += p.getProduct().getProductID() + " ";
			}

			report.add(String.format(" %-12s %-10s %-15.2f %-15s %-30s",
					new SimpleDateFormat("dd/MM/yyyy").format(orderDate), orderID, amount, paymentID, id));
		}
		String[] reportArr = new String[report.size()];
		report.toArray(reportArr);

		formatReportLayout("Yearly Order History Report", true, reportArr);
	}
}