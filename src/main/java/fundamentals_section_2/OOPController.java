package main.java.fundamentals_section_2;

import main.java.fundamentals_section_2.D_classes_objects_methods.CustomMath;
import main.java.fundamentals_section_2.D_classes_objects_methods.Vehicle;
import main.java.fundamentals_section_2.E_object_oriented_programming.Motorcycle;
import main.java.fundamentals_section_2.E_object_oriented_programming.Sedan;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class OOPController {

    public static void main(String[] args) {

        Motorcycle bike = new Motorcycle();
        System.out.println(bike.color);

        bike.paint("Yellow");

        Sedan honda = new Sedan();
        honda.start();

        bike.start();
        Vehicle myCar = new Sedan();

        Vehicle thatCar = new Motorcycle();

        myCar.accelerate(10);
        bike.accelerate(20);


        Vehicle yourCar = new Sedan();
        yourCar.color = "Red";
        yourCar.make = "Tesla";
        yourCar.model = "Model 3";
        yourCar.year = 2018;

        System.out.println(myCar.toString());
        System.out.println(yourCar.toString());

        myCar.paint("Green");
        System.out.println(myCar.toString());

        System.out.println(myCar.numCarsCreated);
        System.out.println(yourCar.numCarsCreated);

        demonstrateCustomMathMethods();
    }

    private static void demonstrateCustomMathMethods() {

        int result = CustomMath.multiply(56, 876);
        System.out.println(result);

    }

}
