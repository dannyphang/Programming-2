package template;

import java.text.SimpleDateFormat;
import java.util.*;

import entity.Customer;
import util.Utility;

public abstract class Report {	
	protected Customer customer;
	
	public abstract void printReport();

	public abstract void printByWeek();

	public abstract void printByMonth();

	public abstract void printByYear();
	
	public void formatReportLayout(String title,boolean showDate,String[] arr) {
		String[] result=new String[arr.length+2+(showDate?1:0)];
		int titleLength=title.length();
		int arrMaxLength=Utility.longestString(arr);
		int maxLength=titleLength>arrMaxLength?titleLength:arrMaxLength;//to see whether title longer or string in arr longer, to prevent overflow
		int titlePadding=(maxLength-title.length())/2;
		
		if(showDate)
			result[0]=String.format("%"+maxLength+"s", new SimpleDateFormat("dd MMM yyyy").format(new Date()));
		
		//System.out.println(titlePadding);
		result[showDate?1:0]=String.format("%"+(titlePadding+titleLength)+"s",title);
		System.arraycopy(arr, 0, result, showDate?3:2, arr.length);
		Utility.formatMenu(result);
	}
}
