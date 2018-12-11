package main.java.blackjack.controller;

import java.util.Scanner;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class EntryPoint {

    /**
     * This main() method is the entry point for the application
     *
     * @param args
     */
    public static void main(String[] args) {

        // create an object of the BlackJackGame class
        BlackJackGame blackJackGame = new BlackJackGame();
        // invoked the play() method in BlackJackGame
        blackJackGame.play();

    }

}
