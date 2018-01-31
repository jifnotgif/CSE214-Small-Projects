package hw.cse214.cards;

public class Player {
    private int playerId;
    private Card[] activeCards;

    /**
     * Constructor
     * @param playerId
     */
    public Player(int playerId){

        this.playerId = playerId;

    }

    public void setCards(Card[] cards){
        activeCards = cards;
    }

    /**
     * Shows cards
     *
     */
    public void printCards(){
        for(Card i : activeCards){
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }

    /**
     *
     * Method that sorts cards by suit then number
     *
     */

    public void sortCards() {
        int counter, currentCard, suitLimit;

        // counter for each suit created to order the numbers within each suit
        int countSpade =0, countHeart =0, countDia = 0, countClub = 0, suitCount =0;

        Card card;

        /**
         * Insertion sort to sort the suits
         */

        for(counter = 0; counter < activeCards.length; counter++){
            card = activeCards[counter];
            currentCard = counter;
            if(card.getSuit() == 1){countSpade++;}
            if(card.getSuit() == 2){countHeart++;}
            if(card.getSuit() == 3){countDia++;}
            if(card.getSuit() == 4){countClub++;}

            while(currentCard > 0 && activeCards[currentCard -1].compareSuit(card)){
                activeCards[currentCard] = activeCards[currentCard -1];
                currentCard--;

            }
            activeCards[currentCard] = card;

        }

        /**
         * sorts the numbers within spade ( highest order suit )
         */
        for(counter = 0; counter< countSpade; counter++){
            card = activeCards[counter];
            currentCard = counter;

            while(currentCard > suitCount && activeCards[currentCard -1].compareValue(card)){
                activeCards[currentCard] = activeCards[currentCard -1];
                currentCard--;

            }
            activeCards[currentCard] = card;
        }

        suitCount += countSpade;
         /**
         * sorts the numbers within hearts ( second order suit )
         */
        for(counter = suitCount; counter< suitCount + countHeart; counter++){
            card = activeCards[counter];
            currentCard = counter;

            while(currentCard > suitCount && activeCards[currentCard -1].compareValue(card)){
                activeCards[currentCard] = activeCards[currentCard -1];
                currentCard--;

            }
            activeCards[currentCard] = card;
        }

        suitCount +=countHeart;
         /**
         * sorts the numbers within diamonds ( third order suit )
         */
        for(counter = suitCount; counter< suitCount + countDia; counter++){
            card = activeCards[counter];
            currentCard = counter;

            while(currentCard > suitCount && activeCards[currentCard -1].compareValue(card)){
                activeCards[currentCard] = activeCards[currentCard -1];
                currentCard--;

            }
            activeCards[currentCard] = card;
        }

        suitCount += countDia;

         /**
         * sorts the numbers within spade ( lowest order suit )
         */
        for(counter = suitCount; counter< suitCount + countClub; counter++){
            card = activeCards[counter];
            currentCard = counter;

            while(currentCard > suitCount && activeCards[currentCard -1].compareValue(card)){
                activeCards[currentCard] = activeCards[currentCard -1];
                currentCard--;

            }
            activeCards[currentCard] = card;
        }
    }
}
