package stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int maxLeftHeight = height[0];
        int maxRightHeight = height[n - 1];

        int[] leftHeight = new int[n];
        leftHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeftHeight = Math.max(maxLeftHeight, height[i]);
            leftHeight[i] = maxLeftHeight;
        }

        int[] rightHeight = new int[n];
        rightHeight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRightHeight = Math.max(maxRightHeight, height[i]);
            rightHeight[i] = maxRightHeight;
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(leftHeight[i], rightHeight[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            sum += res[i] - height[i];
        }
        return sum;
    }

}
