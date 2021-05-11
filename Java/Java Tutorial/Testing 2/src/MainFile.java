import java.util.*;

public class MainFile {
    public static void main(String[] args){
        String name;
        String staffid;
        String incomeType;
        float incomeAmount;
        float incomeTax;
        
        
        Scanner myScn = new Scanner(System.in);
        System.out.print("Please enter the Staff Name: ");
        name = myScn.nextLine();
        
        
        System.out.print("Please enter the Staff ID: ");
        staffid = myScn.nextLine();
        
        System.out.print("Please enter the Staff Income type: ");
        incomeType = myScn.nextLine();
        
        System.out.print("Please enter the Staff Income amount: ");
        incomeAmount = myScn.nextFloat();
        
        System.out.print("Please enter the Staff Income tax percentage: ");
        incomeTax = myScn.nextFloat();
        
        
        
        Income income = new Income(incomeType, incomeAmount, incomeTax);
        Staff staff = new Staff(name, staffid, income);
        staff.setName(name);
        staff.setId(staffid);
        income.setIncomeType(incomeType);
        income.setAmount(incomeAmount);
        income.setTax(incomeTax);
        
        staff.displayStaffInfo();
        staff.displayIncomeInfo();
         
        myScn.close();
    }
}
