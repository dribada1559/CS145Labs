// Purpose: dealing the hand and determain what kind of hand it is 




public class PokerHandTest {
    // execute application
   public static void main(String[] args) {
    DeckOfCards myDeckOfCards = new DeckOfCards();
    myDeckOfCards.shuffle(); // place Cards in random order
    Card[] hand = new Card[5];
    
    // print 5 Cards in the order in which they are dealt
    for (int i = 0; i < 5; i++) {
       // deal and display a Card
       hand[i] = myDeckOfCards.dealCard();
       System.out.println(hand[i].getFace() + " " + hand[i].getSuit());
    }
    
    System.out.println("You have a " + myDeckOfCards.evaluePokerHand(hand));
 } 
}
