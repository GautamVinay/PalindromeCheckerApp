public class PalindromeCheckerApp {

    // Application constants
    static final String APP_NAME = "PalindromeChecker";
    static final String APP_VERSION = "Version 1.0";

    public static void main(String[] args) {

        // Display welcome message
        System.out.println("=================================");
        System.out.println("      Welcome to " + APP_NAME + " " + APP_VERSION);
        System.out.println("=================================");
        System.out.println("This application checks whether a word or phrase is a palindrome.");
        System.out.println();

        // Hardcoded string (String Literal)
        String word = "madam";

        // Reverse the string
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        // Conditional Statement (if-else)
        if (word.equals(reversed)) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println();
        System.out.println("Program finished.");
    }
}