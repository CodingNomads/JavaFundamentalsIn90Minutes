package main.java.blackjack.object_models;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public interface CardGame {

    public void deal(CardPlayer player, Deck deck);
    public void handleBets(CardPlayer player);

}
