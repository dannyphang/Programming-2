import java.text.*;
import java.util.*;

public class Card extends PaymentOption {
    private String cardNum;
    private String cvv;
    private String expiryDate;
    static int cardnumarray[] = new int[12];

    public Card() {
        
    }

    public Card(String paymentMethod, String cardNum, String cvv, String expiryDate) {
        super();
        this.cardNum = cardNum;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    // getter & setter
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static boolean validateCardNum(String cardNum) {
        boolean validCardNum;
        
        if(cardNum.length() == 12 /*&& Input_Validator.isNumeric(cardNum)*/){
            for(int i = 0; i < cardNum.length(); i++){
                cardnumarray[i] = Character.getNumericValue(cardNum.charAt(i));
            }
            if((cardnumarray[0] == 8 && cardnumarray[1] == 7) || (cardnumarray[0] == 4 && cardnumarray[1] == 9)){
                validCardNum = true;
            }
            else{
                validCardNum = false;
            }
        }
        else{
            validCardNum = false;
        }

        return validCardNum;
    }

    
    public static boolean validateExpDate(String expiryDate){
        Date date = new Date(); // So that the date can compare with the dateFormat

        try {
            Date dateFormat = new SimpleDateFormat("MMyy").parse(expiryDate);
            return (dateFormat.compareTo(date) >= 0);
        } 
        catch (Exception e) {
            return false;
        }

    }

    public static boolean validateCVV(String cvv){
        int cvvarray[] = new int[3];
        boolean validCvv;
        if(cvv.length() == 3){
            for(int i = 0; i < 3; i++){
                cvvarray[i] = Character.getNumericValue(cvv.charAt(i));
            }
            validCvv = true;
        }
        else{
            validCvv = false;
        }
        
        return validCvv;
    }

    public static String vendor(){
        String vendorName;

        if((cardnumarray[0] == 8 && cardnumarray[1] == 7)){
            vendorName = "Vosa";
        }
        else{
            vendorName = "Mastor";
        }
        
        return vendorName;
    }
    
}