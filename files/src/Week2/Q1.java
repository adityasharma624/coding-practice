package Week2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Q1 {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();
        Stack<Integer> processed = new Stack<>();

        // Return mein deque ke end mein books enter karna hoga, since strict order maintain karna hoga.
        // Process mein queue ke front se remove karna hoga, aur stack mein push
        // undo mein stack pop
        // next mein peek queue ke front mein

        loop: while (scanner.hasNext()) {
            String operation = scanner.next();

            switch (operation) {
                case "RETURN":
                    int bookId = scanner.nextInt();
                    queue.addLast(bookId);
                    break;

                case "PROCESS":
                    if (!queue.isEmpty()) {
                        int book = queue.removeFirst();
                        processed.push(book);
                    }
                    break;

                case "UNDO":
                    if (!processed.isEmpty()) {
                        int book = processed.pop();
                        queue.addFirst(book);
                    }
                    break;

                case "NEXT":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peekFirst());
                    }
                    break;

                case "EXIT":
                    break loop;
            }
        }

        scanner.close();
    }
}
