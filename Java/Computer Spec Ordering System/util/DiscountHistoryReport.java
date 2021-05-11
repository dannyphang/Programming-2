package util;

import java.text.SimpleDateFormat;
import java.util.*;

import entity.Customer;
import entity.Discount;
import entity.Order;
import template.Report;

/**
 * This report will print out -total Cash Rebate -Average Cash Rebate per
 * transaction -highest discount percentage -average discount percentage
 * 
 * -accumulative saved amount
 */
public class DiscountHistoryReport extends Report {

	public DiscountHistoryReport(Customer c) {
		customer = c;
	}

	// It will print out a Discount History report from all Order from Customer
	// entity
	@Override
	public void printReport() {
		String[] report = { String.format("%30s", "Total Cash Rebate: "),
				String.format("%30s", "Average Cash Rebate: "), String.format("%30s", "Highest Discount Percentage: "),
				String.format("%30s", "Average Discount Percentage: "), "",
				String.format("%30s", "Accumulative Saved Amount: ") };
		Date dateAfter;
		List<Order> result = customer.getOrderList();
		double tCashRebate = 0, maxDiscountPercentage = 0, tDiscountPercentage = 0, savedAmount = 0;
		int transactionCount = 0, discountPercentageCount = 0;

		Collections.sort(result);
		dateAfter = !result.isEmpty() ? result.get(0).getCheckoutDate() : null;

		for (Order o : result) {
			Discount d = o.getDiscount();

			tCashRebate += d.getTotalCashRebate();
			transactionCount++;
			maxDiscountPercentage = maxDiscountPercentage >= d.getTotalPercentage() ? maxDiscountPercentage
					: d.getTotalPercentage();
			discountPercentageCount++;
			savedAmount += o.getCart().getTotal() - o.getGrandTotal();
		}

		report[0] += "RM" + String.format("%10.2f", tCashRebate);
		report[1] += "RM" + String.format("%10.2f",
				transactionCount == 0 ? 0 : transactionCount == 0 ? 0 : tCashRebate / transactionCount);
		report[2] += String.format("%12.2f", maxDiscountPercentage) + "%";
		report[3] += String.format("%12.2f",
				discountPercentageCount == 0 ? 0 : tDiscountPercentage / discountPercentageCount) + "%";
		report[5] += "RM" + String.format("%10.2f", savedAmount);

		formatReportLayout(
				"Discount History Report since "
						+ (dateAfter != null ? new SimpleDateFormat("dd/MM/yyyy").format(dateAfter) : ""),
				true, report);
	}

	// It will print out a Discount History report from Order since last week from
	// Customer entity
	@Override
	public void printByWeek() {
		String[] report = { String.format("%30s", "Total Cash Rebate: "),
				String.format("%30s", "Average Cash Rebate: "), String.format("%30s", "Highest Discount Percentage: "),
				String.format("%30s", "Average Discount Percentage: "), "",
				String.format("%30s", "Accumulative Saved Amount: ") };
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		Date dateAfter = cal.getTime();
		List<Order> result = customer.getOrderList();
		double tCashRebate = 0, maxDiscountPercentage = 0, tDiscountPercentage = 0, savedAmount = 0;
		int transactionCount = 0, discountPercentageCount = 0;

		Collections.sort(result);
		Collections.reverse(result);

		for (Order o : result) {
			if (o.getCheckoutDate().compareTo(dateAfter) == -1)
				break;

			Discount d = o.getDiscount();

			tCashRebate += d.getTotalCashRebate();
			transactionCount++;
			maxDiscountPercentage = maxDiscountPercentage >= d.getTotalPercentage() ? maxDiscountPercentage
					: d.getTotalPercentage();
			discountPercentageCount++;
			savedAmount += o.getCart().getTotal() - o.getGrandTotal();
		}

		report[0] += "RM" + String.format("%10.2f", tCashRebate);
		report[1] += "RM" + String.format("%10.2f", transactionCount == 0 ? 0 : tCashRebate / transactionCount);
		report[2] += String.format("%12.2f", maxDiscountPercentage) + "%";
		report[3] += String.format("%12.2f",
				discountPercentageCount == 0 ? 0 : tDiscountPercentage / discountPercentageCount) + "%";
		report[5] += "RM" + String.format("%10.2f", savedAmount);

		formatReportLayout("Discount History Report since " + new SimpleDateFormat("dd/MM/yyyy").format(dateAfter),
				true, report);

	}

	// It will print out a Discount History report from Order since last month from
	// Customer entity
	@Override
	public void printByMonth() {
		String[] report = { String.format("%30s", "Total Cash Rebate: "),
				String.format("%30s", "Average Cash Rebate: "), String.format("%30s", "Highest Discount Percentage: "),
				String.format("%30s", "Average Discount Percentage: "), "",
				String.format("%30s", "Accumulative Saved Amount: ") };
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		Date dateAfter = cal.getTime();
		List<Order> result = customer.getOrderList();
		double tCashRebate = 0, maxDiscountPercentage = 0, tDiscountPercentage = 0, savedAmount = 0;
		int transactionCount = 0, discountPercentageCount = 0;

		Collections.sort(result);
		Collections.reverse(result);

		for (Order o : result) {
			if (o.getCheckoutDate().compareTo(dateAfter) == -1)
				break;

			Discount d = o.getDiscount();

			tCashRebate += d.getTotalCashRebate();
			transactionCount++;
			maxDiscountPercentage = maxDiscountPercentage >= d.getTotalPercentage() ? maxDiscountPercentage
					: d.getTotalPercentage();
			discountPercentageCount++;
			savedAmount += o.getCart().getTotal() - o.getGrandTotal();
		}

		report[0] += "RM" + String.format("%10.2f", tCashRebate);
		report[1] += "RM" + String.format("%10.2f", transactionCount == 0 ? 0 : tCashRebate / transactionCount);
		report[2] += String.format("%12.2f", maxDiscountPercentage) + "%";
		report[3] += String.format("%12.2f",
				discountPercentageCount == 0 ? 0 : tDiscountPercentage / discountPercentageCount) + "%";
		report[5] += "RM" + String.format("%10.2f", savedAmount);

		formatReportLayout("Discount History Report since " + new SimpleDateFormat("dd/MM/yyyy").format(dateAfter),
				true, report);

	}

	// It will print out a Discount History report from Order since last year from
	// Customer entity
	@Override
	public void printByYear() {
		String[] report = { String.format("%30s", "Total Cash Rebate: "),
				String.format("%30s", "Average Cash Rebate: "), String.format("%30s", "Highest Discount Percentage: "),
				String.format("%30s", "Average Discount Percentage: "), "",
				String.format("%30s", "Accumulative Saved Amount: ") };
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1);
		Date dateAfter = cal.getTime();
		List<Order> result = customer.getOrderList();
		double tCashRebate = 0, maxDiscountPercentage = 0, tDiscountPercentage = 0, savedAmount = 0;
		int transactionCount = 0, discountPercentageCount = 0;

		Collections.sort(result);
		Collections.reverse(result);

		for (Order o : result) {
			if (o.getCheckoutDate().compareTo(dateAfter) == -1)
				break;

			Discount d = o.getDiscount();

			tCashRebate += d.getTotalCashRebate();
			transactionCount++;
			maxDiscountPercentage = maxDiscountPercentage >= d.getTotalPercentage() ? maxDiscountPercentage
					: d.getTotalPercentage();
			discountPercentageCount++;
			savedAmount += o.getCart().getTotal() - o.getGrandTotal();
		}

		report[0] += "RM" + String.format("%10.2f", tCashRebate);
		report[1] += "RM" + String.format("%10.2f", transactionCount == 0 ? 0 : tCashRebate / transactionCount);
		report[2] += String.format("%12.2f", maxDiscountPercentage) + "%";
		report[3] += String
				.format("%12.2f",
						discountPercentageCount == 0 ? 0
								: discountPercentageCount == 0 ? 0 : tDiscountPercentage / discountPercentageCount)
				+ "%";
		report[5] += "RM" + String.format("%10.2f", savedAmount);

		formatReportLayout("Discount History Report since " + new SimpleDateFormat("dd/MM/yyyy").format(dateAfter),
				true, report);
	}
}
