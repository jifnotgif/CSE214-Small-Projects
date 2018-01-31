package hw.cse214.cc;

public class CreditCard {
    private String creditCardNumber;
    private String cardHolderName;
    private String bank;
    private int limit;
    private double balance;
    private final double LATE_FEE = 30.0;
    private int dayOfMonth = 16;

    /**
     * Constructor
     * @param creditCardNumber
     * @param cardHolderName
     * @param bank
     * @param limit
     * @param balance
     */
    public CreditCard(String creditCardNumber, String cardHolderName,
                      String bank, int limit, double balance) {
        this.creditCardNumber = creditCardNumber;
        this.cardHolderName = cardHolderName;
        this.bank = bank;
        this.limit = limit;
        this.balance = balance;
    }

    /*
     *  Accessor Methods
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public String getCardHolderName() {
        return cardHolderName;
    }
    public String getBank(){ return bank; }
    public int getLimit(){return limit;}
    public double getBalance(){ return balance;}


    /*
    *   Action methods
    */

    /**
     *
     * A method that charges credit card balance
     *
     * @param price  Amount of money to charge credit card
     *
     */
    public void chargeIt(double price){
        balance += price;
        if (balance > limit) {
            balance -= price;
            System.out.println("limit exceeded");
        }
    }

    /**
     *
     * A method that pays off credit card balance
     *
     * @param amount  Amount of money to subtract from balance
     */
    public void makePayment(double amount){
        balance -= amount;
        if(dayOfMonth > 15 ){
            balance += LATE_FEE; }
    }


    @Override
    public String toString(){
        return "CreditCard [creditCardNumber=" + creditCardNumber
                + ", cardHolderName=" + cardHolderName + ", bank=" + bank
                + ", limit=" + limit + ", balance=" + balance + "]";
    }

    public static void main(String[] args){

        CreditCard cc = new CreditCard("123", "h", "bank", 1000, 500);

        //Credit card charged with 100
        cc.chargeIt(100);

        System.out.println(cc);

        //Credit card bill paid past the due date so fee is charged
        cc.makePayment(600);

        System.out.println(cc);

    }
}