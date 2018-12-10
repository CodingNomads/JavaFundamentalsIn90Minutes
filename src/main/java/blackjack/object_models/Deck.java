package main.java.blackjack.object_models;

import java.util.ArrayList;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Deck {

    private Card[] deck = new Card[52];
    private ArrayList<Integer> usedCards = new ArrayList();
    char[] suit = new char[]{'♠', '♦', '♥', '♣'};
    private static int freshDecksLoaded;

    public Deck(){
        loadFreskDeck();
        freshDecksLoaded++;
    }

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    public ArrayList<Integer> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(ArrayList<Integer> usedCards) {
        this.usedCards = usedCards;
    }

    public char[] getSuit() {
        return suit;
    }

    public void setSuit(char[] suit) {
        this.suit = suit;
    }

    public static int getFreshDecksLoaded() {
        return freshDecksLoaded;
    }

    public static void setFreshDecksLoaded(int freshDecksLoaded) {
        Deck.freshDecksLoaded = freshDecksLoaded;
    }

    private void loadFreskDeck() {

        int count = 0;

        for (int x = 0; x < 4; x++){

            for (int i = 1; i < 14; i++){

                if (i == 1){
                    deck[count] = new Card(suit[x], "ACE");
                } else if (i == 11){
                    deck[count] = new Card(suit[x], "JACK");
                } else if (i == 12) {
                    deck[count] = new Card(suit[x], "QUEEN");
                } else if (i == 13) {
                    deck[count] = new Card(suit[x], "KING");
                } else {
                    deck[count] = new Card(suit[x], Integer.toString(i).toUpperCase());
                }
                count++;
            }
        }
    }

    public boolean isCardUsed(int value) {

        if (usedCards.contains(value)){
            return true;
        } else {
            return false;
        }

    }

    public Card getCardAt(int randomNum) {
        return deck[randomNum];
    }
}
