package hw.cse214.cards;

public class Card {
    private String cardInfo;
    private String suit;
    private String value;
    private int suitOrder;
    private int valueOrder;


    /**
     * Constructor
     * @param cardInfo
     */

    public Card(String cardInfo){
        this.cardInfo = cardInfo;
        this.suit = cardInfo.substring(0,1);
        this.value = cardInfo.substring(1, cardInfo.length());
        assignSuitOrder();
        assignValueOrder();
    }

    /**
     * Method that assigns a value according to a card's suit
     */
    public void assignSuitOrder() {
        switch (suit) {
            case "S":
                this.suitOrder = 1;
                break;
            case "H":
                this.suitOrder = 2;
                break;
            case "D":
                this.suitOrder = 3;
                break;
            case "C":
                this.suitOrder = 4;
                break;
            default:
                this.suitOrder = 0;
                break;

        }
    }

    /**
     *
     * Method that assigns a value according to card's number
     *
     */
    public void assignValueOrder(){
        switch(value){
            case "A":
                this.valueOrder = 1;
                break;
            case "K":
                this.valueOrder = 2;
                break;
            case "Q":
                this.valueOrder = 3;
                break;
            case "J":
                this.valueOrder = 4;
                break;
            case "10":
                this.valueOrder = 5;
                break;
            case "9":
                this.valueOrder = 6;
                break;
            case "8":
                this.valueOrder = 7;
                break;
            case "7":
                this.valueOrder = 8;
                break;
            case "6":
                this.valueOrder = 9;
                break;
            case "5":
                this.valueOrder = 10;
                break;
            case "4":
                this.valueOrder = 11;
                break;
            case "3":
                this.valueOrder = 12;
                break;
            case "2":
                this.valueOrder = 13;
                break;
            default:
                this.valueOrder = 0;
                break;
        }
    }

    /**
     *
     * Accessor Methods
     *
     */
    public int getSuit() { return suitOrder; }
    public int getValue() { return valueOrder; }
    public String getName() {return cardInfo;}

    /**
     * A method that compares the suit value of current card to input card
     *
     * @param c  Another card object
     * @return   <code>true</code> if current card suit value is greater than compared card suit
     *           <code>false</code> compared card suit value is greater than current card suit
     *
     */
    public boolean compareSuit(Card c){
        if (getSuit() > c.getSuit()){return true;}
        else return false;
    }

    /**
     * A method that compares the number value of current card to input card
     *
     * @param c  Another card object
     * @return   <code>true</code> if current card number value is greater than compared card number
     *           <code>false</code> compared card number value is greater than current card number
     *
     */
    public boolean compareValue(Card c){
        if (getValue() > c.getValue()){return true;}
        else return false;
    }

    @Override
    public String toString(){
        return cardInfo;
    }

}