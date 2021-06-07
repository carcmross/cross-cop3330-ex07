package base;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 first_name last_name
 */

/*
 * When working in a global environment, you’ll have to present information in both metric and Imperial units.
 * And you’ll need to know when to do the conversion to ensure the most accurate results.
 *
 * Create a program that calculates the area of a room. Prompt the user for the length and width of the room in feet.
 * Then display the area in both square feet and square meters.
 * Example Output
 *
 * What is the length of the room in feet? 15
 * What is the width of the room in feet? 20
 * You entered dimensions of 15 feet by 20 feet.
 * The area is
 * 300 square feet
 * 27.871 square meters
 *
 * The formula for this conversion is m2 = f2 × 0.09290304
 * Constraints
 *
 *     Keep the calculations separate from the output.
 *     Use a constant to hold the conversion factor.
 *
 * Challenges
 *
 *     Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
 *     Create a new version of the program that allows you to choose feet or meters for your inputs.
 *     Implement this program as a GUI program that automatically updates the values when any value changes.
 *
 */

public class App {
    static Scanner in = new Scanner(System.in);
    static final double CONVERSION_FACTOR = 0.09290304;

    public static void main(String[] args) {
        App myApp = new App();
        String length = myApp.getLength();
        String width = myApp.getWidth();
        myApp.confirmation(length, width);
        String areaInFeet = myApp.calcAreaInFeet(length, width);
        String areaInMeters = myApp.convertToMeters(areaInFeet, CONVERSION_FACTOR);
        String outputString = myApp.generateOutput(areaInFeet, areaInMeters);
        myApp.printOutput(outputString);
    }

    private void printOutput(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutput(String areaInFeet, String areaInMeters) {
        return "The area is\n" + areaInFeet + " square feet\n" + areaInMeters + " square meters";
    }

    private String getLength() {
        System.out.print("What is the length of the room in feet? ");
        String length = in.nextLine();
        return length;
    }

    private String getWidth() {
        System.out.print("What is the width of the room in feet? ");
        String width = in.nextLine();
        return width;
    }

    private String calcAreaInFeet(String length, String width) {
        int area = Integer.parseInt(length) * Integer.parseInt(width);
        return Integer.toString(area);
    }

    private void confirmation(String length, String width) {
        System.out.println("You entered dimensions of " + length + " feet by " + width + " feet.");
    }

    private String convertToMeters(String areaInFeet, final double CONVERSION_FACTOR) {
        double areaInMeters = Integer.parseInt(areaInFeet) * CONVERSION_FACTOR;
        // Rounds to the thousandths place
        areaInMeters = Math.ceil(areaInMeters * 1000) / 1000;
        return String.valueOf(areaInMeters);
    }
}
