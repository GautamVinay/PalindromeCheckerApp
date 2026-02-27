/**
 * PalindromeCheckerApp
 *
 * UC1 - Application Entry & Welcome Message
 * UC2 - Hardcoded Palindrome Result
 * UC3 - Palindrome Using String Reverse
 * UC4 - Palindrome Using Character Array (Two-Pointer)
 */

public class PalindromeCheckerApp {

    // Application constants
    static final String APP_NAME = "PalindromeChecker";
    static final String APP_VERSION = "Version 2.0";

    public static void main(String[] args) {

        // ================= UC1 =================
        // Welcome Message

        System.out.println("=================================");
        System.out.println("Welcome to " + APP_NAME + " " + APP_VERSION);
        System.out.println("=================================");
        System.out.println("This application checks whether a word is a palindrome.");
        System.out.println();


        // ================= UC2 =================
        // Hardcoded Palindrome Result

        String original = "madam";

        if(original.equals("madam")) {
            System.out.println("UC2 Result:");
            System.out.println(original + " is a Palindrome");
        }
        else {
            System.out.println("UC2 Result:");
            System.out.println(original + " is NOT a Palindrome");
        }

        System.out.println();


        // ================= UC3 =================
        // Palindrome Using String Reverse

        String reversed = "";

        for(int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        System.out.println("UC3 Result (Using String Reverse):");

        if(original.equals(reversed)) {
            System.out.println(original + " is a Palindrome");
        }
        else {
            System.out.println(original + " is NOT a Palindrome");
        }

        System.out.println();


        // ================= UC4 =================
        // Palindrome Using Character Array (Two Pointer)

        char[] characters = original.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        while(start < end) {

            if(characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("UC4 Result (Using Character Array):");

        if(isPalindrome) {
            System.out.println(original + " is a Palindrome");
        }
        else {
            System.out.println(original + " is NOT a Palindrome");
        }

        System.out.println();
        System.out.println("Program Finished.");

    }
}