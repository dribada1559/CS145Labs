// Purpose: DeckOfCrads class represents five careds being dealt. 

import java.security.SecureRandom; // imports a class that provides a strong random number generator

public class DeckOfCards {
    // random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

    private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
    private int currentCard = 0; // index of next Card to be dealt (0-51)

    // constructor fills deck of Cards
    public DeckOfCards() {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

        // populate deck with Card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13], count);
        }
    }

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // next call to method dealCard should start at deck[0] again
        currentCard = 0;

        // for each Card, pick another random Card (0-51) and swap them
        for (int first = 0; first < deck.length; first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            return deck[currentCard++]; // return current Card in array
        } else {
            return null; // return null to indicate that all Cards were dealt
        }
    }

    public String evaluePokerHand(Card[] hand) {
        // If its the wrong size, return false
        if (hand.length != 5) {
            return "Invalid hand size";
        }

        if (isFullHouse(hand))
            return "Full House";
        else if (isFourOfAKind(hand))
            return "Four Of A Kind";
        else if (isFlush(hand))
            return "Flush";
        else if (isStraight(hand))
            return "Straight";
        else if (isThreeOfAKind(hand))
            return "Three Of A Kind";
        else if (isTwoPairs(hand))
            return "Two Pair";
        else if (isPair(hand))
            return "Pair";
        else
            return "High Card";

    }

    private boolean isPair(Card[] hand) {
        Card temp;
        // Loop through the entire hand
        for (int i = 0; i < hand.length; i++) {
            // Checks every card for a pair
            temp = hand[i];
            for (int j = i + 1; j < hand.length; j++) {
                if (temp.getFace() == hand[j].getFace()) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isTwoPairs(Card[] hand) {
        int counter = 0;
        Card temp;
        // Loop through the entire hand
        for (int i = 0; i < hand.length; i++) {
            // Checks every card for a pair
            temp = hand[i];
            for (int j = i + 1; j < hand.length; j++) {
                if (temp.getFace() == hand[j].getFace()) {
                    counter++;
                    if (counter == 2)
                        return true;
                    else
                        j = hand.length;
                }
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(Card[] hand) {
        int counter = 0;
        Card temp;
        // Loop through the entire hand
        for (int i = 0; i < hand.length; i++) {
            counter = 0;
            // Checks every card for a three of a kind
            temp = hand[i];
            for (int j = i + 1; j < hand.length; j++) {
                if (temp.getFace() == hand[j].getFace()) {
                    counter++;
                    if (counter == 3)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean isFourOfAKind(Card[] hand) {
        int counter = 0;
        Card temp;
        // Loop through the entire hand
        for (int i = 0; i < hand.length; i++) {
            counter = 0;
            // Checks every card for a four of a kind
            temp = hand[i];
            for (int j = i + 1; j < hand.length; j++) {
                if (temp.getFace() == hand[j].getFace()) {
                    counter++;
                    if (counter == 4)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean isFlush(Card[] hand) {
        // Get the first suit
        String tempSuit = hand[0].getSuit();
        // If the rest of the cards dont match the first one, return false
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getSuit() != tempSuit)
                return false;
        }
        return true;
    }

    private boolean isStraight(Card[] hand) {
        // Sort the hand in order by value using bubble sort
        Card temp;
        boolean isSorted;
        do {
            // Sets sorted by default
            isSorted = true;
            // Checks every card in the hand
            for (int i = 0; i < hand.length - 1; i++) {
                // If a card is greater than the card to its "right"
                if (hand[i].getValue() > hand[i + 1].getValue()) {
                    // Swap them
                    temp = hand[i];
                    hand[i] = hand[i + 1];
                    hand[i + 1] = temp;
                    // Then set sorted to false
                    isSorted = false;
                }
            }
        } while (isSorted);

        // Check to see if straight
        for (int i = 0; i < hand.length - 1; i++) {
            // Take the difference in the value of the cards and if the difference isn't 1
            // away its not straight
            if ((Math.abs(hand[i].getValue() - hand[i + 1].getValue()) != 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean isFullHouse(Card[] hand) {
        boolean pair = false;
        boolean threeOfAKind = false;

        Card threeCard = null;

        // Check for a pair
        int counter = 0;
        Card temp;
        // Loop through the entire hand
        for (int i = 0; i < hand.length; i++) {
            counter = 0;
            // Checks every card for a three of a kind
            temp = hand[i];
            for (int j = i + 1; j < hand.length; j++) {
                if (temp.getFace() == hand[j].getFace()) {
                    counter++;
                }
            }

            // Check amount of same face card
            if (counter == 4) {
                return false;
            } else if (counter == 3) {
                threeOfAKind = true;
                threeCard = hand[i];
            } else if (counter == 2 && hand[i].getFace() != threeCard.getFace()) {
                pair = true;
            }

            // Check to see if we have a full house
            if (pair && threeOfAKind) {
                return true;
            }
        }

        return false;
    }
}