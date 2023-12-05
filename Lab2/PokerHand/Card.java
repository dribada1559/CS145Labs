// Name: Darcy Ribada
// Class: CS 145
// Date: 9/30/23
// Assignment: Lab 2
// Reference Materials: w3schools, 
// Purpose: This program deals a five-card poker hand and determines what each hand contains. 

// Card class represents a playing card
public class Card {
    private final String face; // face of the card
    private final String suit; // suit of the card
    private final int value;

    // this constructor initializes the card's face and suit
    public Card(String cardFace, String cardSuit, int cardValue) {
        this.face = cardFace;
        this.suit = cardSuit;
        this.value = cardValue;
    }

    // returns String representation of Card
    public String toString() {
        return face + " of " + suit;
    }

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
