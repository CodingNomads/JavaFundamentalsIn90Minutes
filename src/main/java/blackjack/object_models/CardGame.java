package main.java.blackjack.object_models;

/**
 * Simple interface to be implemented by all card games
 *
 * Created by ryandesmond - https://codingnomads.co
 */
public interface CardGame {

    // all card games will need a deal() method that takes a player
    // to deal to, and a deck to deal from
    public void deal(CardPlayer player, Deck deck);

    // all card games will need a handleBets() method to handle bets
    // this method requires a CardPlayer that is doing the betting
    public void handleBets(CardPlayer player);

}
