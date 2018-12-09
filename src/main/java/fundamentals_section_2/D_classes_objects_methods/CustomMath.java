package main.java.fundamentals_section_2.D_classes_objects_methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class CustomMath {

    // we make these methods static because they are outside the realm of objects
    // they do not modify any instance variables on any one particular object
    // they just are what they are - and they do not require objects - they're static
    public static int multiply(int a, int b){
        return a * b;
    }

    // to call these methods from another class we can just use the class name and then the method name
    // for instance, "int x = CustomMath.divide(6, 2);" - x now equals 3
    public static int divide(int a, int b){
        return a / b;
    }

}
