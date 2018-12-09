package main.java.fundamentals_section_2.E_object_oriented_programming;

import main.java.fundamentals_section_2.D_classes_objects_methods.Vehicle;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
// this class inherits from Vehicle - the keyword we use is "extends"
public class Motorcycle extends Vehicle {

    // these instance variables are what make Motorcycle different than Vehicle
    int cc;
    boolean hasDoubleSeat;

    // constructor #1
    public Motorcycle() {
        make = "Kawasaki";
        model = " Fast Bike";
        color = "Black";
        year = 2016;
    }

    // constructor #2
    public Motorcycle(int cc, boolean hasDoubleSeat) {
        this.cc = cc;
        this.hasDoubleSeat = hasDoubleSeat;
        make = "Kawasaki";
        model = " Fast Bike";
        color = "Black";
        year = 2016;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public boolean isHasDoubleSeat() {
        return hasDoubleSeat;
    }

    public void setHasDoubleSeat(boolean hasDoubleSeat) {
        this.hasDoubleSeat = hasDoubleSeat;
    }

    // demonstration of polymorphism - overriding the behavior the start method in the parent class
    @Override
    public void start(){
        System.out.println("motorcycle starting");
    }

    // demonstration of polymorphism - implementing the abstract methods from the Automobile interface
    @Override
    public void accelerate(int mph) {
        System.out.println("accelerating motorcycle");
    }

    // demonstration of polymorphism - implementing the abstract methods from the Automobile interface
    @Override
    public void decelerate(int mph) {
        System.out.println("decelerating motorcycle");
    }
}
