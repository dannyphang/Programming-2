import java.util.*;

public class MealRecord implements CommonFunction{
    private String recordID;
    private byte image;
    private String foodName;
    private String drink;
    private String day;
    private String date;
    private String foodGrp;
    private String mealType;
    private ArrayList<MealRecord> mealRecordList = new ArrayList<MealRecord>();
    Scanner scanner = new Scanner(System.in);
    
    public MealRecord(String recordID, byte image, String foodName, String drink, String day, String date, String foodGrp, String mealType) {
        this.recordID = recordID;
        this.image = image;
        this.foodName = foodName;
        this.drink = drink;
        this.day = day;
        this.date = date;
        this.foodGrp = foodGrp;
        this.mealType = mealType;
    }
    
    public String getRecordID() {
        return recordID;
    }
    
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }
    
    public byte getImage() {
        return image;
    }
    
    public void setImage(byte image) {
        this.image = image;
    }
    
    public String getFoodName() {
        return foodName;
    }
    
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    
    public String getDrink() {
        return drink;
    }
    
    public void setDrink(String drink) {
        this.drink = drink;
    }
    
    public String getDay() {
        return day;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getFoodGrp() {
        return foodGrp;
    }
    
    public void setFoodGrp(String foodGrp) {
        this.foodGrp = foodGrp;
    }
    
    public String getMealType() {
        return mealType;
    }
    
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public ArrayList<MealRecord> getMealRecordList() {
        return mealRecordList;
    }

    public void setMealRecordList(ArrayList<MealRecord> mealRecordList) {
        this.mealRecordList = mealRecordList;
    }

    @Override
    public void add() {
        // mealRecordList.add(new MealRecord(getRecordID(), getImage(), getFoodName(), getDrink(), getDay(), getDate(), getFoodGrp(), getMealType()));
        mealRecordList.add(new MealRecord(getRecordID(), (byte) 0, getFoodName(), getDrink(), getDay(), getDate(), getFoodGrp(), getMealType()));
    }

    @Override
    public void view() {
        
    }

    @Override
    public void edit() {
        
        
    }

    @Override
    public void del() {
        
        
    }
    
    public String dateConvert(String days, String months, String years){
        String temp = days + "-" + months + "-" + years;
        setDate(temp);
        return temp;
    }
}
