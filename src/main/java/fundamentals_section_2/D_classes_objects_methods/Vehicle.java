package main.java.fundamentals_section_2.D_classes_objects_methods;

import main.java.fundamentals_section_3.G_interfaces.Automobile;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public abstract class Vehicle implements Automobile{

    // these variables are called "instance variables" they describe an object
    // every object that is created from this class will have it's own copy of these variables
    public String make;
    public String model;
    public int year;
    public String color;
    public static int numCarsCreated;

    // constructor #1 - default - takes no arguments
    public Vehicle(){
        numCarsCreated++;
    }

    // constructor #2 - overloaded constructor - takes 4 arguments (aka parameters)
    public Vehicle(String make, String model, int year, String color){
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        numCarsCreated++;
    }

    // a method that changes a car's color to the "String color" provided as an argument
    public void paint(String color){
        System.out.println("You're painting your vehicle " + color);
        this.color = color;
    }

    public void start(){
        System.out.println("the Vehicle is starting");
    }

    public void stop(){
        System.out.println("the Vehicle is stop");
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
