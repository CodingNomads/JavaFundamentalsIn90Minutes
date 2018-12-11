package main.java.blackjack.controller;

import main.java.blackjack.object_models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class BlackJackGame extends Game implements CardGame {

    /**
     * Primary controller method that manages the BlackJack game
     */
    public void play() {

        // set variables in parent "Game" class
        setName("BlackJack");
        setBasicRules("The player closest to 21 without going over wins");

        // create new player for computer
        CardPlayer computer = new CardPlayer("Computer", 10000);
        // create new player for user - use overloading constructor which will prompt them
        // for name and stackValue
        CardPlayer user = new CardPlayer();

        // declare Deck variable - we'll intialize it freshly inside the loop below on each loop
        Deck deck;

        // do-while loop to keep looping while player wants to play more games (and has money left)
        do {
            // initialize new Deck (which loads a fresh deck of Cards into the Deck)
            deck = new Deck();

            // print out static variable "freshDecksLoaded" to tell the user which game this is
            System.out.println("\nGame #" + Deck.getFreshDecksLoaded());

            // print out some fun ascii art
            printAsciiArt();

            // call method to take in user bets
            handleBets(user);

            // call method to deal the first set of two cards each to user and computer
            dealInitialCards(user, computer, deck);

            // while the user wants more cards, keep looping
            while(true){
                // call checkForHit() method asking if the user wants more cards
                if(checkForHit(user)){
                    // if true, deal the user another card from the deck
                    deal(user, deck);
                } else {
                    // if false, break out of this loop
                    break;
                }
            }

            // while computer requires more cards (score < 16) loop
            while(true){
                // call checkForHit which will return true if computer score is <= 16
                if(checkForHit(computer)){
                    // if true, deal computer another card from the deck
                    deal(computer, deck);
                } else {
                    // otherwise exit this loop
                    break;
                }
            }

            // call method to score the user and computer hands
            scoreHands(user, computer);

            // call method to check whether the user wants to, and is able, to continue playing
        } while (continuePlaying(user, computer));

        // exit message when user decides to quit playing or has run out of money
        System.out.println("\nThanks again for playing BlackJack with me! You're walking awat with $" + user.getStackValue() + " in chips.");

        // talk a little smack if they lost all their cash :)
        if (user.getStackValue() == 0){
            System.out.println("I thought you were a pro! Where'd all your money go?!");
        }

        // say goodbye
        System.out.println("Goodbye.");
    }

    /**
     * This method determines whether or not a user wants to, and is able to, continue playing
     * blackjack. If they are out of money, this method automatically returns false
     *
     * @param - method takes CardPlayer user
     * @param - method takes CardPlayer computer
     * @return - returns true if the user would like to, and is able to, continue playing
     */
    private boolean continuePlaying(CardPlayer user, CardPlayer computer) {

        // initialize new Scanner to take in user input
        Scanner scanner = new Scanner(System.in);

        // if user's stackValue is less than 1 - they're outta cash - return false
        if (user.getStackValue() < 1){
            System.out.println("\nSorry pal, you're outta cash. Time to go. Goodbye.");
            return false;
        }

        // let user know how many games they've played and ask if they want to play another
        System.out.println("That was game #" + Deck.getFreshDecksLoaded() + ", would you like to play another game? " +
                "Enter \'y\' for YES and \'n\' for NO");

        // take in user input and assign to variable "anotherGame"
        String anotherGame = scanner.next();

        // if the user responded with "y" (YES)
        if (anotherGame.equalsIgnoreCase("y")){
            // clear the cards in the user's hand
            user.getHand().clear();
            // clear the cards in the computer's hand
            computer.getHand().clear();
            // return true
            return true;
        } else {
            // otherwise, return false
            return false;
        }

    }

    /**
     *This method scores the hands of the user and computer respectively
     * It prints out the scores to the console for the user to review
     *
     * @param CardPlayer user
     * @param CardPlayer computer
     */
    private void scoreHands(CardPlayer user, CardPlayer computer) {

        // call method to analyze the hand of the computer
        int computerScore = analyzeHand(computer);
        // call method to analyze the hand of the computer
        int userScore = analyzeHand(user);

        // computer the difference between the computer score and 21
        int computerDiff = 21 - computerScore;
        // computer the difference between the user score and 21
        int userDiff = 21 - userScore;

        // get the string that represents the computer's current hand - we'll use this a bit
        // in the coming if/else ladder
        String computerHand = computer.getHand().toString();
        // initialize empty "output" variable which we'll populate in the if/else ladder
        String output = "";

        if (computerScore == 21 && userScore == 21){  // if user tied the computer
            // print out that the user tied
            output = "\nYOU TIED!! I (Computer) scored " + computerScore + " with " + computerHand;
            // update the user's stackValue - subtract half their bet
            user.setStackValue(user.getStackValue() - (user.getBet() / 2));
            // print the user's chip balance
            printUserChipBalance(user);
        } else if (computerScore == 21){ // if computer got 21 and user did not
            // print out that the user lost
            output = "\nYOU LOSE!! I (Computer) landed 21 with " + computerHand;
            // update the user's stack value - subtract their bet
            user.setStackValue(user.getStackValue() - user.getBet());
            // print the user's chip balance
            printUserChipBalance(user);
        } else if (userScore > 21) { // if user busted
            // print out that the user lost
            output = "\nYOU BUSTED!! Sorry about that.";
            // update the user's stack value - subtract their bet
            user.setStackValue(user.getStackValue() - user.getBet());
            // print the user's chip balance
            printUserChipBalance(user);
        } else if (userDiff > computerDiff && computerDiff >= 0){ // if computer's score is closer to 21
            output = "\nYOU LOSE! I (Computer) scored " + computerScore + " with " + computerHand;
            user.setStackValue(user.getStackValue() - user.getBet());
            printUserChipBalance(user);
        } else if (userDiff < computerDiff){ // if user's score is closer to 21
            output = "\nYOU WIN!! I (Computer) score " + computerScore + " with " + computerHand;
            user.setStackValue(user.getStackValue() + (user.getBet() * 3));
            printUserChipBalance(user);
        } else if (computerScore > 21) { // if computer busted
            output = "\nYOU WIN!! I (Computer) busted  with " + computerHand;
            user.setStackValue(user.getStackValue() + (user.getBet() * 3));
            printUserChipBalance(user);
        }

        // print out the output string
        System.out.println(output);
        // write output to file (just to demonstrate I/O)
        writeOutputToFile(output);

    }

    /**
     * This method writes the results of each game to a specified file on the hard drive
     * @param output - the results to write to the file
     */
    private void writeOutputToFile(String output) {

        // use try-with-resources to instantiate a BufferedWriter (Character Stream)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/ryandesmond/Documents/webinar/blackjack_results.txt", true))){
            // write the name of the game to the file
            bw.write("\n\n" + getName());
            // write the basic rules of the game to a file
            bw.write("\n" + getBasicRules());
            // write the game results to the file
            bw.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method simply prints the user's chip balance to the console
     *
     * @param user - the user for whom we should print the chip balance
     */
    private void printUserChipBalance(CardPlayer user) {
        System.out.println("You've currently got $" + user.getStackValue() + " worth of chips");
    }

    /**
     * This method checks whether the user, or the computer, would like another card
     *
     * @param user - the user for whom to ask if they want another card
     * @return - boolean - true for another card - false for no more cards
     */
    private boolean checkForHit(CardPlayer user) {

        // initialize a new scanner to take in user input
        Scanner scanner = new Scanner(System.in);

        // get the current score of the user
        int currentScore = analyzeHand(user);

        // if the user passed into this method is NOT the computer
        if(!user.getName().equalsIgnoreCase("Computer")){
            // let the user know how much money they have left
            System.out.println("\n ** The current score of your hand is " + currentScore + "**");
            // ask the user if they'd like another card
            System.out.println("\n Would you like another card? Press \'y\' for YES and \'n\' for NO");

            // get the user's response
            String response = scanner.next();

            // check the user's response
            if (response.equalsIgnoreCase("y")){
                // if they want another card - return true
                return true;
            } else {
                // otherwise, return false
                return false;
            }
        } else { // if the user passed into this method is the computer
            if (currentScore <= 16){
                // if the computer's score is less than or equal to 16 - give the computer another card
                return true;
            } else {
                // otherwise, return false
                return false;
            }
        }

    }

    /**
     * This method is used to determine the score of a player's hand
     *
     * @param user - the player to score
     * @return int - the score of the player's hand
     */
    private int analyzeHand(CardPlayer user) {

        // intialize default score of 0
        int currentScore = 0;

        // use for-each loop to iterate through each of the player's cards
        for (Card c : user.getHand()){
            // add score of card to currentScore
            currentScore += c.getScoreValue();
        }

        // when done iterating, return score
        return currentScore;

    }

    /**
     * This method is used to deal the initial cards to both the user and the computer
     *
     * @param user - the User to deal cards to
     * @param computer - the Computer to deal cards to
     * @param deck - the deck from which to deal cards
     */
    private void dealInitialCards(CardPlayer user, CardPlayer computer, Deck deck) {

        // deal a card to the user from the deck
        deal(user, deck);
        // deal a card to the computer from the deck
        deal(computer, deck);
        // deal a card to the user from the deck
        deal(user, deck);
        // deal a card to the computer from the deck
        deal(computer, deck);

        // print out the user's cards and the computer's first card
        System.out.println("\n ---------------------------------------------------");
        System.out.println("Your first card is: " + user.getHand().get(0).customToString());
        System.out.println("Your second card is: " + user.getHand().get(1).customToString());
        System.out.println("---------------------------------------------------");
        System.out.println("My (computer) first card is: " + computer.getHand().get(0).customToString());
        System.out.println("My (computer) second card is FACE DOWN!");
        System.out.println("---------------------------------------------------");

    }

    /**
     * This method simply prints some fun ascii art to the console
     */
    private void printAsciiArt() {

        System.out.println("\n----------------------------------------");
        System.out.println("     Let's play some BlackJack!");
        System.out.println("                            _");
        System.out.println("    ,'`.    _  _    /\\    _(_)_");
        System.out.println("   (_,._)  ( `' )  <  >  (_)+(_)");
        System.out.println("     /\\     `.,'    \\/      |");
        System.out.println("----------------------------------------");
        System.out.println();

    }

    /**
     * This method implements the deal() method in the CardGame interface
     *
     * @param player - the player for which to deal a card
     * @param deck - the deck from which to deal from
     */
    @Override
    public void deal(CardPlayer player, Deck deck) {

        // get a random number from getRandomCard() method
        // the getRandomCard() method will check to make sure that the random
        // number returned has not already been used - (make sure the card is available)
        int randomNum = getRandomCard(deck);
        // get a card out of the deck array at the specific index
        Card card = deck.getCardAt(randomNum);
        // add this new card to the players hand
        player.getHand().add(card);
    }

    /**
     * This method gets a random number between 0 and 51 (52 inclusively to cover the deck of cards)
     * It then checks to make sure this random number has not already been used
     * Once it finds a number that has not already been used, it adds that number to the
     * usedCards ArrayList in the deck object
     *
     * @param deck - the deck from which to check if a card has already been used
     * @return - a random (unused) number between 0 and 51 (inclusively)
     */
    private int getRandomCard(Deck deck) {

        // instantiate new Random object (provided by Java)
        Random random = new Random();

        // get a random number between 0 and 51 (inclusively)
        int n = random.nextInt(51) + 0;

        // check if that number has already been used, if so loop till we find an unused number
        while(deck.isCardUsed(n)){
            // get a new random number and loop
            n = random.nextInt(51) + 0;
        }

        // once we exit loop (if we had to enter in the first place) add the new random num
        // to the Arraylist of "usedCards"
        deck.getUsedCards().add(n);
        // return the random num
        return n;

    }

    /**
     * This method handles taking in the user bet
     *
     * @param player - the player that needs to bet
     */
    @Override
    public void handleBets(CardPlayer player) {

        // instantiate new scanner to take in user input from the console
        Scanner scanner = new Scanner(System.in);
        // prompt user
        System.out.println("\nHow much would you like to bet on this game?");
        System.out.println("You're currently holding $" + player.getStackValue() + " worth of chips");

        // get the bet amount from the user
        // without exception handling added to this line there will be an exception generated
        // if the user enters anything other than an int - I skipped solely for time saving purposes
        // in the live video - and don't want to change it too much now so the source still
        // matches what we did in the video
        int bet = scanner.nextInt();

        // if the bet amount the user entered is less than or equal to their current stack value
        if (bet <= player.getStackValue()){

            // check to see if they're going all in
            if (bet == player.getStackValue()){
                // if so, acknowledge that they have gone all in
                System.out.println("Goin' \"all in\", eh?");
            }
            // set the bet on the player object
            player.setBet(bet);

        } else { // otherwise, the bet they entered is above their stack value

            // loop until they enter a value less than or equal to their current stack value
            do {
                System.out.println("\nSorry pal, you can't bet more than you got! Please bet something less than $" + player.getStackValue());
                System.out.println("\nHow much would you like to bet?");
                // without exception handling added to this line there will be an exception generated
                // if the user enters anything other than an int - I skipped solely for time saving purposes
                // in the live video - and don't want to change it too much now so the source still
                // matches what we did in the video
                bet = scanner.nextInt();
            } while (bet > player.getStackValue());

            // once the player has entered a valid bet - set that bet amount on the player object
            player.setBet(bet);
        }
    }
}
// end of class
