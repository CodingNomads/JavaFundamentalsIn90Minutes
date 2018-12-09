package main.java.fundamentals_section_1.B_flow_control;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class ForEachLoops {

    public static void main(String[] args) {

        int[] numbers = new int[10];

        // traditional for loop
        /*
            for (initialization; boolean condition; counter)
         */
        for(int i = 0; i < numbers.length; i++){
            // here, "i" is an index that can be used to get things out of the numbers[] (numbers array)
            numbers[i] = i * 3;
        }

        // for each loop - will touch every element in a Collection
        /*
            for (datatype variableName : Collection)
         */
        for (int i : numbers){
            // here, "i" is the actual value - not the index as it is in the traditional for loop above
            System.out.println(i);
        }

        // FYI _ you can nest these loops within each other as many times as you like
        // just watch out because nested loops grow exponentially in complexity

    }
/*=

0 -> 456
1 -> 123
2 -> 90
3 -> 76
    */
}
