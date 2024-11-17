package stack;

import java.util.Deque;
import java.util.LinkedList;

public class decodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> stringStack = new LinkedList<>();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                k = (k * 10) + ch - '0';
            } else if (ch == '[') {
                numStack.push(k);
                k = 0;
                stringStack.push(Character.toString(ch));
            } else if (ch == ']') {
                int repeatCount = numStack.pop();
                StringBuilder temp = new StringBuilder();
                while (!stringStack.isEmpty() && !stringStack.peek().equals("[")) {
                    temp.insert(0, stringStack.pop());
                }
                stringStack.pop();
                stringStack.push(temp.toString().repeat(repeatCount));

            } else {
                stringStack.push(Character.toString(ch));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stringStack.isEmpty()) {
            res.insert(0, stringStack.pop());
        }
        return res.toString();
    }
}
