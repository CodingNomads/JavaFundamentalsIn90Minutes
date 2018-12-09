package main.java.fundamentals_section_1.B_flow_control;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class WhileLoops {

    public static void main(String[] args) {

        int i = 10;

        // while the boolean condition inside the parenthesis is true - do something
        while (i >= 0){
            System.out.println(i);
            // be sure to update your counter!
            i--;
        }

        // FYI _ you can nest these loops within each other as many times as you like
        // just watch out because nested loops grow exponentially in complexity

    }
}
