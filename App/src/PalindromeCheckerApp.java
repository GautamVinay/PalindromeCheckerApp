/**
 * PalindromeCheckerApp
 * Goal: Check whether a string is a palindrome by reversing it.
 * Data Structure Used: String
 */

public class PalindromeCheckerApp {

    // Application constants
    static final String APP_NAME = "PalindromeChecker";
    static final String APP_VERSION = "Version 1.0";

    public static void main(String[] args) {

        // Display welcome message
        System.out.println("=================================");
        System.out.println("      Welcome to " + APP_NAME + " " + APP_VERSION);
        System.out.println("=================================");
        System.out.println("This application checks whether a word is a palindrome.");
        System.out.println();

        // Hardcoded String (String Literal)
        String original = "madam";

        // Reverse string using for loop
        String reversed = "";

        // Loop iterates from last character to first
        for (int i = original.length() - 1; i >= 0; i--) {

            // String concatenation (+)
            // Since Strings are immutable, each concatenation creates a new object
            reversed = reversed + original.charAt(i);
        }

        // Display original and reversed string
        System.out.println("Original String : " + original);
        System.out.println("Reversed String : " + reversed);
        System.out.println();

        // Compare original and reversed using equals()
        if (original.equals(reversed)) {
            System.out.println("Result: \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + original + "\" is NOT a Palindrome.");
        }

        System.out.println();
        System.out.println("Program finished.");
    }
}