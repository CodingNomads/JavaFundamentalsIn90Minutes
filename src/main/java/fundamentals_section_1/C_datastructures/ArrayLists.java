package main.java.fundamentals_section_1.C_datastructures;

import java.util.ArrayList;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class ArrayLists {

    public static void main(String[] args) {

        // declare an ArrayList (which is Generic) of type "String"
        // ArrayLists are nice because they have a bunch of helpful methods
        // and they also grow and shrink as needed - no need to declare size
        // as we must with traditional arrays
        ArrayList<String> words = new ArrayList();


        // add elements to ArrayList
        words.add("hello");
        words.add("world");
        words.add("I love Java!");

        // iterate over all elements in ArrayList using for-each loop
        for (String s : words){
            System.out.println(s);
        }

        // demonstrating one of the many useful methods available to Arraylists
        if (words.contains("world")){
            System.out.println("I think you are saying hello world");
        }

    }

}
