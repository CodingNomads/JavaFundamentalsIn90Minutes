package main.java.fundamentals_section_3.H_exception_handling;

import main.java.fundamentals_section_2.D_classes_objects_methods.CustomMath;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class CustomException extends Exception {

    // constructor that takes in a message (that can explain the error)
    public CustomException(String msg){
        // call the constructor in the parent class and pass the message
        super(msg);
    }

}
