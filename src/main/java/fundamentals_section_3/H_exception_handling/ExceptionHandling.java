package main.java.fundamentals_section_3.H_exception_handling;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class ExceptionHandling {

    public static void main(String[] args) {

        // try catch statement - if an AruthmeticException occurs in the "try" section - it will be
        // handled gracefully by the "catch" section
        try {
            int result = divide(30, 5);
            System.out.println("result = " + result);
            int errorResult = divide(4, 0);
            System.out.println("THIS WONT PRINT!");
        } catch (ArithmeticException ae){
            System.out.println("there was an exception - division by zero");
        }

        System.out.println("all done!");

        // demonstrate throwing a custom exception
        try {
            throwCustomException();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

    }

    // simple method to demonstrate division by zero error
    // if "b" is zero an ArithmeticException will be generated
    // and that exception will be thrown back to the calling method
    public static int divide(int a, int b) throws ArithmeticException {

        return a / b;

    }

    // demonstration of manually throwing an exception, and using a custom exception
    public static void throwCustomException() throws CustomException {
        throw new CustomException("I am a custom exception");
    }

}
