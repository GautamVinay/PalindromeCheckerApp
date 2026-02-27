import java.util.*;

class PalindromeCheckerApp {

    static final String APP_NAME = "PalindromeChecker";
    static final String APP_VERSION = "Version 2.0";


    // ===== UC8 Node =====
    static class Node {
        char data;
        Node next;

        Node(char d) {
            data = d;
        }
    }


    // ===== UC9 Recursion =====
    static boolean isPalindromeRecursive(String s, int start, int end) {

        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return isPalindromeRecursive(s, start + 1, end - 1);
    }


    // ===== UC11 Service =====
    static class PalindromeChecker {

        boolean checkPalindrome(String text) {

            char[] arr = text.toCharArray();

            int start = 0;
            int end = arr.length - 1;

            while (start < end) {

                if (arr[start] != arr[end])
                    return false;

                start++;
                end--;
            }

            return true;
        }
    }


    // ===== UC12 Strategy =====

    interface PalindromeStrategy {
        boolean check(String text);
    }


    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String text) {

            Stack<Character> stack = new Stack<>();

            for (char c : text.toCharArray())
                stack.push(c);

            for (char c : text.toCharArray())
                if (c != stack.pop())
                    return false;

            return true;
        }
    }


    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String text) {

            Deque<Character> dq = new ArrayDeque<>();

            for (char c : text.toCharArray())
                dq.addLast(c);

            while (dq.size() > 1) {

                char a = dq.removeFirst();
                char b = dq.removeLast();

                if (a != b)
                    return false;
            }

            return true;
        }
    }



    public static void main(String[] args) {

        String original = "madam";
        char[] arr = original.toCharArray();


        // ===== UC1 =====
        System.out.println(APP_NAME + " " + APP_VERSION);
        System.out.println();



        // ===== UC2 =====

        System.out.println("UC2 Result:");

        if ("madam".equals(original))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        System.out.println();



        // ===== UC3 =====

        StringBuilder revBuilder = new StringBuilder();

        for (int i = original.length() - 1; i >= 0; i--)
            revBuilder.append(original.charAt(i));

        String rev = revBuilder.toString();

        System.out.println("UC3 Result:");
        System.out.println(original.equals(rev) ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC4 =====

        int start = 0;
        int end = arr.length - 1;

        boolean r4 = true;

        while (start < end) {

            if (arr[start] != arr[end]) {
                r4 = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("UC4 Result:");
        System.out.println(r4 ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC5 =====

        Stack<Character> st = new Stack<>();

        for (char c : arr)
            st.push(c);

        boolean r5 = true;

        for (char c : arr) {

            if (st.isEmpty() || c != st.pop()) {
                r5 = false;
                break;
            }
        }

        System.out.println("UC5 Result:");
        System.out.println(r5 ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC6 =====

        Queue<Character> q = new LinkedList<>();
        Stack<Character> st2 = new Stack<>();

        for (char c : arr) {
            q.add(c);
            st2.push(c);
        }

        boolean r6 = true;

        for (int i = 0; i < arr.length; i++) {

            if (q.remove() != st2.pop()) {
                r6 = false;
                break;
            }
        }

        System.out.println("UC6 Result:");
        System.out.println(r6 ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC7 =====

        Deque<Character> dq = new ArrayDeque<>();

        for (char c : arr)
            dq.addLast(c);

        boolean r7 = true;

        while (dq.size() > 1) {

            if (dq.removeFirst() != dq.removeLast()) {
                r7 = false;
                break;
            }
        }

        System.out.println("UC7 Result:");
        System.out.println(r7 ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC8 =====

        Node head = null;
        Node tail = null;

        for (char c : arr) {

            Node n = new Node(c);

            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }

        ArrayList<Character> list = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        boolean r8 = true;

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {

            if (!list.get(i).equals(list.get(j))) {
                r8 = false;
                break;
            }

            i++;
            j--;
        }

        System.out.println("UC8 Result:");
        System.out.println(r8 ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC9 =====

        boolean r9 = isPalindromeRecursive(original, 0, original.length() - 1);

        System.out.println("UC9 Result:");
        System.out.println(r9 ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC10 =====

        String sentence = "Madam In Eden Im Adam";

        String norm = sentence.toLowerCase().replaceAll("\\s+", "");

        String rev2 = new StringBuilder(norm).reverse().toString();

        System.out.println("UC10 Result:");
        System.out.println(norm.equals(rev2) ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC11 =====

        PalindromeChecker service = new PalindromeChecker();

        boolean r11 = service.checkPalindrome(original);

        System.out.println("UC11 Result:");
        System.out.println(r11 ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC12 =====

        PalindromeStrategy strategy;

        strategy = new StackStrategy();
        System.out.println("UC12 Stack Strategy:");
        System.out.println(strategy.check(original) ? "Palindrome" : "Not Palindrome");

        strategy = new DequeStrategy();
        System.out.println("UC12 Deque Strategy:");
        System.out.println(strategy.check(original) ? "Palindrome" : "Not Palindrome");

        System.out.println();



        // ===== UC13 =====

        System.out.println("UC13 Performance Comparison");

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        service.checkPalindrome(original);
        endTime = System.nanoTime();
        System.out.println("Char Array Time: " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        new StackStrategy().check(original);
        endTime = System.nanoTime();
        System.out.println("Stack Time: " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        new DequeStrategy().check(original);
        endTime = System.nanoTime();
        System.out.println("Deque Time: " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        isPalindromeRecursive(original, 0, original.length() - 1);
        endTime = System.nanoTime();
        System.out.println("Recursion Time: " + (endTime - startTime) + " ns");


        System.out.println("\nProgram Finished");

    }
}