package BinarySearch;

public class SingleNonDuplicate {

    public static void main(String[] args) {

    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure `mid` is even so we can compare `mid` with `mid + 1`
            if (mid % 2 == 1) {
                mid--; // Make mid even
            }

            // Check the condition and handle edge cases
            if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                // If in the correct pattern (pair on the left side), move right
                low = mid + 2;
            } else {
                // If not in the correct pattern, move left
                high = mid;
            }
        }

        // At the end of the loop, `low` will be the index of the single element
        return nums[low];
    }

}



