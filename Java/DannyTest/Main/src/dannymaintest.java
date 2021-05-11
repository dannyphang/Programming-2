import java.util.*;

public class dannymaintest {
    Scanner in = new Scanner(System.in);
    Loan loan = new Loan();
    Job job = new Job();

    int fee = in.nextInt();
    int sal = in.nextInt();

    loan.AboutMe(fee);
    sal.AboutMe(sal);
    
}

interface myApplication{
    abstract double CalAppCharges();
    abstract String AboutMe();
  
  }
  
  class Loan implements myApplication{
    private int processingFees;
    final int FORM_PRICE = 20;
    
    @Override
    public double CalAppCharges() {
      int cal = processingFees + FORM_PRICE;
      return cal;
    }
  
    public int getProcessingFees() {
      return processingFees;
    }
  
    public void setProcessingFees(int processingFees) {
      this.processingFees = processingFees;
    }
  
      @Override
      public String AboutMe() {
          
          return "Processing fees: RM" + getProcessingFees() + "\nFrom price: RM" + FORM_PRICE + "\nApplication charges: RM" + CalAppCharges();
      }
  
  
  }
  
  class Job implements myApplication{
    private int salary;
  
    @Override
    public double CalAppCharges() {
      double cal = 0.1 * salary;
      return cal;
    }
  
    @Override
    public String AboutMe() {
      
      return "Salary: RM" + getSalary() + "\nApplication Charges: RM" + CalAppCharges();
    }
  
    public int getSalary() {
      return salary;
    }
  
    public void setSalary(int salary) {
      this.salary = salary;
    }
  
  }