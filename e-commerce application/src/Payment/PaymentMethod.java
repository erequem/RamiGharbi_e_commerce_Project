package Payment;

public class PaymentMethod{
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;
    public PaymentMethod(String cardNumber, String cardHolder, String expirationDate, String cvv){
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }
    public String getCardNumber(){
        return this.cardNumber;
    }
    public String getCardHolder(){
        return this.cardHolder;
    }
    public String getExpirationDate(){
        return this.expirationDate;
    }
    public String getCvv(){
        return this.cvv;
    }
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void setCardHolder(String cardHolder){
        this.cardHolder = cardHolder;
    }
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
    public void setCvv(String cvv){
        this.cvv = cvv;
    }
    public String toString(){
        return "Card Number: " + this.cardNumber + "\nCard Holder: " + this.cardHolder + "\nExpiration Date: " + this.expirationDate + "\nCVV: " + this.cvv;
    }
}
