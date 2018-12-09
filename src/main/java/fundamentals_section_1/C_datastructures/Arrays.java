package main.java.fundamentals_section_1.C_datastructures;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Arrays {

    public static void main(String[] args) {

        // declare an array of type double - with an initial size of 4
        // when initializing arrays we MUST declare the size of the array
        // arrays do not shrink or grow dynamically - to make an array bigger
        // you must initialize a new, larger array and then copy every value over
        double[] doubleNums = new double[4];

        // we can interact with elements in the array, as well as add and delete elements
        // in the array by using "indexes" -
        // the line below says, "please set the element at the initial index of the doubleNums array to 456.1
        // all arrays start counting from ZERO
        doubleNums[0] = 456.1;
        doubleNums[1] = 123.2;
        doubleNums[2] = 90.3;
        doubleNums[3] = 76.4;


        for (double n : doubleNums){
            System.out.println(n);
        }

        // print out the element at the index of 2 (the third element in the array)
        System.out.println(doubleNums[2]);

        // print out the length of this array
        System.out.println("The length of doubleNums is " + doubleNums.length);

        // uncomment the line below and run to see an IndexArrayOutOfBoundsException occur
        //doubleNums[56] = 234;

    }

}

/*=

0 -> 456
1 -> 123
2 -> 90
3 -> 76
    */

