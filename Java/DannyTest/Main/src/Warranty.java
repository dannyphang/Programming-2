import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Warranty {
    //data declaration
    private String warrantyID;
    private double warrantyYearLength;
    private String warrantyCoverage;
    private static int totalPage;
    private static List<Warranty> warrantyList = new ArrayList<Warranty> (Arrays.asList(
    	new Warranty ("WR1"),
    	new Warranty ("WR2"),
    	new Warranty ("WR3"),
    	new Warranty ("WR4"),
    	new Warranty ("WR5"),
    	new Warranty ("WR6")));
    
    //constructor
    public Warranty() {
    	this.warrantyID = "N/A";
    	this.warrantyYearLength = 0;
    	this.warrantyCoverage = "N/A";
    }

    public Warranty(String warrantyID) {
        if (warrantyID.equals("WR2")) {
        	this.warrantyID = warrantyID;
        	this.warrantyYearLength = 0.5;
        	this.warrantyCoverage = "Broken";
        }
        else if (warrantyID.equals("WR3")) {
        	this.warrantyID = warrantyID;
        	this.warrantyYearLength = 1;
        	this.warrantyCoverage = "Broken";
        }
        else if (warrantyID.equals("WR4")) {
        	this.warrantyID = warrantyID;
        	this.warrantyYearLength = 1.5;
        	this.warrantyCoverage = "Water or broken";
        }
        
        else if (warrantyID.equals("WR5")) {
        	this.warrantyID = warrantyID;
        	this.warrantyYearLength = 2;
        	this.warrantyCoverage = "Water or broken";
        }
        
        else if (warrantyID.equals("WR6")) {
        	this.warrantyID = warrantyID;
        	this.warrantyYearLength = 2.5;
        	this.warrantyCoverage = "Fire, water or broken";
        }
        else {
        	this.warrantyID = "WR1"; // default most basic package
        	this.warrantyYearLength = 0.25; // default warranty is 3 months
        	this.warrantyCoverage = "Broken";
        }
    }

    //getter and setter
    public String getWarrantyID() {
        return warrantyID;
    }

    public void setWarrantyID(String warrantyID) {
        this.warrantyID = warrantyID;
    }

    public double getWarrantyYearLength() {
        return warrantyYearLength;
    }

    public void setWarrantyYearLength(double warrantyYearLength) {
        this.warrantyYearLength = warrantyYearLength;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }
    
    public static List<Warranty> getWarrantyList() {
		return warrantyList;
	}

	public static void setWarrantyList(List<Warranty> warrantyList) {
		Warranty.warrantyList = warrantyList;
	}
	
	public static int getTotalPage() {
		return totalPage;
	}

	public static void setTotalPage(int totalPage) {
		Warranty.totalPage = totalPage;
	}

	public static List<Warranty> getResult(int page){
		totalPage = 0;
		List<Warranty> result = new ArrayList<Warranty>();
		// if next page is empty, start from previous page
		
		totalPage = warrantyList.size() % Product.getListingLimit() == 0 
				? warrantyList.size() / Product.getListingLimit() : warrantyList.size() / Product.getListingLimit() + 1;
    			//total pages
		int startIndex = (page - 1) * Product.getListingLimit() >= warrantyList.size() ? (page - 2) * Product.getListingLimit()
				: (page - 1) * Product.getListingLimit();
		int endIndex = startIndex + Product.getListingLimit() - 1 > warrantyList.size() - 1 ? warrantyList.size() - 1
				: startIndex + Product.getListingLimit() - 1;
		
		for (int i = startIndex; i <= endIndex; i++) {
			result.add(warrantyList.get(i));
		}
			
		return result;
	}
	
	public static String printHeadings() { // print only warranty ID
    	return String.format("%2s %-14s", " ", "Warranty ID");
    }
    
    public static String printHeadings(int page) {
    	return String.format("%-20s %6s %d %s %d %s", "Warranty Information", "\nPage ", page, "/", totalPage, "\n")
    			+ String.format("%-14s %-5s %11s", "Warranty ID", "Year", "Coverage")
    			+ "\n=======================================\n";
    }
    
    @Override
    public String toString(){
        return String.format("%-14s", warrantyID);
    }

    public String toString(int page){
        return String.format("%-15s %-4.1f %-10s", warrantyID, warrantyYearLength, warrantyCoverage);
    }
    
//    public static void main(String[] args) {
//    	Warranty warrSample = new Warranty(2.5, "Water, snap and fire");
//    	System.out.println(printHeadings());
//    	System.out.println(warrSample.toString());
//    }
}