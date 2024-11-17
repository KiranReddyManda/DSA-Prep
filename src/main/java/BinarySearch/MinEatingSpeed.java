package BinarySearch;

public class MinEatingSpeed {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = h;
        for (int x : piles) {
            high = Math.max(high, x);
        }
        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCompleteEating(piles, mid, h)) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean canCompleteEating(int[] piles, int possibleSolution, int hours) {
        int requiredhours = 0;
        for (int x : piles) {
            if (x <= possibleSolution) {
                requiredhours++;
            } else {
                requiredhours += Math.ceil((double) x / possibleSolution);
            }
        }
        return requiredhours <= hours;
    }
}
