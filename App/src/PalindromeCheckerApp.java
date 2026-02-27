/**
 * PalindromeCheckerApp
 *
 * UC1 - Application Entry & Welcome Message
 * UC2 - Hardcoded Palindrome Result
 * UC3 - Palindrome Using String Reverse
 * UC4 - Palindrome Using Character Array (Two Pointer)
 * UC5 - Palindrome Using Stack
 * UC6 - FIFO vs LIFO using Queue and Stack
 * UC7 - Palindrome Using Deque
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    static final String APP_NAME = "PalindromeChecker";
    static final String APP_VERSION = "Version 2.0";

    public static void main(String[] args) {

        // ========== UC1 ==========
        // Welcome Message

        System.out.println("=================================");
        System.out.println("Welcome to " + APP_NAME + " " + APP_VERSION);
        System.out.println("=================================");
        System.out.println();


        // ========== UC2 ==========
        // Hardcoded Palindrome

        String original = "madam";

        System.out.println("UC2 Result:");

        if(original.equals("madam"))
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is NOT a Palindrome");

        System.out.println();


        // ========== UC3 ==========
        // Reverse String Method

        String reversed = "";

        for(int i = original.length()-1; i>=0; i--)
            reversed = reversed + original.charAt(i);

        System.out.println("UC3 Result:");

        if(original.equals(reversed))
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is NOT a Palindrome");

        System.out.println();


        // ========== UC4 ==========
        // Character Array Two Pointer

        char[] arr = original.toCharArray();

        int start = 0;
        int end = arr.length-1;

        boolean result4 = true;

        while(start < end)
        {
            if(arr[start] != arr[end])
            {
                result4 = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4 Result:");

        if(result4)
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is NOT a Palindrome");

        System.out.println();


        // ========== UC5 ==========
        // Stack Method

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<original.length();i++)
            stack.push(original.charAt(i));

        boolean result5 = true;

        for(int i=0;i<original.length();i++)
        {
            if(original.charAt(i)!=stack.pop())
            {
                result5=false;
                break;
            }
        }

        System.out.println("UC5 Result:");

        if(result5)
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is NOT a Palindrome");

        System.out.println();


        // ========== UC6 ==========
        // Queue vs Stack

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=0;i<original.length();i++)
        {
            queue.add(original.charAt(i));
            stack2.push(original.charAt(i));
        }

        boolean result6 = true;

        for(int i=0;i<original.length();i++)
        {
            if(queue.remove()!=stack2.pop())
            {
                result6=false;
                break;
            }
        }

        System.out.println("UC6 Result:");

        if(result6)
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is NOT a Palindrome");

        System.out.println();


        // ========== UC7 ==========
        // Deque Method (Front and Rear Comparison)

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters
        for(int i=0;i<original.length();i++)
            deque.addLast(original.charAt(i));

        boolean result7 = true;

        // Remove first and last and compare
        while(deque.size() > 1)
        {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if(first != last)
            {
                result7 = false;
                break;
            }
        }

        System.out.println("UC7 Result:");

        if(result7)
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is NOT a Palindrome");

        System.out.println();
        System.out.println("Program Finished");

    }
}