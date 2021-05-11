public class Cash extends PaymentOption{
    private String currency;

    //constructor
    public Cash(){
        super();
    }

    public Cash(int paymentID, String paymentMethod, double paymentAmount, String currency){
        super();
        this.currency = currency; //where is this currency coming from
    }

    //getter & setter
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}