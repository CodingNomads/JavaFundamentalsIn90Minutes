package main.java.fundamentals_section_3.K_generics;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
// to create a generic class add "<E>" (E can be any letter) to the class signature
public class GenericClass<E> {

    // this is a generic data type
    E val;

    // generic constructor - when an object of this class is created the programmer must indicate what
    // the generic data type is for instance, "GenericClass<String> genStr = new GenericClass()"
    // when that is compiled, all instances of "E" in this class will be replaced with "String"
    public GenericClass(E val) {
        this.val = val;
    }

    public void printMe(){
        System.out.println(val);
    }


}
