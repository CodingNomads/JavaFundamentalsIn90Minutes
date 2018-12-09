package main.java.fundamentals_section_2.E_object_oriented_programming;

import main.java.fundamentals_section_2.D_classes_objects_methods.Vehicle;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Sedan extends Vehicle {

    // these instance variables are what make Sedan different than Vehicle
    boolean hasSunRoof;
    int numDoors;

    // demonstration of polymorphism - implementing the abstract methods from the Automobile interface
    @Override
    public void accelerate(int mph) {
        System.out.println("accelerating sedan");
    }

    // demonstration of polymorphism - implementing the abstract methods from the Automobile interface
    @Override
    public void decelerate(int mph) {
        System.out.println("decelerating sedan");
    }

}
