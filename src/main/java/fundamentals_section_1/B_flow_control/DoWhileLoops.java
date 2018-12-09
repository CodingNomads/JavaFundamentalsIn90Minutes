package main.java.fundamentals_section_1.B_flow_control;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class DoWhileLoops {

    public static void main(String[] args) {

        int i = 10;

        // start looping - check boolean condition AFTER the first loop
        do {
            System.out.println(i);
            // be sure to update your counter one ach leep in order to get out of the loop when needed
            i--;
        } while (i >= 0);
        // ^ continue looping while i is >= 0

    }

    // FYI _ you can nest these loops within each other as many times as you like
    // just watch out because nested loops grow exponentially in complexity

}
