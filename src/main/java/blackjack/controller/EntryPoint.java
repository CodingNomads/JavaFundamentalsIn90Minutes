package main.java.blackjack.controller;

import java.util.Scanner;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class EntryPoint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What game would you like to play?");
        System.out.println("Enter 1 for BlackJack, 2 for 5 Card Draw, 3 for ....");

        int userChoice = scanner.nextInt();

        if (userChoice == 1) {
            BlackJackGame blackJackGame = new BlackJackGame();
            blackJackGame.play();
        } else if (userChoice == 2){
            // create an object of the 5 card draw poker game
            // play
        } // etc
    }

}
