package main.java.fundamentals_section_1.A_datatypes_operators;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Operators {

    public static void main(String[] args) {

        // regular operators (add, subtract, multiply et)
        // + - / * %
        int i = 10;
        int x = 20;
        int z = i + x;
        int modVal = 2 % 2;
        System.out.println(modVal);

        //relational operators (less than, greater than, equal to etc)
        // <, <=, ==, >=, >
        if (i == 20){
            System.out.println("i is less than 20");
        }

        // LOGICAL OPERATORS

        // && (AND) if this is true "AND" that is also true - do something
        // short-circuit is used by doubling the "&" symbol - it doesn'tc heck second condition if the first fails
        if (i >= 10 && i <= 20){
            System.out.println("i is between 10 and 20");
        }

        // || (OR) if this is true "OR" that is also true - do something
        // short-circuit is used by doubling the "|" symbol - it doesn'tc heck second condition if the first is true
        if (i == 10 ||  x == 20){
            System.out.println("i equals 10 OR x = 20");
        }

        // ! (NOT) - the opposite - if this is "NOT" equal to - do something
        if (i != 20){
            System.out.println("i does not equal 20");
        }

        // ^ (XOR) - exclusive OR - one can be true, or the other can be true, but not both
        if (i == 10 ^ x == 20){
            System.out.println("i equals 10 or x = 20 - but both CANNOT be true");
        }

    }

}
