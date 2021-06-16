import java.util.*;

public class Main{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        // String input = in.nextLine();
        
        // if(input.matches("(.*)@(.*)") && input.matches("(.*).com(.*)")){
        //     System.out.println("true");
        // }
        // else{
        //     System.out.println("False");
        // }
        
        // login page
        // main menu
        
        String recordID;
        String foodName;
        String drink;
        String day;
        String date;
        String foodGrp;
        String mealType;
        
        MealRecord mr = new MealRecord(null, (byte) 0, null, null, null, null, null, null);
        
        mr.setRecordID("record 1");
        mr.setFoodName("food 1");
        mr.setDrink("drink 1");
        mr.setDay("day 1");
        mr.setDate("date 1");
        mr.setFoodGrp("grp 1");
        mr.setMealType("type 1");
        mr.add();
        
        mr.setRecordID("record 2");
        mr.setFoodName("food 2");
        mr.setDrink("drink 2");
        mr.setDay("day 2");
        mr.setDate("date 2");
        mr.setFoodGrp("grp 2");
        mr.setMealType("type 2");
        mr.add();
        
        System.out.println("meal list size: " + mr.getMealRecordList().size());
    }  
}
