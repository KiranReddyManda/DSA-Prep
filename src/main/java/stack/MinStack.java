package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> stack;
    Integer min;

    public MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else {
            if (val >= min) {
                stack.push(val);
            } else {
                stack.push((2 * val) - min);
                min = val;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
        } else {
            if (stack.peek() >= min) {
                stack.pop();
            } else {
                min = (2 * min) - stack.pop();
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            if (stack.peek() >= min) {
                return stack.pop();
            } else {
                return min;
            }
        }
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
