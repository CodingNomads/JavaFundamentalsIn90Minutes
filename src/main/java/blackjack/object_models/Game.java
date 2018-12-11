package main.java.blackjack.object_models;

/**
 * Simple POJO (plain old Java object) that represents a Game
 *
 * Created by ryandesmond - https://codingnomads.co
 */
public class Game {

    // instance variable to hold the Game's name
    private String name;
    // instance variable to hold the Game's basic rules
    private String basicRules;

    // simple getters and setters below here

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasicRules() {
        return basicRules;
    }

    public void setBasicRules(String basicRules) {
        this.basicRules = basicRules;
    }
}
