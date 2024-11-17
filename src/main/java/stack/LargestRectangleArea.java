package stack;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,4}));
    }

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        if(heights.length==1){
            return heights[0];
        }
        int[] NSL = getNextSmallLeft(heights);
        int[] NSR = getNextSmallRight(heights);
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (NSR[i] - NSL[i] - 1) * heights[i]);
        }
        return res;
    }

    private static int[] getNextSmallRight(int[] heights) {
        int[] res = new int[heights.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int[] current = new int[]{i, heights[i]};
            if (stack.isEmpty()) {
                res[i] = heights.length;
            } else if (stack.peek()[1] < heights[i]) {
                res[i] = stack.peek()[0];
            } else {
                while (!stack.isEmpty() && (stack.peek()[1] >= heights[i])) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? heights.length : stack.peek()[0];
            }
            stack.push(current);
        }
        return res;
    }

    private static int[] getNextSmallLeft(int[] heights) {
        int[] res = new int[heights.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int[] current = new int[]{i, heights[i]};
            if (stack.isEmpty()) {
                res[i] = -1;
            } else if (stack.peek()[1] < heights[i]) {
                res[i] = stack.peek()[0];
            } else {
                while (!stack.isEmpty() && (stack.peek()[1] >= heights[i])) {
                    stack.pop();
                }
                int temp = stack.isEmpty() ? -1 : stack.peek()[0];
                res[i] = temp;
            }
            stack.push(current);
        }
        return res;
    }
}
