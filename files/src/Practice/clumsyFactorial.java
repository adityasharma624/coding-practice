package Practice;

import java.util.Stack;

public class clumsyFactorial {
    static void main() {
        int n = 10;
        System.out.println(clumsyFact(10));
    }

    // 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.
    // 1 * 2 - 3 + 4 / 5 * 6 - 7 + 8 / 9 * 10.
    static int clumsyFact(int n)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        int op = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (op % 4 == 0) {          // *
                stack.push(stack.pop() * i);
            } else if (op % 4 == 1) {   // /
                stack.push(stack.pop() / i);
            } else if (op % 4 == 2) {   // +
                stack.push(i);
            } else {                    // -
                stack.push(-i);
            }
            op++;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
