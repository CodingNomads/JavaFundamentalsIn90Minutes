package main.java.fundamentals_section_3.K_generics;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class GenericsController {

    public static void main(String[] args) {

        // demonstrate using Generic methods
        GenericMethods gMeth = new GenericMethods();
        double val = gMeth.multiply(10.2, 32.567);
        System.out.println(val);

        // demonstrate using Generic methods
        GenericMethods gMeth2 = new GenericMethods();
        double val2 = gMeth.multiply(2f, 4f);
        System.out.println(val2);

        // demonstrate using Generic class
        GenericClass<Integer> gInt = new GenericClass(10);
        gInt.printMe();

        // demonstrate using Generic class
        GenericClass<Double> dInt = new GenericClass(10.123);
        dInt.printMe();

        // demonstrate using Generic class
        GenericClass<Long> lInt = new GenericClass(100089797l);
        lInt.printMe();



    }
}
