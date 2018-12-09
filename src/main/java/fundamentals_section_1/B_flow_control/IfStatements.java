package main.java.fundamentals_section_1.B_flow_control;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class IfStatements {

    public static void main(String[] args) {

        int i = 4;

        // IF the condition in the parenthesis is true - do something
        if (i > 5){
            System.out.println(i);
            int q = 10;
            System.out.println(i + " is greater than 5");
        } else if (i > 3) { // ELSE IF this condition is true - do something
            System.out.println(i + " is greater than 3");
        } else { // OTHERWIDE - do this
            System.out.println(i + " is less than or equal to 3");
        }

        // FYI _ you can nest these if and if/else statements within each other as many times as you like

    }

}
