public class Income {
    private String incomeType;
    private double amount;
    private double tax;
    private double totalTax;
    
    public Income(String incomeType, double amount, double tax){
        this.incomeType = incomeType;
        this.amount = amount;
        this.tax = tax;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double tax, double amount) {
        this.totalTax = (tax / 100) * amount;
    }
    
     
    
    
    
}
