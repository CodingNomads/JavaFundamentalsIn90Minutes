package main.java.fundamentals_section_1.A_datatypes_operators;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Casting {

    public static void main(String[] args) {

        // declare a variable "a" of type int
        int a = 10;

        // declare a variable "b" of type double and give it the value of (int) "a"
        // this works implicitly because it is a "widening conversion" (int -> double)
        double b = a;

        // declare a double "c" and give it the value of "b" (also a double
        double c = 1.23;

        // declare an int "d" and give it the value of "c"
        // since this is a "narrowing conversion" (a double -> int) we must
        // explicitly cast (double) "c" to that of type int using parenthesis
        int d = (int) c;

        // print out "d" - notice that the decimal value (.23) is missing - information was lost
        System.out.println(d);

    }

}
