/**
 * PalindromeCheckerApp
 *
 * UC1  - Application Entry & Welcome Message
 * UC2  - Hardcoded Palindrome Result
 * UC3  - Palindrome Using String Reverse
 * UC4  - Palindrome Using Character Array
 * UC5  - Palindrome Using Stack
 * UC6  - FIFO vs LIFO using Queue and Stack
 * UC7  - Palindrome Using Deque
 * UC8  - Palindrome Using Singly Linked List
 * UC9  - Recursive Palindrome Checker
 * UC10 - Case-Insensitive & Space-Ignored Palindrome
 * UC11 - Object-Oriented Palindrome Service
 * UC12 - Strategy Pattern for Palindrome Algorithms
 */

import java.util.*;

public class PalindromeCheckerApp {

    static final String APP_NAME = "PalindromeChecker";
    static final String APP_VERSION = "Version 2.0";


    // ===== UC8 Node Class =====
    static class Node {
        char data;
        Node next;
        Node(char d){
            data=d;
            next=null;
        }
    }


    // ===== UC9 Recursive Method =====
    static boolean isPalindromeRecursive(String str,int start,int end){

        if(start>=end)
            return true;

        if(str.charAt(start)!=str.charAt(end))
            return false;

        return isPalindromeRecursive(str,start+1,end-1);
    }


    // ===== UC11 OOP Palindrome Service =====
    static class PalindromeChecker {

        public boolean checkPalindrome(String text){

            char arr[] = text.toCharArray();

            int start=0;
            int end=arr.length-1;

            while(start<end){

                if(arr[start]!=arr[end])
                    return false;

                start++;
                end--;
            }

            return true;
        }
    }


    // ===== UC12 Strategy Interface =====
    interface PalindromeStrategy {
        boolean check(String text);
    }


    // Stack Strategy
    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String text){

            Stack<Character> stack=new Stack<>();

            for(char c:text.toCharArray())
                stack.push(c);

            for(char c:text.toCharArray()){
                if(c!=stack.pop())
                    return false;
            }

            return true;
        }
    }


    // Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String text){

            Deque<Character> deque=new ArrayDeque<>();

            for(char c:text.toCharArray())
                deque.addLast(c);

            while(deque.size()>1){

                if(deque.removeFirst()!=deque.removeLast())
                    return false;
            }

            return true;
        }
    }



    public static void main(String[] args) {

        // ===== UC1 =====
        System.out.println("=================================");
        System.out.println("Welcome to " + APP_NAME + " " + APP_VERSION);
        System.out.println("=================================");
        System.out.println();


        String original="madam";


        // ===== UC2 =====
        System.out.println("UC2 Result:");

        if(original.equals("madam"))
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC3 =====
        String reversed="";

        for(int i=original.length()-1;i>=0;i--)
            reversed+=original.charAt(i);

        System.out.println("UC3 Result:");

        if(original.equals(reversed))
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC4 =====
        char arr[]=original.toCharArray();

        int start=0,end=arr.length-1;
        boolean result4=true;

        while(start<end){
            if(arr[start]!=arr[end]){
                result4=false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4 Result:");

        if(result4)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC5 =====
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<original.length();i++)
            stack.push(original.charAt(i));

        boolean result5=true;

        for(int i=0;i<original.length();i++){
            if(original.charAt(i)!=stack.pop()){
                result5=false;
                break;
            }
        }

        System.out.println("UC5 Result:");

        if(result5)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC6 =====
        Queue<Character> queue=new LinkedList<>();
        Stack<Character> stack2=new Stack<>();

        for(int i=0;i<original.length();i++){
            queue.add(original.charAt(i));
            stack2.push(original.charAt(i));
        }

        boolean result6=true;

        for(int i=0;i<original.length();i++){
            if(queue.remove()!=stack2.pop()){
                result6=false;
                break;
            }
        }

        System.out.println("UC6 Result:");

        if(result6)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC7 =====
        Deque<Character> deque=new ArrayDeque<>();

        for(int i=0;i<original.length();i++)
            deque.addLast(original.charAt(i));

        boolean result7=true;

        while(deque.size()>1){
            if(deque.removeFirst()!=deque.removeLast()){
                result7=false;
                break;
            }
        }

        System.out.println("UC7 Result:");

        if(result7)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC8 =====
        Node head=null,tail=null;

        for(int i=0;i<original.length();i++){

            Node newNode=new Node(original.charAt(i));

            if(head==null){
                head=newNode;
                tail=newNode;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
        }

        Node slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node prev=null,curr=slow;

        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node first=head,second=prev;

        boolean result8=true;

        while(second!=null){
            if(first.data!=second.data){
                result8=false;
                break;
            }
            first=first.next;
            second=second.next;
        }

        System.out.println("UC8 Result:");

        if(result8)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC9 =====
        boolean result9=isPalindromeRecursive(original,0,original.length()-1);

        System.out.println("UC9 Result:");

        if(result9)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");

        System.out.println();


        // ===== UC10 =====
        String sentence="Madam In Eden Im Adam";

        String normalized=sentence
                .toLowerCase()
                .replaceAll("\\s+","");

        String reverse2="";

        for(int i=normalized.length()-1;i>=0;i--)
            reverse2+=normalized.charAt(i);

        System.out.println("UC10 Result:");

        if(normalized.equals(reverse2))
            System.out.println("\""+sentence+"\" is a Palindrome");
        else
            System.out.println("\""+sentence+"\" is NOT a Palindrome");

        System.out.println();


        // ===== UC11 =====
        PalindromeChecker service=new PalindromeChecker();

        boolean result11=service.checkPalindrome(original);

        System.out.println("UC11 Result:");

        if(result11)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");


        System.out.println();


        // ===== UC12 Strategy Pattern =====

        PalindromeStrategy strategy;

        strategy=new StackStrategy();

        boolean result12a=strategy.check(original);

        System.out.println("UC12 Stack Strategy Result:");

        if(result12a)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");


        strategy=new DequeStrategy();

        boolean result12b=strategy.check(original);

        System.out.println("UC12 Deque Strategy Result:");

        if(result12b)
            System.out.println(original+" is a Palindrome");
        else
            System.out.println(original+" is NOT a Palindrome");


        System.out.println();
        System.out.println("Program Finished");

    }
}