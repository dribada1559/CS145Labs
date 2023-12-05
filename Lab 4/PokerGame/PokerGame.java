public class PokerGame {

    public dealHand()
        // print 5 Cards in the order in which they are dealt
        for (int i = 0; i < 5; i++) {
            // deal and display a Card
            hand[i] = myDeckOfCards.dealCard();
            System.out.println(hand[i].getFace() + " " + hand[i].getSuit());
         }









}
