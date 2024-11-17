package stack;

import java.util.Deque;
import java.util.LinkedList;

public class calculate {
    public static void main(String[] args) {
        System.out.println(calculate("1-(     -2)"));
    }

    public static int calculate(String s) {
        int k = 0;
        int res = 0;
        int sign = 1;
        Deque<Integer> stringStack = new LinkedList<>();
        Boolean insideBracket = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                k = (k * 10) + ch - '0';
            } else if (ch == '+') {
                res += sign * k;
                k = 0;
                sign = 1;
            } else if (ch == '-') {
                res += sign * k;
                k = 0;
                sign = -1;
            } else if (ch == '(') {
                stringStack.push(res);
                stringStack.push(sign);
                // reset
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res += sign * k;
                k = 0;

                res *= stringStack.pop();
                res += stringStack.pop();
            }
        }
        res += sign * k;
        return res;
    }


}
