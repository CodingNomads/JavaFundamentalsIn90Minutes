package main.java.fundamentals_section_3.I_input_output;

import java.io.*;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class InputOutput {

    public static void main(String[] args) {

        // byte streams - raw data, numbers, images etc
        // you'll always see "inputStream" or "outputStream" in the class name of a byte stream
        try (FileInputStream fi = new FileInputStream("/Users/ryandesmond/Documents/webinar/file.txt")) {

            int val;

            System.out.println("Output from byte stream - FileInputStream:");
            while ((val = fi.read()) != -1) {
                System.out.print(val);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // character streams - human language
        // you'll always see "reader" or "writer" in the class name of a character stream
        try (FileReader fi = new FileReader("/Users/ryandesmond/Documents/webinar/file.txt")) {

            int val;
            System.out.println("Output from character stream - FileReader:");
            while ((val = fi.read()) != -1) {
                System.out.print(val);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // BufferedReader - shows an example of using a buffer to read lines of characters at once
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/ryandesmond/Documents/webinar/file.txt"))) {

            String val;

            System.out.println("Output from a buffered character stream - BufferedFileReader:");
            while (!(val = br.readLine()).isEmpty()) {
                System.out.print(val);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
