package main.java.fundamentals_section_3.K_generics;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
// notice how this class is not generic but it holds a generic method - this is fine
public class GenericMethods {

    // note how we must define the generic type of "E" in diamond brackets before the return turn type
    public <E extends Number> double multiply(E a, E b){
        return a.doubleValue() * b.doubleValue();
    }

}
