package main.java.blackjack.object_models;

/**
 * Simple POJO (plain old Java object) that represents a Card object
 *
 * Created by ryandesmond - https://codingnomads.co
 */
public class Card {

    // the card's suit - ie, spades, clubs, diamonds, hearts
    private char suit;
    // the cards' value - ie, ACE,2,3,...,JACK,QUEEN,KIM
    private String value;
    // the card's score value - ie, face value, or 10 for Jack, Queen, King
    private int scoreValue;

    /**
     * This constructor creates a Card object
     *
     * @param suit - the suit of the new card
     * @param value - the value of the new card
     */
    public Card(char suit, String value) {
        // set the instance variable "this.suit" to the parameter value "suit"
        this.suit = suit;
        // set the instance variable "this.value" to the parameter value "value"
        this.value = value;
    }

    /**
     * This method returns a nicer formatted string representation of the Card
     *
     * @return
     */
    public String customToString() {
        return suit + value + suit;
    }

    /**
     * This method returns the int score value of a card. Cards 2-10 get their face value.
     * Ace's are worth 11 (in this game) and Jack, Queen, King are worth 10
     *
     * @return - the int score value of the card
     */
    public int getScoreValue() {

        // try to return the face value - this will work for cards 2-10
        try {
            return Integer.valueOf(value);
        } catch (Exception e){
            // if the try statement fails
            // check to see if the cards is an ACE
            if (value.equalsIgnoreCase("ACE")){
                // if so, return 11
                return 11;
            } else {
                // otherwise it must be a Jack, Queen or King, return 10
                return 10;
            }
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value='" + value + '\'' +
                ", scoreValue=" + scoreValue +
                '}';
    }
}
