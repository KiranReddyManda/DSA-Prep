package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class removeKdigits {

    public static void main(String[] args) {
        System.out.println(removeKdigits("10", 2));
    }

    public static String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            while (!stack.isEmpty() && stack.peek() > ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
           res.append(stack.pop());
        }
        res.reverse();
        while(!res.isEmpty() && res.charAt(0)=='0'){
            res.deleteCharAt(0);
        }
        return res.isEmpty() ? "0" : res.toString();
    }
}
