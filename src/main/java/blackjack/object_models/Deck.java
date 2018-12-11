package main.java.blackjack.object_models;

import java.util.ArrayList;

/**
 * Simple POJO (plaind old Java object) that represents a card Deck
 *
 * Created by ryandesmond - https://codingnomads.co
 */
public class Deck {

    // instance variable (array) to hold deck of cards
    private Card[] deck = new Card[52];
    // instance variable (ArrayList) to hold the numbers that represent used cards
    private ArrayList<Integer> usedCards = new ArrayList();
    // // instance variable (array) to hold the possible suits of each card
    char[] suit = new char[]{'♠', '♦', '♥', '♣'};
    // static variable to track the number of fresh decks loaded (aka # of games played)
    private static int freshDecksLoaded;

    // constructor
    public Deck(){
        // call a method that loads a fresh deck
        loadFreskDeck();
        // increment the static variable freshDecksLoaded
        freshDecksLoaded++;
    }

    // simple getter for deck
    public Card[] getDeck() {
        return deck;
    }

    // simple setter for deck
    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    // simple getter for usedCards
    public ArrayList<Integer> getUsedCards() {
        return usedCards;
    }

    // simple setter for usedCards
    public void setUsedCards(ArrayList<Integer> usedCards) {
        this.usedCards = usedCards;
    }

    // simple getter for suit array
    public char[] getSuit() {
        return suit;
    }

    // simple setter for suit array
    public void setSuit(char[] suit) {
        this.suit = suit;
    }

    // simple getter for freshDecksLoaded static variable
    public static int getFreshDecksLoaded() {
        return freshDecksLoaded;
    }

    /**
     * This method loads a fresh deck of cards - this method is called automatically
     * every time a new Deck object is created
     *
     */
    private void loadFreskDeck() {

        // local count variable to use an index in the array
        int count = 0;

        // outer loop will manage the suits
        for (int x = 0; x < 4; x++){

            // inner loop will handle the card value
            for (int i = 1; i < 14; i++){

                /*
                    The first time around this inner loop, suit[x] (the value at the index
                     of "x" (currently ZERO) in the suit array) will be spades - it will loop from 1 to 13
                     which corresponds to 1 (ACE), 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 (JACK),
                     12 (QUEEN), 13 (KING) - it will set all these cards to those values with
                     the "spades" suit and add them to the "deck" array
                    Then the flow of execution will go back to the outer loop and "x" will
                    increment to 1 - which corresponds to "diamonds" in the suit array - then
                    the inner loop will start at 1 and repeat the process - loading all cards
                    ACE through King to the diamonds suit and add them to the "deck" array
                 */
                if (i == 1){
                    deck[count] = new Card(suit[x], "ACE");
                } else if (i == 11){
                    deck[count] = new Card(suit[x], "JACK");
                } else if (i == 12) {
                    deck[count] = new Card(suit[x], "QUEEN");
                } else if (i == 13) {
                    deck[count] = new Card(suit[x], "KING");
                } else {
                    // if it's not ACE, JACK, QUEEN,or KING it must be a card in between 2 and 10
                    // but it is currently an int - we need to convert it to a String
                    deck[count] = new Card(suit[x], Integer.toString(i).toUpperCase());
                }
                count++;
            }
        }
    }

    /**
     * This is a simple method that checks to see if a given random number exists
     * in the usedCards ArrayList - this number corresponds to an index in the deck[] array
     *
     * If the random number exists in the usedCards ArrayList, that means the card had
     * already been dealt and is not available to be used again
     *
     * @param value
     * @return
     */
    public boolean isCardUsed(int value) {

        // use the "contains()" method from the ArrayList class to check to see if the random
        // number is in there
        if (usedCards.contains(value)){
            // if so, return true (meaning the card has already been used)
            return true;
        } else {
            // if not, return false (meaning the card has not been used)
            return false;
        }

    }

    // simple getter to get a card at a given index
    public Card getCardAt(int randomNum) {
        return deck[randomNum];
    }
}
