package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class LC_155 {
    static void main() {

    }
}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minTrack;

    public MinStack() {
        stack = new Stack<>();
        minTrack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minTrack.isEmpty())
        {
            minTrack.push(val);
        }
        else if (val < minTrack.peek())
        {
            minTrack.push(val);
        }
    }

    public void pop() {
        if (stack.peek() == minTrack.peek())
        {
            stack.pop();
            minTrack.pop();
        }
        else
        {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minTrack.isEmpty()) return stack.peek();
        return minTrack.peek();
    }
}
