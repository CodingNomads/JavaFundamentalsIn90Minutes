package main.java.fundamentals_section_3.G_interfaces;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
// note the keyword "interface" below in the place of "class"
public interface Automobile {

    // these are called "abstract" methods - they have no body
    public void accelerate(int mph);
    public void decelerate(int mph);

}
