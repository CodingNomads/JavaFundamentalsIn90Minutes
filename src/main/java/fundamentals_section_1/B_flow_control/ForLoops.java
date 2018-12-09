package main.java.fundamentals_section_1.B_flow_control;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class ForLoops {

    public static void main(String[] args) {

        // traditional for loop
        /*
            for (initialization; boolean condition; counter)
         */
        for (int i = 10; i >= 0; i--){
            System.out.println(i);
        }

        // FYI _ you can nest these loops within each other as many times as you like
        // just watch out because nested loops grow exponentially in complexity

    }
}
