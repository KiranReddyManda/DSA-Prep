package stack;

import java.util.ArrayList;
import java.util.Stack;

public class CalculateStockSpan {
    public static void main(String[] args) {
        System.out.println(calculateSpan(new int[]{100, 80, 60, 70, 60, 75, 85}));
    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int[] current = new int[]{i, arr[i]};
            if (stack.isEmpty()) {
                al.add(1);
            } else if (stack.peek()[1] > arr[i]) {
                al.add(i - stack.peek()[0]);
            } else {
                while (!stack.isEmpty() && stack.peek()[1] <= arr[i]) {
                    stack.pop();
                }
                int res = stack.isEmpty() ? 1 : i - stack.peek()[0];
                al.add(res);
            }
            stack.push(current);
        }
        return al;
    }
}
