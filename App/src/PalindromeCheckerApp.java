/**
 * PalindromeCheckerApp
 *
 * UC1 - Application Entry & Welcome Message
 * UC2 - Hardcoded Palindrome Result
 * UC3 - Palindrome Using String Reverse
 * UC4 - Palindrome Using Character Array (Two-Pointer)
 * UC5 - Palindrome Using Stack
 * UC6 - FIFO vs LIFO using Queue and Stack
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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

        System.out.println("UC2 Result:");

        if(original.equals("madam")) {
            System.out.println(original + " is a Palindrome");
        }
        else {
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
        // Palindrome Using Character Array

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


        // ================= UC5 =================
        // Palindrome Using Stack

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        boolean stackPalindrome = true;

        for(int i = 0; i < original.length(); i++) {

            if(original.charAt(i) != stack.pop()) {
                stackPalindrome = false;
                break;
            }
        }

        System.out.println("UC5 Result (Using Stack):");

        if(stackPalindrome) {
            System.out.println(original + " is a Palindrome");
        }
        else {
            System.out.println(original + " is NOT a Palindrome");
        }

        System.out.println();


        // ================= UC6 =================
        // FIFO vs LIFO using Queue and Stack

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        // Insert characters
        for(int i = 0; i < original.length(); i++) {
            queue.add(original.charAt(i));   // Enqueue
            stack2.push(original.charAt(i)); // Push
        }

        boolean fifoLifoPalindrome = true;

        // Compare dequeue and pop
        for(int i = 0; i < original.length(); i++) {

            if(queue.remove() != stack2.pop()) {
                fifoLifoPalindrome = false;
                break;
            }
        }

        System.out.println("UC6 Result (Queue vs Stack):");

        if(fifoLifoPalindrome) {
            System.out.println(original + " is a Palindrome");
        }
        else {
            System.out.println(original + " is NOT a Palindrome");
        }

        System.out.println();
        System.out.println("Program Finished.");

    }
}