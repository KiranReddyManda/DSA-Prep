package stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        System.out.println(nextGreaterElements(new int[] {1,2,1}));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                res[i] = -1;
            } else if (stack.peek() > nums[i]) {
                res[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            if (res[i]==-1 && stack.peek() > nums[i]){
                res[i] = stack.peek();
            }else if(res[i]==-1){
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
}
