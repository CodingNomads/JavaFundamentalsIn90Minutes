package main.java.blackjack.object_models;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a simple POJO (plain old Java object) that represents
 * a card player
 *
 * Created by ryandesmond - https://codingnomads.co
 */
public class CardPlayer {

    // instance variable to hold player's name
    private String name;
    // instance variable to hold player's stack value
    private int stackValue;
    // instance variable to hold player's bet
    private int bet;
    // // instance variable to hold player's hand of cards
    private ArrayList<Card> hand = new ArrayList();

    // default constructor that initializes a new player
    public CardPlayer() {
        // call method that prompts user for name and budget
        initializeNewUser();
    }

    // overloaded constructor that takes in a name and stack value
    // we use this constructor when creating the computer player
    public CardPlayer(String name, int stackValue) {
        this.name = name;
        this.stackValue = stackValue;
    }

    // simple getter for name
    public String getName() {
        return name;
    }

    // simple setter for name
    public void setName(String name) {
        this.name = name;
    }

    // simple getter for stack value
    public int getStackValue() {
        return stackValue;
    }

    // simple setter for stack value
    public void setStackValue(int stackValue) {
        this.stackValue = stackValue;
    }

    // simple getter for bet
    public int getBet() {
        return bet;
    }

    // simple setter for bet
    public void setBet(int bet) {
        this.bet = bet;
    }

    // simple getter for hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // simple setter for hand
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * This method initializes a new player - it prompts the user to
     * give us their name and the amount of money they'd like to start with
     */
    private void initializeNewUser() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, and welcome to BlackJack! My name is Computer, what is you name?");
        this.name = scanner.next();

        System.out.println("Thanks, " + this.name + "! How much money would you like to start with?");
        this.stackValue = scanner.nextInt();

    }
}
