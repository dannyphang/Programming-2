public class Staff{
    private String name;
    private String id;
    private Income income;
    
    public Staff(String name, String id, Income income){
        this.name = name;
        this.id = id;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public double calculateNetIncome(){
        return (income.getAmount() - income.getTotalTax());    
    }
    
    public void displayStaffInfo(){
        System.out.println("\nSTAFF INCOME REPORT\n");
        
        System.out.println("Staff Name: " + name);
        System.out.println("StaffID: " + id);
    }
    
    public void displayIncomeInfo(){
        System.out.println("Income Type: " + income.getIncomeType());
        System.out.println("Income Amount: " + income.getAmount());
        System.out.println("Tax: " + income.getTax());
        
        income.setTotalTax(income.getTax(), income.getAmount());
        System.out.println("Total Tax Paid: " + income.getTotalTax());
        System.out.println("Total Net Income: " + calculateNetIncome());
        
    }
}