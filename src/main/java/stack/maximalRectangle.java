package stack;

import java.util.Stack;

public class maximalRectangle {

    public static int maximalRectangle(char[][] charMatrix) {
        int len = charMatrix.length;
        int[][] intMatrix = new int[charMatrix.length][charMatrix[0].length];
        // Convert using method 1 (faster)
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix[i].length; j++) {
                intMatrix[i][j] = charMatrix[i][j] - '0';
            }
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            int[] prev = intMatrix[i - 1];
            int[] curr = intMatrix[i];
            for (int j = 0; j < curr.length; j++) {
                if (curr[j] == 1) {
                    curr[j] += prev[j];
                } else {
                    curr[j] = 0;
                }

            }
            intMatrix[i] = curr;
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, largestRectangleArea(intMatrix[i]));
        }
        return res;
    }

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        if (heights.length == 1) {
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
