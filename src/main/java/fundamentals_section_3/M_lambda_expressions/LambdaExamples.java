package main.java.fundamentals_section_3.M_lambda_expressions;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class LambdaExamples {

    public static void main(String[] args) {
        // call method that demonstrates in-line Lambda expression
        inlineExample();

        // call method that demonstrates block Lambda expression
        blockLambdaExample();
    }

    public static void inlineExample() {

        // here we are defining the body of the abstract method "test" in the NumericTest interface
        // since this is just one line of code we can do it all on one line and don't need curly brackets
        NumericTest isEven = (n) -> (n % 2) == 0;

        // here we are using the newly defined Lambda expression - output will be false
        System.out.println(isEven.test(5));

        // here we are defining the body of the abstract method "test" again in the NumericTest interface
        // since this is just one line of code we can do it all on one line and don't need curly brackets
        NumericTest isNegative = (n) -> (n < 0);

        // here we are using the newly defined Lambda expression - output will be true
        System.out.println(isNegative.test(-5));

        // here we are defining the body of the abstract method "test" again in the NumericTest interface
        // since this is just one line of code we can do it all on one line and don't need curly brackets
        NumericTest isPositive = (n) -> (n > 0);

        // here we are using the newly defined Lambda expression
        System.out.println(isPositive.test(-4));
        System.out.println(isPositive.test(4));
    }


    // demonstration of block Lambda expression
    public static void blockLambdaExample () {

        // Block lambda to reverse string - since it's multiple lines of code it requires curly brackets
        // here we are defining the body of the "strFunc" abstract method in the StringLambdaInterface
        StringLambda reverse = (str) -> {
            String result = "";

            for(int i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        // Odemonstrating using of lambda
        System.out.println(reverse.strFunc("Lambda Demo"));
    }
}

@FunctionalInterface
interface NumericTest {
    boolean test(int n);
}

@FunctionalInterface
interface StringLambda {
    String strFunc(String str);
}