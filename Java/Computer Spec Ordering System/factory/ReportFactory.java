package factory;

import entity.Customer;
import template.Report;
import util.CartItemHistoryReport;
import util.DiscountHistoryReport;
import util.OrderHistoryReport;

public class ReportFactory {
	public Report generateReport(Customer customer, String reportType) {
		switch (reportType) {
		case "1":
			return new DiscountHistoryReport(customer);
		case "2":
			return new OrderHistoryReport(customer);
		case "3":
			return new CartItemHistoryReport(customer);
		}
		return null;
	}
}
